package Trees.AlgoExpert;

import Utils.AlgoExpert.BinaryTree;

public class InvertBinaryTree {
    public static void main(String[] args) {

    }
    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null) return;
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

}
