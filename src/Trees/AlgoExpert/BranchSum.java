package Trees.AlgoExpert;

import Utils.AlgoExpert.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {

    public static void main(String[] args) {

    }
    public static List<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> sum = new ArrayList<>();
        branchSum(root, 0, sum);
        return sum;
    }
    public static void branchSum(BinaryTree node, int curr,  ArrayList<Integer> sum){
        if(node.left == null && node.right==null){
            sum.add(curr);
        }
        curr += node.value;
        if(node.left != null) branchSum(node.left, curr, sum);
        if(node.right != null) branchSum(node.right, curr, sum);

    }
}
