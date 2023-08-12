package Trees.AlgoExpert;

import Utils.AlgoExpert.BinaryTree;

public class BinaryTreeDiameter {
    public static void main(String[] args) {

    }
    public int[] getDiameter(BinaryTree node){
        if(node == null)
            return new int[]{0, 0}; // 1. dia 2. depth

        int left[] = 	getDiameter(node.left);
        int right[] = getDiameter(node.right);

        int depth = Math.max(left[1], right[1]) + 1;
        int diameter = Math.max(Math.max(left[0], right[0]), left[1] + right[1]);

        return new int[]{diameter, depth};
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        return getDiameter(tree)[0];
    }
}
