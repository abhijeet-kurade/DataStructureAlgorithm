package SegmentTree.RangeSum.WithClass;

public class SegmentTree {
    class Node {
        int val;
        int min, max;
        Node left, right;

        public Node() {
        }

        public Node(int val, int min, int max) {
            this.val = val;
            this.min = min;
            this.max = max;
        }
    }
    Node root;

    public SegmentTree(int[] arr){
        this.root = constructSegmentTree(arr, 0, arr.length-1);
    }

    public Node constructSegmentTree(int[] arr, int min, int max){
        if(min == max){
            Node node = new Node(arr[max], min, max);
            return node;
        }
        int mid = min + (max - min) / 2;
        Node node = new Node();
        node.left = constructSegmentTree(arr, min,mid);
        node.right = constructSegmentTree(arr, mid+1, max);
        node.val = node.left.val + node.right.val;
        return node;
    }

    public void set(int idx, int val){
        set(this.root, idx, val);
    }

    private void set(Node node, int idx, int val){
        if(node.min == node.max && node.min == idx){
            node.val = val;
            return;
        }
        if(idx<node.min || node.max < idx) {
            return;
        }
        set(node.left, idx, val);
        set(node.left, idx, val);
        node.val = node.left.val + node.right.val;
        return;
    }

    public int rangeSum(int min, int max){
        return rangeSum(this.root, min, max);
    }
    private int rangeSum(Node node, int min, int max){
        if(min <= node.min &&  node.max <= max){
            return node.val;
        }
        if( max < node.min || node.max < min){
            return 0;
        }
        int sum = rangeSum(node.left, min, max) + rangeSum(node.right, min, max);
        return sum;
    }
}
