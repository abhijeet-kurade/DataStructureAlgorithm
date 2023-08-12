package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public int[] largestRange(int[] array) {
        int len = array.length;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<len; i++) map.put(array[i], false);
        int max_length = Integer.MIN_VALUE;
        int[] max_range = new int[2];
        for(int i=0; i<len; i++){
            int num = array[i];
            if(!map.get(num)){
                map.put(num, true);
                int start = num-1;
                while(map.get(start) != null && !map.get(start)){
                    map.put(start, true);
                    start -= 1;
                }
                start += 1;
                int end = num+1;
                while(map.get(end) != null && !map.get(end)){
                    map.put(end, true);
                    end += 1;
                }
                end -= 1;
                int curr_length = end - start + 1;
                if(max_length <= curr_length){
                    max_length = curr_length;
                    max_range[0] = start;
                    max_range[1] = end;
                }
            }
        }
        return max_range;
    }

}
