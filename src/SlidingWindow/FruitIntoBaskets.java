package SlidingWindow;

// https://leetcode.com/problems/fruit-into-baskets/

import java.util.HashMap;

public class FruitIntoBaskets {

    public int totalFruit(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int end = 0;
        int window = 0;
        for(int start =0; start < n; start ++){
            if(!map.containsKey(arr[start])) map.put(arr[start], 0);
            map.put(arr[start], map.get(arr[start]) + 1);
            while(map.size() > 2){
                int f = arr[end];
                map.put(f, map.get(f)-1);
                end += 1;
                if(map.get(f) == 0) map.remove(f);
            }
            window = Math.max(window, start - end + 1);
        }
        return window;
    }
}
