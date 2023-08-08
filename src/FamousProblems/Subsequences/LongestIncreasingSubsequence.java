package FamousProblems.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        //list.add(Integer.MAX_VALUE);
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


    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for(int num : nums){
            int i= Arrays.binarySearch(dp, 0, len, num);
            if(i<0) i = -(i+1);
            dp[i] = num;
            if(i==len) len += 1;
        }
        return len;
    }
}
