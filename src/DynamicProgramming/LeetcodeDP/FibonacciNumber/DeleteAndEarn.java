package DynamicProgramming.LeetcodeDP.FibonacciNumber;

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
}
