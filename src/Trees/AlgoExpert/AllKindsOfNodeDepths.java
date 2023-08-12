package Trees.AlgoExpert;

import Utils.AlgoExpert.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class AllKindsOfNodeDepths {
    public static void main(String[] args) {

    }
    public static int allKindsOfNodeDepths(BinaryTree root) {
        return allNodes(root, 0);
    }

    public  static int allNodes(BinaryTree node, int depth){
        if(node == null) return 0;
        int contribution = ( depth * (depth + 1) ) / 2;
        depth += 1;
        int left = allNodes(node.left, depth);
        int right = allNodes(node.right, depth);

        return  left + contribution + right;
    }


    public static int allKindsOfNodeDepths1(BinaryTree root) {
        if(root == null) return 0;
        Queue<BinaryTree> queue = new LinkedList<>();
        int sum = 0;
        int depth = -1;
        queue.add(root);
        while (!queue.isEmpty()){
            depth += 1;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int contribution = (depth * (depth + 1)) / 2;
                sum += contribution;
                BinaryTree node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right !=null) queue.add(node.right);
            }
        }
        return sum;
    }
}
