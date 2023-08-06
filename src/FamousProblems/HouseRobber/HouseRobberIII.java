package FamousProblems.HouseRobber;

import Utils.LeetcodeTree.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] robH = robHouse(root);
        return Math.max(robH[0], robH[1]);
    }

    private int[] robHouse(TreeNode node){
        if(node == null) return new int[2];

        int[] left = robHouse(node.left);
        int[] right = robHouse(node.right);

        int withCurr = node.val + left[1] + right[1];
        int withoutCurr = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{withCurr, withoutCurr};
    }
}
