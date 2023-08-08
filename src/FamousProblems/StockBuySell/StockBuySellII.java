package FamousProblems.StockBuySell;

import java.util.Arrays;

// https://bit.ly/3nYO17H
public class StockBuySellII {
    public static long getMaximumProfit (int n, long[] values) {
        long lastBuy = 0;
        long lastSell = (int)-1e8;

        for(int i=n-1; i>=0; i--){
            long price = values[i];
            long currBuy = Math.max(lastBuy, -price + lastSell);
            long currSell = Math.max(lastSell, price + lastBuy);
            lastBuy = currBuy;
            lastSell = currSell;
        }

        return lastBuy;
    }

    public static long getMaximumProfit1 (int n, long[] values) {
        long[][] dp = new long[n][2];
        for(long[] arr : dp) Arrays.fill(arr, -1);
        return stockExchange(values, 0, true, dp);
    }
    public static long stockExchange(long[] values, int idx, boolean canBuy, long[][] dp){
        int n = values.length;
        if(idx == n){
            return 0;
        }
        long profit = 0;
        if(canBuy){
            if(dp[idx][0] != -1) return dp[idx][0];
            long ifBuy = stockExchange(values, idx+1, !canBuy, dp) - values[idx];
            long doNothing = stockExchange(values, idx+1, canBuy, dp);
            profit = Math.max(ifBuy, doNothing);
            dp[idx][0] = profit;
        }
        else{
            if(dp[idx][1] != -1) return dp[idx][1];
            long ifSell = stockExchange(values, idx+1, !canBuy, dp) + values[idx];
            long doNothing = stockExchange(values, idx+1, canBuy, dp);
            profit = Math.max(ifSell, doNothing);
            dp[idx][1] = profit;
        }
        return profit;
    }
}
