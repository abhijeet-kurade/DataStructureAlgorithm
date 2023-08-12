package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.Arrays;

public class NonConstructableChange {
    public int nonConstructableChange(int[] coins) {
        Arrays.sort(coins);
        int change = 0;
        for(int coin : coins){
            if(coin <= change + 1) change += coin;
            else return change+1;
        }
        return change+1;
    }

}
