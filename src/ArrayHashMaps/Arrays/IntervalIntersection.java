package ArrayHashMaps.Arrays;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public static void main(String[] args) {

    }

    public static int[][] intervalIntersection(int[][] a, int[][] b){
        List<int[]> intersections = new ArrayList<>();
        int i=0, j=0;
        while(i < a.length && j < a.length){

            int lo = Math.max(a[i][0], b[j][0]);
            int hi = Math.min(a[i][1], b[j][1]);

            if(lo <= hi) intersections.add(new int[] {lo, hi});

            if(a[i][1] < b[i][1]){
                i += 1;
            }
            else{
                j += 1;
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }
}
