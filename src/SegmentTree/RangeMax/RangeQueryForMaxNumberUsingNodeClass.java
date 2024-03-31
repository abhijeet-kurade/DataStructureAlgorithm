package SegmentTree.RangeMax;

public class RangeQueryForMaxNumberUsingNodeClass {
    public static void main(String[] args) {

        int[] arr = {221,215,87,45,22,123,567,213,33};
        int[][]  queries   = {{0,8},{3,5},{2,5},{3,6}};
        getMaxInRange(arr,  queries);
    }

    public static int[] getMaxInRange(int[] arr, int[][] queries){

        Node root = buildSegmentTree(arr, 0, arr.length-1);

        int[] answer   = new int[queries.length];


        int idx = 0;
        for(int[]  query :  queries){
            int left = query[0], right = query[1];
            answer[idx] =  getMaxInRageInSegmentTree(root, left, right);
            idx += 1;
        }
        return answer;
    }

    public static int getMaxInRageInSegmentTree(Node node, int left, int  right){
        if(right < node.min || node.max <  left) return Integer.MIN_VALUE;

        if(left  <= node.min && node.max <= right ){
            return node.val;
        }

        int l = getMaxInRageInSegmentTree(node.left, left,  right);
        int r = getMaxInRageInSegmentTree(node.right, left,  right);

        return Math.max(l, r);
    }

    public static Node buildSegmentTree(int[]  arr, int left, int right){
        if(left > right) return null;
        Node node = new Node(left, right);
        if(left == right){
            node.val = arr[left];
            return node;
        }
        int mid = left + (right - left ) / 2;
        node.left = buildSegmentTree(arr, left, mid);
        node.right = buildSegmentTree(arr, mid+1, right);
        node.val = Math.max(node.left != null ? node.left.val : Integer.MIN_VALUE, node.right != null ? node.right.val : Integer.MIN_VALUE);
        return node;
    }

    public static class Node{
        public int val;
        int min, max;
        public Node left, right;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}

/* The functions which
builds the segment tree */
class GfG
{
    public static Node root;
    public static class Node{
        public int val;
        int min, max;
        public Node left, right;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static Node buildSegmentTree(int[]  arr, int left, int right){
        if(left > right) return null;
        Node node = new Node(left, right);
        if(left == right){
            node.val = arr[left];
            return node;
        }
        int mid = left + (right - left ) / 2;
        node.left = buildSegmentTree(arr, left, mid);
        node.right = buildSegmentTree(arr, mid+1, right);
        node.val = Math.min(node.left != null ? node.left.val : Integer.MAX_VALUE, node.right != null ? node.right.val : Integer.MAX_VALUE);
        return node;
    }

    public static int getMinInRageInSegmentTree(Node node, int left, int  right){
        if(right < node.min || node.max <  left) return Integer.MAX_VALUE;

        if(left  <= node.min && node.max <= right ){
            return node.val;
        }

        int l = getMinInRageInSegmentTree(node.left, left,  right);
        int r = getMinInRageInSegmentTree(node.right, left,  right);

        return Math.min(l, r);
    }

    static int st[];

    public static int[] constructST(int arr[], int n)
    {
        // Add your code here
        root =  buildSegmentTree(arr, 0,  arr.length-1);
        return null;
    }


    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r)
    {
        // Add your code here
        return getMinInRageInSegmentTree(root, l, r);
    }


}