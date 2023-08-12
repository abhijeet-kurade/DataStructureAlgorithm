package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = intervals.length;
        int curr_start = intervals[0][0];
        int curr_end = intervals[0][1];
        List<int[]> merged = new ArrayList<>();
        for(int i=1; i<len; i++){
            int[] interval = intervals[i];
            if(curr_end - interval[0] >= 0 ){
                curr_end = Math.max(curr_end, interval[1]);
            }
            else{
                merged.add(new int[]{curr_start, curr_end});
                curr_start = interval[0];
                curr_end = interval[1];
            }
        }
        merged.add(new int[]{curr_start, curr_end});

        int s = merged.size();
        int[][] mrged = new int[s][2];
        for(int i=0; i<s; i++) mrged[i] = merged.get(i);
        return mrged;

    }

}
