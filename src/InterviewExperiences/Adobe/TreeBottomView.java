package InterviewExperiences.Adobe;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeBottomView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);


        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);


        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(11);

        for(int n : bottomViewTree(root)){
            System.out.print(n+" ");
        }
    }

    public static int[] bottomViewTree(TreeNode root){
        int[] boundaries = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        Map<Integer, Integer> view = new HashMap<>();
        Map<Integer, Integer> depth =  new HashMap<>();
        dfs(root, 0, 0, view, depth, boundaries);
        int l = boundaries[1] - boundaries[0] + 1;
        int[] ans = new int[l];
        for(int idx : view.keySet()){
            ans[idx + Math.abs(boundaries[0])] = view.get(idx);
        }
        return ans;
    }

    private static void dfs(TreeNode node, int idx, int d, Map<Integer, Integer> view,Map<Integer, Integer> depth, int[] boundaries){
        if(node == null) return;
        boundaries[0] = Math.min(boundaries[0], idx);
        boundaries[1] = Math.max(boundaries[1], idx);
        if(!view.containsKey(idx)){
            view.put(idx, node.val);
            depth.put(node.val, d);
        }
        else{
            int last_depth = depth.get(view.get(idx));
            if(last_depth<d){
                view.put(idx, node.val);
                depth.put(node.val, d);
            }
        }
        dfs(node.left, idx-1, d+1, view, depth, boundaries);
        dfs(node.right, idx+1, d+1, view, depth, boundaries);
    }
}
