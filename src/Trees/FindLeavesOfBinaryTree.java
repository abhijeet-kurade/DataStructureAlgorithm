package Trees;


import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-leaves-of-binary-tree/
public class FindLeavesOfBinaryTree {


    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        if(leaves.size() == 0) leaves.add(new ArrayList<>());
        getLeaf(root, leaves);
        return leaves;
    }
    public int getLeaf(TreeNode node, List<List<Integer>> leaves){
        if(node.left == null && node.right == null){
            leaves.get(0).add(node.val);
            return 1;
        }
        int height = 0;
        if(node.left != null) height = Math.max(height, getLeaf(node.left, leaves));
        if(node.right != null)  height = Math.max(height, getLeaf(node.right, leaves));

        height += 1;
        if(leaves.size() < height) leaves.add(new ArrayList<>());
        leaves.get(height-1).add(node.val);
        return height;
    }

}
