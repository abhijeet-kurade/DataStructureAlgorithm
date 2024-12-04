package BinarySearchTree;

import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
*
* You're given a Binary Tree. As with any Binary Tree, this tree may contain one or more Binary Search Trees (BSTs), and it may even be a BST itself.
Write a function that returns the sum of all the values of nodes in this tree which are part of a BST containing at least 3 nodes.
Each BinaryTree node has an integer value, a left child node, and a right child node.
Children nodes can either be BinaryTree nodes themselves or None / null.
A BST is a special type of Binary Tree whose nodes all satisfy the BST property. A node satisfies the BST property if its value is strictly greater
* than the values of every node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid BST nodes themselves or None / null.
*
* */
public class SumBsts {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(10);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(15);
        root.right.left.left = new TreeNode(2);
        root.right.left.right = new TreeNode(5);
        root.right.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(22);
        root.right.right.left.right = new TreeNode(14);

        System.out.println(sumBsts(root));
    }

    static class NodeData{
        boolean isBST;
        int sum;
        int nodes;

        int min, max;

        public NodeData(boolean isBST, int sum, int nodes, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.nodes = nodes;
            this.min = min;
            this.max = max;
        }

        public NodeData(boolean isBST) {
            this.isBST = isBST;
        }
    }

    public static int sumBsts(TreeNode root){
        Map<TreeNode, Integer> sums = new HashMap<>();
        isBST(root, sums);
        return collectSum(root, sums);
    }

    private static int collectSum(TreeNode node, Map<TreeNode, Integer> sums){
        if(node == null) return 0;
        if(sums.containsKey(node)){
            return sums.get(node);
        }
        int left = collectSum(node.left, sums);
        int right = collectSum(node.right, sums);
        return left + right;
    }

    private static NodeData isBST(TreeNode node, Map<TreeNode, Integer> sums){
        if(node == null){
            return new NodeData(true, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeData left = isBST(node.left, sums);
        NodeData right = isBST(node.right, sums);
        boolean mIbst = left.max < node.val && node.val <= right.min;
        mIbst = mIbst && left.isBST && right.isBST;

        if(mIbst){
            int sum = node.val+ left.sum+ right.sum;
            int nodes = 1 + left.nodes + right.nodes;
            int min = left.min == Integer.MAX_VALUE ? node.val : left.min;
            int max = right.max == Integer.MIN_VALUE ? node.val : right.max;
            if(nodes >= 3) sums.put(node, sum);
            return new NodeData(mIbst, sum, nodes, min, max);
        }
        return new NodeData(false);
    }
}
