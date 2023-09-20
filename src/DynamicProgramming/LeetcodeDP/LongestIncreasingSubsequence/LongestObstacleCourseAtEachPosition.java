package DynamicProgramming.LeetcodeDP.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class LongestObstacleCourseAtEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        List<Integer> subsequence = new ArrayList<>();
        int idx = 0;
        for(int num : obstacles){
            int place = binarySearch(subsequence, num) + 1;
            if(subsequence.size() <= place){
                subsequence.add(num);
            }
            else{
                subsequence.set(place, num);
            }
            ans[idx] = place+1;
            idx += 1;
        }

        return ans;
    }


    public int binarySearch(List<Integer> list, int num){
        int idx = -1;
        int left = 0, right = list.size() - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) == num){
                idx = mid;
                left = mid + 1;
            }
            else if(list.get(mid) < num){
                idx = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

        }

        return idx;
    }
}
