package DynamicProgramming.LeetcodeDP.LongestIncreasingSubsequence;

import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int longest = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int last = arr[i] - difference;
            if(map.containsKey(last)){
                map.put(arr[i], map.get(last) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
            longest = Math.max(longest, map.get(arr[i]));
        }
        return longest;
    }
}
