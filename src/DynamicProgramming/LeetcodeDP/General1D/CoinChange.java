package DynamicProgramming.LeetcodeDP.General1D;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int coin : coins){
            for(int i=1; i<=amount; i++){
                if(i < coin) continue;
                dp[i] = Math.min(dp[i], dp[i-coin] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + dp[i-coin]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
