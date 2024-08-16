package DynamicProgramming.LeetcodeDP.FibonacciStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        int with = 0, without = 0, last = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int sum = entry.getValue();
            int temp;
            if(last == num - 1){
                temp = Math.max(without + sum, with);
            }
            else{
                temp = sum + with;
            }
            without = with;
            with = temp;
            last = num;
        }
        return Math.max(without, with);
    }

    public int deleteAndEarn1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return deleteAndEarn(min, max, map);
    }

    private int deleteAndEarn(int curr, int max, Map<Integer, Integer> map){
        if(curr > max) return 0;

        int consider = map.getOrDefault(curr, 0) + deleteAndEarn(curr + 2, max, map);
        int non = deleteAndEarn(curr + 1, max, map);

        return Math.max(consider, non);
    }
}
