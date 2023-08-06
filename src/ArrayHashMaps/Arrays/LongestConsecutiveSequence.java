package ArrayHashMaps.Arrays;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        System.out.println(longestConsecutiveSequence(new int[]{5,8,33,6,99,97,98,100,5, 7, 9, 10}));
    }

    public static int longestConsecutiveSequence(int[] nums){

        int longestSeq = 0;

        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int num : nums){
            map.put(num, false);
        }

        for(int num : nums){
            if(!map.get(num)){
               int min = num, max = num;
               map.put(num, true);
               while(map.containsKey(min-1) && !map.get(min-1)){
                   min -= 1;
                   map.put(min, true);
               }

                while(map.containsKey(max + 1) && !map.get(max + 1)){
                    max += 1;
                    map.put(max, true);
                }
                longestSeq = Math.max(longestSeq, max-min+1);
            }
        }
        return longestSeq;
    }
}
