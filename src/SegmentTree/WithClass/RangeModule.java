package SegmentTree.WithClass;


public class RangeModule {

    SegTreeNode root = null;

    public RangeModule() {
        root = new SegTreeNode(0, (int)1e9, false);
    }

    public void addRange(int left, int right) {
        root.update(left, right, true);
    }

    public boolean queryRange(int left, int right) {
        return root.query(left, right);
    }

    public void removeRange(int left, int right) {
        root.update(left, right, false);
    }
}

class SegTreeNode {
    int low;
    int high;
    SegTreeNode left, right;
    boolean included = false;

    public SegTreeNode(int low, int high, boolean included) {
        this.low = low;
        this.high = high;
        this.included = included;
    }

    public boolean update(int lo, int hi, boolean include) {
        // new range completely overlaps current range
        if(lo <= low && hi >= high) {
            included = include;
            left = null;
            right = null;
            return included;
        }

        // no overlap with update range, just return the current included state
        if(low >= hi || high <= lo) return included;

        int mid = low + (high - low) / 2;
        if(left == null) {
            left = new SegTreeNode(low, mid, included);
            right = new SegTreeNode(mid, high, included);
        }

        boolean leftIncluded = left.update(lo, hi, include);
        boolean rightIncluded = right.update(lo, hi, include);
        included = leftIncluded & rightIncluded;

        return included;
    }

    public boolean query(int lo, int hi) {
        // queried range is completely covered by current range
        if(low >= lo && high < hi) return included;

        // queried range is not inside of current range; return true so it doesn't impact the result
        if(low >= hi || high <= lo) return true;

        boolean leftQuery = (left == null) ? included : left.query(lo, hi);
        boolean rightQuery = (right == null) ? included : right.query(lo, hi);

        return leftQuery && rightQuery;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
