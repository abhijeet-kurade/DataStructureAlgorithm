package FenwickTree;

public class FenwickTree {

    int[] tree;
    public static void main(String[] args) {

    }

    public FenwickTree(int[] arr){
        this.tree  = new int[arr.length + 1];
    }

    private void construct(){

    }

    public int getSum(int idx){
        int sum = 0;
        while (idx > 0){
            sum += this.tree[idx];
        }
        return -1;
    }
}
