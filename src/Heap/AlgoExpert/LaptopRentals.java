package Heap.AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;

public class LaptopRentals {
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        int len = times.size();

        int[] start = new int[len];
        int[] end = new int[len];

        int index = 0;
        for(ArrayList<Integer> time : times){
            start[index] = time.get(0);
            end[index] = time.get(1);
            index += 1;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int current = 0;
        int max = 0;
        int i = 0;
        int j = 0;

        while (i<len){
            if(start[i] < end[j]){
                current += 1;
                max = Math.max(max, current);
                i += 1;
            }
            else {
                j -= 1;
                current -= 1;
            }
        }

        return max;
    }
}
