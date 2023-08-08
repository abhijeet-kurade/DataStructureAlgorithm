package FamousProblems.StockBuySell;

import java.util.ArrayList;

// https://bit.ly/3rLHkqQ
public class StockBuySellIII {
    public static int maxProfit(ArrayList<Integer> prices, int n) {

        int[][] dp = new int[3][n];

        for(int i=1; i<=2; i++){
            int maxBuy = Integer.MIN_VALUE;
            for(int j=1; j<n; j++){
                int lastPrice = prices.get(j-1);
                int currPrice = prices.get(j);
                maxBuy = Math.max(maxBuy, - lastPrice + dp[i-1][j-1]);
                dp[i][j] = Math.max(dp[i][j-1], maxBuy + currPrice);
            }
        }
        return dp[2][n-1];
    }
}
