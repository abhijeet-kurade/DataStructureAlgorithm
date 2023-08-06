package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> sorted = new ArrayList<>();
        int len = arrays.size();

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<len; i++)
            heap.add(new int[]{arrays.get(i).get(0), i, 0});

        while(! heap.isEmpty()){
            int[] triplet = heap.poll();
            int number = triplet[0];
            int array = triplet[1];
            int index = triplet[2];
            sorted.add(number);
            index += 1;
            if(index >= arrays.get(array).size()) continue;
            triplet[0] = arrays.get(array).get(index);
            triplet[2] = index;
            heap.add(triplet);
        }
        return sorted;
    }

}
