package ArrayHashMaps.Arrays;

//https://leetcode.com/problems/minimum-time-difference/

import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if(n < 2) return 0;
        boolean[] bitMap = new boolean[24*60];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(String point : timePoints){
            int minutes = getMinutes(point);
            min = Math.min(min, minutes);
            max = Math.max(max, minutes);
            if(bitMap[minutes]) return 0;
            bitMap[minutes] = true;
        }
        int crossOver = 24*60 - max + min;

        int diff = Integer.MAX_VALUE;
        int prev = min;
        for(int i=min+1; i<24*60; i++){
            if(bitMap[i]){
                diff = Math.min(diff, i - prev);
                prev = i;
            }
        }
        return Math.min(crossOver, diff);
    }

    private int getMinutes(String point){
        String[] pt = point.split(":");
        int hh = Integer.parseInt(pt[0]);
        int mm = Integer.parseInt(pt[1]);
        return 60 * hh + mm;
    }
}
