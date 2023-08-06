package BinaryTree;

public class GetDirection {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.right.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(12);

        GetDirection g = new GetDirection();
        //g.getDirections(root, 9, 10);

        StringBuilder sb = new StringBuilder("0123456789");
        for(int i=0; i<sb.length(); i++){
            sb.replace(i, i+1,"U");
        }
        System.out.println(sb);
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        TreeNode lca = leastCommonAncestor(root, startValue, destValue, new int[]{0});



        if(lca.val == startValue){
            StringBuilder path = new StringBuilder();
            getPath(lca, path, destValue);
            return path.reverse().toString();
        }

        if(lca.val == destValue){
            StringBuilder path = new StringBuilder();
            getPath(lca, path, startValue);
            for(int i=0; i<path.length(); i++){
                path.replace(i, i+1,"U");
            }
            return path.toString();
        }



        return "";
    }

    public TreeNode leastCommonAncestor(TreeNode node, int child1, int child2,  int[] count ){
        if(node == null) return null;

        TreeNode left = leastCommonAncestor(node.left, child1, child2, count);
        if(count[0] == 2){
            return left;
        }

        TreeNode right = leastCommonAncestor(node.right, child1, child2, count);
        if(count[0] == 2){
            return right;
        }
        if(node.val == child1 || node.val == child2){
            count[0] += 1;
        }

        if(count[0] == 2){
            return node;
        }

        return null;
    }

    public boolean getPath(TreeNode node, StringBuilder path, int target){
        if(node == null) return false;

        if(node.val == target){
            return true;
        }

        boolean left = getPath(node.left, path, target);

        if(left){
            path.append('L');
            return true;
        }

        boolean right = getPath(node.right, path, target);

        if(right){
            path.append('R');
            return true;
        }

        return false;
    }
}
