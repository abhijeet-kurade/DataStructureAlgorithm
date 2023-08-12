package Trees.AlgoExpert.BinaryTree;

import Utils.AlgoExpert.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inOrderTraverse(BinaryTree tree, List<Integer> array) {

    Stack<BinaryTree> stack = new Stack<>();
    BinaryTree prev = null;
    BinaryTree curr = tree;


    while (curr != null || !stack.isEmpty()){
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        array.add(curr.value);
        System.out.println(curr.value);
        curr = curr.right;
    }


    return new ArrayList<Integer>();
}

}
