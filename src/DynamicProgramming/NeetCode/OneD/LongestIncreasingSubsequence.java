package DynamicProgramming.NeetCode.OneD;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            int place = bSearch(list, num) + 1;
            if(list.size() <= place){
                list.add(num);
            }
            else{
                list.set(place, num);
            }
        }
        return list.size();
    }

    public int bSearch(List<Integer> list, int num){
        int left = 0;
        int right = list.size()-1;
        int idx = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) < num){
                idx = mid;
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return idx;
    }

}
