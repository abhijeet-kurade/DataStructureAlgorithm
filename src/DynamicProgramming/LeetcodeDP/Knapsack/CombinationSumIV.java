package DynamicProgramming.LeetcodeDP.Knapsack;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int num : nums){
                if(i < num) continue;
                dp[i] += dp[i-num];
            }
        }
        return dp[n];
    }
}
