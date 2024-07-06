package FamousProblems.SubsetSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        System.out.println(subsetsB(arr));
    }

    public static List<List<Integer>> subsetsB(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++){
            addToSubset(nums, i, subsets, new ArrayList<>());
        }
        return subsets;
    }

    public static void addToSubset(int[] nums, int idx, List<List<Integer>> subsets, List<Integer> curr){
        int n = nums.length;
        if(idx >= n){
            return;
        }
        curr.add(nums[idx]);
        subsets.add(new ArrayList<>(curr));
        addToSubset(nums, idx+1, subsets, curr);
        curr.remove(curr.size()-1);
    }


    // Dynamic Programming Technique
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

    // Backtracking way
    public void rec(int[] nums, int idx, Stack<Integer> curr, List<List<Integer>> subsets){

        // add to the subsets at the end of the array
        if(idx == nums.length){
            subsets.add(new ArrayList<>(curr));
            return;
        }

        // without considering the current number
        rec(nums, idx+1, curr, subsets);

        // with considering the current number
        curr.add(nums[idx]);
        rec(nums, idx+1, curr, subsets);

        // Backtracking step
        curr.pop();
    }



    // bit Manipulation technique
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
