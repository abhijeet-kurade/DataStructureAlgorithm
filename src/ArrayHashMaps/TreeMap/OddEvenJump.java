package ArrayHashMaps.TreeMap;

import java.util.Arrays;
import java.util.TreeMap;

public class OddEvenJump {
    // https://leetcode.com/problems/odd-even-jump/
    public int oddEvenJumps(int[] arr) {
        int count = 0;
        int n = arr.length;

        if(n == 1) return 1;

        int[] nextOdd = new int[n];
        Arrays.fill(nextOdd, -1);
        int[] nextEven = new int[n];
        Arrays.fill(nextEven, -1);


        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=n-1; i>=0; i--){
            int num = arr[i];
            if(map.ceilingKey(num) != null){
                nextOdd[i] = map.get(map.ceilingKey(num));
            }
            map.put(num, i);
        }
        map = new TreeMap<>();
        for(int i=n-1; i>=0; i--){
            int num = arr[i];
            if(map.floorKey(num) != null){
                nextEven[i] = map.get(map.floorKey(num));
            }
            map.put(num, i);
        }

        boolean[][] dp = new boolean[n][2];

        dp[n-1][0] = true;
        dp[n-1][1] = true;

        for(int i=n-2; i>=0; i--){
            if(nextOdd[i] != -1){
                dp[i][0] = dp[nextOdd[i]][1];
            }
            if(nextEven[i] != -1){
                dp[i][1] = dp[nextEven[i]][0];
            }

            if(dp[i][0]) count += 1;
        }
        return count+1;
    }
}
