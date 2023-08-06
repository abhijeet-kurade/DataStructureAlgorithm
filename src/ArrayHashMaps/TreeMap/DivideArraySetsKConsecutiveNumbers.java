package ArrayHashMaps.TreeMap;

import java.util.TreeMap;

public class DivideArraySetsKConsecutiveNumbers {
    public static void main(String[] args) {
        //int[] arr = {3,2,1,2,3,4,3,4,5,9,10,11};
        int[] arr = {1,2,3,2,3,4,7,8,9};
        System.out.println(isPossibleDivide(arr, 3));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int newStart = map.firstKey();

        for(int i=0; i<n/k; i++){
            boolean flag = false;
            int start = newStart;
            for(int j=0; j<k; j++){
                int num = start + j;
                if(map.getOrDefault(num, 0) == 0){
                    return false;
                }

                map.put(num, map.getOrDefault(num, 0)-1);
                if(!flag && map.getOrDefault(num, 0) > 0){
                    newStart = start + j;
                    flag = true;
                }
            }
            if(!flag) {
                if(map.ceilingKey(start + k) == null) return true;
                else newStart = map.ceilingKey(start + k);
            }

        }
        return true;
    }

}
