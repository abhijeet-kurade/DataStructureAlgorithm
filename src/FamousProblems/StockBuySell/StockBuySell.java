package FamousProblems.StockBuySell;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class StockBuySell {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int price : prices){
            profit = Math.max(profit, price - min);
            min = Math.min(min, price);
        }
        return profit;
    }
}
