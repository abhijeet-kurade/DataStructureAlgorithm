package DynamicProgramming.LeetcodeDP.Stocks;

public class BuySellStockWithOneTransaction {

    public static void main(String[] args) {

    }
    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
