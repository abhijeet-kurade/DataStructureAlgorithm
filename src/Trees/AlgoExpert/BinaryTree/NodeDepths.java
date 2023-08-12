package Trees.AlgoExpert.BinaryTree;

import Utils.AlgoExpert.BinaryTree;

public class NodeDepths {


    public static int nodeDepthSum(BinaryTree node, int depth){
        if(node == null) return 0;
        int left = nodeDepthSum(node.left, depth+1) ;
        int right =  nodeDepthSum(node.right, depth+1) ;
        return depth + left + right;

    }
    public static int nodeDepths(BinaryTree root) {
        return nodeDepthSum(root, 0);
    }
}
