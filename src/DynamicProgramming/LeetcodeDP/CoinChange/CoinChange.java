package DynamicProgramming.LeetcodeDP.CoinChange;

import java.util.Arrays;

public class CoinChange {
    public static int numSquares(int n, int[] coins) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(coins);
        for(int i=0; i<=n; i++){
            for(int coin : coins){
                if(i < coin) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
        return dp[n];
    }
}
