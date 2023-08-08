package DynamicProgramming.Striver.StockBuySell;

// https://bit.ly/346R72e
public class StockBuySellIV {
    public static int maximumProfit(int[] prices, int n, int k){
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
