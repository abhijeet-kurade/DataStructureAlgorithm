package ArrayHashMaps.HashMap;

import java.util.*;
//https://leetcode.com/problems/find-original-array-from-doubled-array/

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2 != 0) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : changed){
            if(!map.containsKey(num)) map.put(num , 0);
            map.put(num , map.get(num) + 1);
        }
        Arrays.sort(changed);
        List<Integer> original = new ArrayList<>();
        for(int i=0; i<n; i++){
            int curr = changed[i];
            if(map.get(curr) == 0) continue;
            int next = curr * 2;

            if(!map.containsKey(next) || map.get(next) == 0) return new int[]{};

            original.add(curr);
            map.put(curr, map.get(curr)-1);
            map.put(next, map.get(next)-1);
        }
        int[] output = new int[original.size()];
        int i =0;
        for(int num : original) output[i++] = num;
        return output;
    }
}
