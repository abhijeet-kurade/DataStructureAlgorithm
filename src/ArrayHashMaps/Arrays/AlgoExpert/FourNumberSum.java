package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.*;

public class FourNumberSum {
    public List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        Map<Integer, List<int[]>> map = new HashMap<>();
        List<Integer[]> fourNumbers = new ArrayList<>();

        int len = array.length;
        if(len <= 3 ) return fourNumbers;

        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len;j++){
                int sum = array[i] + array[j];
                if (map.get(sum) == null) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(new int[]{array[i], array[j]});
            }
        }

        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len;j++){
                int tgt = targetSum - array[i] - array[j];
                if(map.get(tgt) != null){
                    for(int[] pair : map.get(tgt)){
                        if(pair[0] > array[j])
                            fourNumbers.add(new Integer[]{array[i], array[j], pair[0], pair[1]});
                    }
                }
            }
        }
        return fourNumbers;
    }
}
