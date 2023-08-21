package DynamicProgramming.LeetcodeDP.Stocks;

import java.util.Arrays;

public class BuySellStockWithCooldown {

    public static void main(String[] args) {

    }

    private static class Recursive{
        public static int maxProfit(int[] prices){
            return maxProfit(prices, 0, true);
        }

        public static int maxProfit(int[] prices, int idx, boolean isBuy){
            if(idx >= prices.length) return 0;
            if(idx == prices.length - 1) {
                return isBuy ? 0 : prices[idx];
            }

            int profit;
            if(isBuy){
                // buy it or skip it
                int buy = -prices[idx] + maxProfit(prices, idx+1, !isBuy);
                int skip = maxProfit(prices, idx+1, isBuy);
                profit = Math.max(buy, skip);
            }
            else{
                int sell = prices[idx] + maxProfit(prices, idx+2, !isBuy);
                int skip = maxProfit(prices, idx+1, isBuy);
                profit = Math.max(sell, skip);
            }
            return profit;
        }
    }

    private static class Memoization {

        public static int maxProfit(int[] prices){
            int[][] dp = new int[prices.length][2];
            for(int[] row : dp) Arrays.fill(row, -1);
            return maxProfit(prices, 0, 0, dp);
        }
        public static int maxProfit(int[] prices, int idx, int isBuy, int[][] dp){
            if(idx >= prices.length) return 0;

            if(idx == prices.length - 1) {
                return isBuy == 0 ? 0 : prices[idx];
            }
            if(dp[idx][isBuy] != -1){
                return dp[idx][isBuy];
            }

            int profit;
            if(isBuy == 0){
                int buy = -prices[idx] + maxProfit(prices, idx+1, isBuy^1, dp);
                int skip = maxProfit(prices, idx+1, isBuy, dp);
                profit = Math.max(buy, skip);
            }
            else{
                int sell = prices[idx] + maxProfit(prices, idx+2, isBuy^1, dp);
                int skip = maxProfit(prices, idx+1, isBuy, dp);
                profit = Math.max(sell, skip);
            }
            dp[idx][isBuy] = profit;
            return profit;
        }
    }

    private static class Tabulation{
        public static int maxProfit(int[] prices){
            long lastBuy = 0, lastSell = Integer.MIN_VALUE, lastButOneBuy = 0;

            for(int i=prices.length-1; i>=0; i--){
                long currBuy = Math.max(- prices[i] + lastSell, lastBuy);
                long currSell = Math.max( prices[i] + lastButOneBuy, lastSell);

                lastButOneBuy = lastBuy;

                lastBuy = currBuy;
                lastSell = currSell;
            }


            return (int)lastBuy;
        }
    }
}
