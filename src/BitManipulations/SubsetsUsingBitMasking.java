package BitManipulations;

import java.util.ArrayList;
import java.util.List;

public class SubsetsUsingBitMasking {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
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
