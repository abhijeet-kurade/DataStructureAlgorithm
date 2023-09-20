package DynamicProgramming.LeetcodeDP.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2)->{
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        List<Integer> list = new ArrayList<>();
        for(int[] envelope : envelopes){
            int w = envelope[0];
            int idx = binarySearch(list, w) + 1;

            if(list.size() == idx){
                list.add(w);
            }
            else{
                list.set(idx, w);
            }
        }
        return list.size();
    }

    public int binarySearch(List<Integer> list, int width){
        int idx = -1;
        int left = 0, right = list.size() - 1;

        while(left <= right){
            int m = left + (right - left) / 2;
            int mid = list.get(m);

            if(mid < width){
                idx = m;
                left = m + 1;
            }
            else{
                right = m - 1;
            }
        }
        return idx;
    }
}
