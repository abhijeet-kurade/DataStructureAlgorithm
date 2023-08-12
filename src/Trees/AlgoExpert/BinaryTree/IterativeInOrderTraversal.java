package Trees.AlgoExpert.BinaryTree;

import Utils.AlgoExpert.BinaryTree;

import java.util.function.Function;

public class IterativeInOrderTraversal {

    public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {

        BinaryTree prev = null;
        BinaryTree curr = tree;

        while (curr != null){
            BinaryTree next = null;

            if(curr.right == prev && prev != null) next = curr.parent;
            else if(curr.left == null || prev == curr.left){
                System.out.println(curr.value);
                callback.apply(curr);
                next = curr.right != null ? curr.right : curr.parent;
            }
            else if(curr.left != null) next = curr.left;

            prev = curr;
            curr = next;
        }

    }

}
