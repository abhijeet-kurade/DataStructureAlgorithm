package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.*;

public class ThreeNumberSum {

    public List<Integer[]> threeNumberSum(int[] array, int target) {
        Arrays.sort(array);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer[]> numbers = new ArrayList<>();
        int len = array.length;
        for(int i=0; i<len; i++) map.put(array[i], i);

        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                int req = target - array[i] - array[j];
                if(map.get(req) != null && map.get(req) > j)
                    numbers.add(new Integer[]{array[i], array[j], req});
            }
        }
        return numbers;
    }
}
