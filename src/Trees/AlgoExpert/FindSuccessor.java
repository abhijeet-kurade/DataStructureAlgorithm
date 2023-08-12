package Trees.AlgoExpert;

import Utils.AlgoExpert.BinaryTree;

public class FindSuccessor {
    public static void main(String[] args) {

    }


    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if(node.right != null){
            BinaryTree successor = node.right;
            while(successor.left != null)
                successor = successor.left;
            return successor;
        }
        else{
            BinaryTree node_parent = node.parent;
            while(node_parent != null && node_parent.left != node){
                node = node_parent;
                node_parent = node_parent.parent;
            }
            return node_parent;
        }
    }

}
