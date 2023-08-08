package FamousProblems.Subsequences;

import java.util.HashMap;

// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int longest = 0;
        for(int i=0; i<n; i++){
            int last = arr[i] - difference;
            if(map.get(last) != null){
                map.put(arr[i], map.get(last)+1);
            }
            else {
                map.put(arr[i], 1);
            }
            longest = Math.max(longest, map.get(arr[i]));
        }
        return longest;
    }
}
