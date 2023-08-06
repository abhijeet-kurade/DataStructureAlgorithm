package ArrayHashMaps.HashMap;

import java.util.*;

public class AmountOfNewAreaPaintedEachDay {
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        int n = paint.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            int start = paint[i][0];
            int end = paint[i][1];
            int area = end - start;

            while(intervals.floorKey(start) != null){
                int prevStart = intervals.floorKey(start);
                int prevEnd = intervals.get(prevStart);
                if (prevEnd <= start) break;
                area -= Math.min(end, prevEnd) - Math.max(start, prevStart);  // substract overlap
                start = Math.min(start, prevStart);  // expand
                end = Math.max(end, prevEnd);
                intervals.remove(prevStart);  // the [prevStart, prevEnd] will be replaced by [start, end]
            }

            while(intervals.floorKey(end) != null){
                int prevStart = intervals.floorKey(end);
                int prevEnd = intervals.get(prevStart);
                if (prevEnd <= start) break;
                area -= Math.min(end, prevEnd) - Math.max(start, prevStart);  // substract overlap
                start = Math.min(start, prevStart);  // expand
                end = Math.max(end, prevEnd);
                intervals.remove(prevStart);  // the [prevStart, prevEnd] will be replaced by [start, end]
            }
            intervals.put(start, end);
            res[i] = area;
        }
        return res;
    }
}
