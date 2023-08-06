package FamousProblems.Coins;

import java.util.Arrays;

public class CoinProblems {
    public static void main(String[] args) {

        System.out.println("Hello From windows");
    }

    public int minCoinsChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int coin : coins){
            for(int i=0; i<dp.length; i++){
                if(i>=coin){
                    int temp;
                    if(dp[i-coin] == Integer.MAX_VALUE) temp=dp[i-coin];
                    else temp = dp[i-coin] + 1;
                    dp[i] = Math.min(temp, dp[i]);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
    public static  int numberOfWaysToMakeChange(int[] coins, int amount){
        int[] ways = new int[amount+1];
        ways[0] = 1;
        for(int coin : coins){
            for(int i= coin; i<=amount; i++){
                ways[i] += ways[i-coin];
            }
        }
        return ways[amount];
    }

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int minChange = 0;
        for(int coin : coins){
            if(minChange+1 < coin) return minChange+1;
            minChange += coin;
        }
        return minChange+1;
    }
}
