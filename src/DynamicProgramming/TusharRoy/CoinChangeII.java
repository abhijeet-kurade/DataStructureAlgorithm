package DynamicProgramming.TusharRoy;

// https://leetcode.com/problems/coin-change-2/
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] ways = new int[amount+1];
        ways[0] = 1;
        for(int coin : coins){
            for(int i= coin; i<=amount; i++){
                ways[i] += ways[i-coin];
            }
        }
        return ways[amount];
    }
}
