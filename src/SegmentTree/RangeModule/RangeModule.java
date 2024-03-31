package SegmentTree.RangeModule;

class RangeModule {
    SegTree st;
    public RangeModule() {
        st = new SegTree();
    }

    public void addRange(int left, int right) {
        st.update(left, right, true);
    }

    public boolean queryRange(int left, int right) {
        return st.query(left, right);
    }

    public void removeRange(int left, int right) {
        st.update(left, right, false);
    }
}

class SegTree{
    private class SegmentTreeNode{
        int low, high;
        SegmentTreeNode left, right;
        boolean included;

        public SegmentTreeNode(int low, int high, boolean included) {
            this.low = low;
            this.high = high;
            this.included = included;
        }
    }

    private SegmentTreeNode root;
    public SegTree() {
        this.root = new SegmentTreeNode(0, (int)1e9, false);
    }

    public boolean update(int lo, int hi, boolean include){
        return update(this.root, lo, hi, include);
    }

    private boolean update(SegmentTreeNode node, int lo, int hi, boolean include){
        // if range overlap on the current node range
        if(lo <= node.low &&  node.high <= hi){
            node.included = include;
            node.left = null;
            node.right = null;
            return node.included;
        }

        // no overlap at all
        if(node.high <= lo || hi <= node.low){
            return node.included;
        }

        if(node.left == null){
            int mid = node.low + (node.high - node.low) / 2;
            node.left = new SegmentTreeNode(node.low, mid, node.included);
            node.right = new SegmentTreeNode(mid, node.high, node.included);
        }

        boolean leftIncluded = update(node.left, lo, hi, include);
        boolean rightIncluded = update(node.right, lo, hi, include);
        node.included = leftIncluded && rightIncluded;

        return node.included;
    }

    public boolean query(int lo, int hi){
        return query(this.root, lo, hi);
    }
    private boolean query(SegmentTreeNode node, int lo, int hi){

        // if range overlap on the current node range
        if(lo <= node.low &&  node.high < hi){
            return node.included;
        }

        // no overlap at all
        if(node.high <= lo || hi <= node.low){
            return true;
        }

        boolean leftQuery = (node.left == null) ? node.included : query(node.left, lo, hi);
        boolean rightQuery = (node.right == null) ? node.included : query(node.right, lo, hi);

        return leftQuery && rightQuery;
    }
}