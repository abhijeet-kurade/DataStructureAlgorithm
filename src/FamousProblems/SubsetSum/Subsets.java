package FamousProblems.SubsetSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsets.add(subset);
        for (int num : nums) {
            int len = subsets.size();
            for (int j = 0; j < len; j++) {
                List<Integer> tempSet = new ArrayList<>(subsets.get(j));
                tempSet.add(num);
                subsets.add(tempSet);
            }
        }
        return subsets;
    }

    public void rec(int[] nums, int idx, Stack<Integer> curr, List<List<Integer>> subsets){
        if(idx == nums.length){
            subsets.add(new ArrayList<>(curr));
            return;
        }
        rec(nums, idx+1, curr, subsets);
        curr.add(nums[idx]);
        rec(nums, idx+1, curr, subsets);
        curr.pop();
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;

        int m = 1 << n;

        for(int mask = 0; mask<m; mask++){
            List<Integer> subset = new ArrayList<>();
            for(int i=0; i<n; i++){
                if( (mask & (1 << i)) != 0){
                    subset.add(nums[i]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
