package DynamicProgramming.NeetCode.OneD;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] ways = new int[amount + 1];
        int M = Integer.MAX_VALUE;
        Arrays.fill(ways, M);
        ways[0] = 0;
        for(int coin : coins){
            for(int i=coin; i<=amount; i++){
                ways[i] = Math.min(ways[i], ways[i-coin] == M ? M : ways[i-coin] + 1);
            }
        }
        return ways[amount] == M ? -1 : ways[amount];
    }
}
