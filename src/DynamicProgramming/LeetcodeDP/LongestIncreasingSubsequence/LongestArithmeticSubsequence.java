package DynamicProgramming.LeetcodeDP.LongestIncreasingSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new Map[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            dp[i] = new HashMap<>();
            int curr = nums[i];
            for(int j=0; j<i; j++){
                int diff = nums[j] - curr;
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        return ans;
    }
}
