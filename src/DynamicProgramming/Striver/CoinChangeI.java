package DynamicProgramming.Striver;

import java.util.Arrays;

public class CoinChangeI {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,3,5}, 11));
    }
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        int temp=0;

        for(int coin : coins){
            for(int i=0; i<dp.length; i++){
                if(i>=coin){
                    if(dp[i-coin] == Integer.MAX_VALUE) temp=dp[i-coin];
                    else temp = dp[i-coin] + 1;
                    dp[i] = Math.min(temp, dp[i]);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;

    }
}
