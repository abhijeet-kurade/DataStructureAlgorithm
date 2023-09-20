package DynamicProgramming.LeetcodeDP.Knapsack;

import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int coin : coins){
            for(int i=1; i<=amount; i++){
                if(i < coin) continue;
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
