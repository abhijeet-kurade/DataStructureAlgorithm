package DynamicProgramming.LeetcodeDP.Stocks;

public class BuySellStockWithKTransactions {
    public static void main(String[] args) {
        int[] prices = {7, 1, 6, 3, 4, 7, 4, 9, 6, 15};
        System.out.println(new Tabulation().maxProfit(prices, 4));
    }

    private static class Recursive{

        public static int maxProfit(int[] prices, int k){

            return (int)maxProfit(prices, k, 0, 0);
        }

        public static long maxProfit(int[] prices, int k, int idx, int isBuy){
            if(k == -1) return 0;
            if(prices.length - 1 == idx){
                return isBuy == 0 ? 0 : prices[idx];
            }
            long profit;
            if(isBuy == 0){
                long buy = -prices[idx] + maxProfit(prices, k-1, idx+1, isBuy^1);
                long skip = maxProfit(prices, k, idx+1, isBuy);
                profit = Math.max(buy, skip);
            }
            else{
                long sell = prices[idx] + maxProfit(prices, k, idx+1, isBuy^1);
                long skip = maxProfit(prices, k, idx+1, isBuy);
                profit = Math.max(sell, skip);
            }
            return profit;
        }
    }

    private static class Memoization{
        public static int maxProfit(int[] prices, int k){
            int n = prices.length;
            int[][][] dp = new int[n][k+1][2];
            for(int i=0; i<n; i++){
                for(int j=0; j<=k; j++){
                    dp[i][j][0] = -1;
                    dp[i][j][1] = -1;
                }
            }
            return (int)maxProfit(prices, k, 0, 0, dp);
        }

        public static long maxProfit(int[] prices, int k, int idx, int isBuy, int[][][] dp){
            if(k == -1) return Integer.MIN_VALUE;
            if(prices.length - 1 == idx){
                dp[idx][k][isBuy] = isBuy == 0 ? 0 : prices[idx];
                return dp[idx][k][isBuy];
            }
            if(dp[idx][k][isBuy] != -1){
                return dp[idx][k][isBuy];
            }
            long profit;
            if(isBuy == 0){
                long buy = -prices[idx] + maxProfit(prices, k-1, idx+1, isBuy^1, dp);
                long skip = maxProfit(prices, k, idx+1, isBuy, dp);
                profit = Math.max(buy, skip);
            }
            else{
                long sell = prices[idx] + maxProfit(prices, k, idx+1, isBuy^1, dp);
                long skip = maxProfit(prices, k, idx+1, isBuy, dp);
                profit = Math.max(sell, skip);
            }
            dp[idx][k][isBuy] = (int)profit;
            return profit;
        }
    }

    private static class Tabulation{

        public static int maxProfit(int[] prices, int k) {
            int n = prices.length;
            int[][] dp = new int[k+1][n];
            for(int i=1; i<=k; i++){
                int maxBuy = Integer.MIN_VALUE;
                for(int j=1; j<n; j++){
                    int lastPrice = prices[j-1];
                    int currPrice = prices[j];
                    maxBuy = Math.max(maxBuy, - lastPrice + dp[i-1][j-1]);
                    dp[i][j] = Math.max(dp[i][j-1], maxBuy + currPrice);
                }
            }
            return dp[k][n-1];
        }


    }
}
