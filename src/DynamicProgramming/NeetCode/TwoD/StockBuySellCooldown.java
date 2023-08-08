package DynamicProgramming.NeetCode.TwoD;

import java.util.Arrays;

public class StockBuySellCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return stockExchange(prices, 0, true, dp);
    }

    public int stockExchange(int[] prices, int idx, boolean buy, int[][] dp){
        int n = prices.length;

        if(idx >= n){
            return 0;
        }

        if(buy){
            if(dp[idx][0] != -1) return dp[idx][0];
            int withBuy = stockExchange(prices, idx+1, !buy, dp) - prices[idx];
            int witoutBuy = stockExchange(prices, idx+1, buy, dp);
            return dp[idx][0] = Math.max(withBuy, witoutBuy);
        }
        else{
            if(dp[idx][1] != -1) return dp[idx][1];
            int withSell = stockExchange(prices, idx+2, !buy, dp) + prices[idx];
            int witoutSell = stockExchange(prices, idx+1, buy, dp);
            return dp[idx][1] = Math.max(withSell, witoutSell);
        }
    }
}
