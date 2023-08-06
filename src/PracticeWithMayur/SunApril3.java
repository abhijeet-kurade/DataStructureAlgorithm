package PracticeWithMayur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SunApril3 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    // https://leetcode.com/problems/snapshot-array/
    class SnapshotArray {

        List<Map<Integer, Integer>> snaps;

        public SnapshotArray(int length) {
            Map<Integer, Integer> curr = new HashMap<>();
            for(int i=0; i<length; i++) curr.put(i, 0);
            snaps = new ArrayList<>();
            snaps.add(curr);
        }

        public void set(int index, int val) {
            Map<Integer, Integer> curr = snaps.get(snaps.size()-1);
            curr.put(index, val);
        }

        public int snap() {
            int id = snaps.size()-1;
            Map<Integer, Integer> curr = new HashMap<>();
            snaps.add(curr);
            return id;
        }

        public int get(int index, int snap_id) {
            while(snaps.get(snap_id).get(index) == null){
                snap_id -= 1;
            }
            return snaps.get(snap_id).get(index);
        }
    }


    // https://leetcode.com/problems/decode-string/
    public String decodeString(String s) {
        int n = s.length();
        StringBuilder decoded = new StringBuilder();
        int idx = 0;
        String dcode = "";
        while(idx < n){
            char c = s.charAt(idx);
            if(0 <= (c-'0') && (c-'0')<=9){
                int b = idx;
                while(s.charAt(b) != '[') b += 1;
                int mul = Integer.parseInt(s.substring(idx, b));
                int last = getNextBrac(s, b);
                for(int i=0; i<mul; i++){
                    dcode += decodeString(s.substring(b+1, last));
                }
                idx = last+1;
            }
            else {
                idx += 1;
                dcode += c;
            }
        }
        return dcode;
    }
    public int getNextBrac(String str, int idx){
        int count = 1;
        int last =idx;
        for(int i=idx+1; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == ']'){
                count -= 1;
                if(count == 0){
                    last = i;
                    break;
                }
            }
            else if(c == '[') count += 1;
        }
        return last;
    }


    // https://leetcode.com/problems/find-leaves-of-binary-tree/submissions/
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        if(leaves.size() == 0) leaves.add(new ArrayList<>());
        getLeaf(root, leaves);
        return leaves;
    }
    public int getLeaf(TreeNode node, List<List<Integer>> leaves){
        if(node.left == null && node.right == null){
            leaves.get(0).add(node.val);
            return 1;
        }
        int height = 0;
        if(node.left != null) height = Math.max(height, getLeaf(node.left, leaves));
        if(node.right != null)  height = Math.max(height, getLeaf(node.right, leaves));

        height += 1;
        if(leaves.size() < height) leaves.add(new ArrayList<>());
        leaves.get(height-1).add(node.val);
        return height;
    }

    //  https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode[] common = new TreeNode[]{null};
        lca(root, startValue, destValue, common);
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        buildParentMap(root, null, parents);
        TreeNode src = getNode(root, startValue);
        TreeNode dest = getNode(root, destValue);
        //System.out.println(parents);
        //System.out.println(getPath(src, common[0], false, parents));
        if(common[0].val == startValue){
            return getPath(dest, common[0], false, parents);
        }
        else if(common[0].val == destValue){
            return getPath(src, common[0], true, parents);
        }
        else{
            String path1 = getPath(src, common[0], true, parents);
            String path2 = getPath(dest, common[0], false, parents);
            return path1+path2;
        }
    }
    public TreeNode getNode(TreeNode node, int val){
        if(node == null) return null;
        if(node.val == val) return node;
        TreeNode left = getNode(node.left, val);
        if(left != null) return left;
        TreeNode right = getNode(node.right, val);
        if(right != null) return right;
        return null;
    }
    public void buildParentMap(TreeNode curr, TreeNode parent, Map<TreeNode, TreeNode> parents){
        if(curr == null) return;
        parents.put(curr, parent);
        buildParentMap(curr.left, curr, parents);
        buildParentMap(curr.right, curr, parents);
    }
    public int lca(TreeNode node, int startValue, int destValue, TreeNode[] anc){
        if(node == null) return 0;
        int left = lca(node.left, startValue, destValue, anc);
        if(left == 2 ) return 2;
        int right = lca(node.right, startValue, destValue, anc);
        if(right == 2) return 2;
        if(left==1 && right == 1) {
            anc[0] = node;
            return 2;
        }
        if(( node.val == startValue || node.val == destValue ) && (left==1 || right == 1) ){
            anc[0] = node;
            return 2;
        }
        if( node.val == startValue || node.val == destValue ) return 1;
        return left+right;
    }
    public String getPath(TreeNode src, TreeNode dest, boolean isUp, Map<TreeNode, TreeNode> parents){
        StringBuilder path = new StringBuilder();
        TreeNode curr = src;
        if(isUp){
            while(curr != dest){
                path.append('U');
                curr = parents.get(curr);
            }
        }
        else{
            while(curr != dest){
                TreeNode p =  parents.get(curr);

                path.append(curr == p.left ? 'L' : 'R');
                curr = p;
            }
            path.reverse();
        }
        return String.valueOf(path);
    }

    // https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/submissions
    public boolean removeOnes(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        for(int i=1; i<height; i++){
            for(int j=1; j<width; j++){
                int sum = grid[i][j] + grid[i-1][j] + grid[i-1][j-1] + grid[i][j-1];
                if(sum % 2 == 1) return false;
            }
        }
        return true;
    }

    // https://leetcode.com/problems/maximum-number-of-points-with-cost/
    public long maxPoints(int[][] points) {
        int height = points.length, width = points[0].length;
        long[][] grid = new long[height][width];
        long maxVal = Integer.MIN_VALUE;
        for(int k=0; k<width; k++){
            maxVal = Math.max(maxVal, points[0][k]);
            grid[0][k] = points[0][k];
        }
        if(height == 1) return maxVal;

        for(int i=1; i<height; i++){
            for(int j=0; j<width; j++){
                if(j==0) grid[i][j] = grid[i-1][j];
                else grid[i][j] = Math.max(grid[i][j-1]-1, grid[i-1][j]);
            }
            for(int j=width-1; j>=0; j--){
                if(j==width-1) grid[i][j] = Math.max(grid[i][j], grid[i-1][j]);
                else{
                    long max2 = Math.max(grid[i][j+1]-1, grid[i-1][j]);
                    grid[i][j] = Math.max(grid[i][j], max2);
                }
            }
            for(int j=0; j<width; j++){
                grid[i][j] += points[i][j];
                maxVal = Math.max(maxVal, grid[i][j]);
            }

        }
        return maxVal;
    }


    // https://leetcode.com/problems/stock-price-fluctuation/
    static class StockPrice {


        MinHeap minHeap;
        MaxHeap maxHeap;
        int latestTime;
        int currentPrice;

        public StockPrice() {
            minHeap = new MinHeap();
            maxHeap = new MaxHeap();
            latestTime = 0;
            currentPrice = 0;
        }

        public void update(int timestamp, int price) {
            if(latestTime <= timestamp){
                latestTime = timestamp;
                currentPrice = price;
            }
            minHeap.update(timestamp, price);
            maxHeap.update(timestamp, price);
        }

        public int current() {
            return currentPrice;
        }

        public int maximum() {
            return maxHeap.heap.get(0).price;
        }

        public int minimum() {
            return minHeap.heap.get(0).price;
        }

        class MinHeap{
            class Stock{
                int timestamp;
                int price;
                public Stock(int timestamp, int price){
                    this.timestamp = timestamp;
                    this.price = price;
                }

                @Override
                public String toString() {
                    return "[" +
                            "" + timestamp +
                            " " + price +
                            ']';
                }
            }
            Map<Integer, Integer> map;
            List<Stock> heap;

            public MinHeap(){
                this.map = new HashMap<>();
                this.heap = new ArrayList<>();
            }

            public void insert(int timestamp, int price){
                Stock stock = new Stock(timestamp, price);
                int idx = this.heap.size();
                map.put(timestamp, idx);
                this.heap.add(stock);
                pushUp(this.heap.size()-1);
            }

            public void update(int timestamp, int price){
                if(this.map.get(timestamp) == null){
                    insert(timestamp, price);
                    return;
                }
                Stock stock = this.heap.get(this.map.get(timestamp));
                int old = stock.price;
                stock.price = price;
                if(price > old) pushDown(this.map.get(timestamp));
                else if(price < old) pushUp(this.map.get(timestamp));
            }

            public void swap(int i, int j){
                Stock temp = this.heap.get(i);
                this.heap.set(i, this.heap.get(j));
                this.heap.set(j, temp);

                this.map.put(this.heap.get(i).timestamp, i);
                this.map.put(this.heap.get(j).timestamp, j);
            }

            public void pushUp(int idx){
                int child = idx;
                int parent = (int) Math.floor((idx-1)/2);
                while(this.heap.get(parent).price > this.heap.get(child).price){
                    swap(parent, child);
                    child = parent;
                    parent = (int) Math.floor((child-1)/2);
                }
            }

            public void pushDown(int idx){
                int parent = idx;
                int left = parent*2+1;

                int n = this.heap.size();
                while(left < n){
                    int parentVal = this.heap.get(parent).price;
                    int leftVal = this.heap.get(left).price;
                    if(left < n-1){
                        int right = left+1;
                        int rightVal = this.heap.get(right).price;
                        int minVal = Math.min(leftVal, rightVal);
                        if(parentVal <= minVal) return;
                        if(minVal == leftVal){
                            swap(parent, left);
                            parent = left;
                        }
                        else{
                            swap(parent, right);
                            parent = right;
                        }
                        left = parent*2+1;
                    }
                    else{
                        if(parentVal > leftVal) swap(parent, left);
                        return;
                    }
                }
            }
        }
        class MaxHeap{
            class Stock{
                int timestamp;
                int price;
                public Stock(int timestamp, int price){
                    this.timestamp = timestamp;
                    this.price = price;
                }

                @Override
                public String toString() {
                    return "[" +
                            "" + timestamp +
                            " " + price +
                            ']';
                }
            }
            Map<Integer, Integer> map;
            List<Stock> heap;

            public MaxHeap(){
                this.map = new HashMap<>();
                this.heap = new ArrayList<>();
            }

            public void insert(int timestamp, int price){
                Stock stock = new Stock(timestamp, price);
                int idx = this.heap.size();
                map.put(timestamp, idx);
                this.heap.add(stock);
                pushUp(this.heap.size()-1);
            }

            public void update(int timestamp, int price){
                if(this.map.get(timestamp) == null){
                    insert(timestamp, price);
                    return;
                }
                Stock stock = this.heap.get(this.map.get(timestamp));
                int old = stock.price;
                stock.price = price;
                if(price > old) pushUp(this.map.get(timestamp));
                else if(price < old){
                    pushDown(this.map.get(timestamp));
                }
            }

            public void swap(int i, int j){
                Stock temp = this.heap.get(i);
                this.heap.set(i, this.heap.get(j));
                this.heap.set(j, temp);

                this.map.put(this.heap.get(i).timestamp, i);
                this.map.put(this.heap.get(j).timestamp, j);
            }

            public void pushUp(int idx){
                int child = idx;
                int parent = (int) Math.floor((idx-1)/2);
                while(this.heap.get(parent).price < this.heap.get(child).price){
                    swap(parent, child);
                    child = parent;
                    parent = (int) Math.floor((child-1)/2);
                }
            }

            public void pushDown(int idx){
                int parent = idx;
                int left = parent*2+1;

                int n = this.heap.size();
                while(left < n){
                    int parentVal = this.heap.get(parent).price;
                    int leftVal = this.heap.get(left).price;
                    if(left < n-1){
                        int right = left+1;
                        int rightVal = this.heap.get(right).price;
                        int maxVal = Math.max(leftVal, rightVal);
                        if(parentVal >= maxVal) return;
                        if(maxVal == leftVal){
                            swap(parent, left);
                            parent = left;
                        }
                        else{
                            swap(parent, right);
                            parent = right;
                        }
                        left = parent*2+1;
                    }
                    else{
                        if(parentVal < leftVal) swap(parent, left);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
    }

}
