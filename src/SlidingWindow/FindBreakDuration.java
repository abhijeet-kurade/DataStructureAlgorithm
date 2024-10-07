package SlidingWindow;

import java.util.List;

public class FindBreakDuration {
    public static int findBreakDuration(int n, int k, int t, List<Integer> start, List<Integer> finish){
        int ans = 0;
        int meetings_dur = 0;
        int left = 0, right = 0;
        while(right < start.size() && right < k){
            meetings_dur += (finish.get(right) - start.get(right));
            right += 1;
        }
        int next_start = right == start.size() ? t : start.get(right);
        ans = next_start - meetings_dur;
        while(right<start.size()){
            meetings_dur -= (finish.get(left) - start.get(left));
            meetings_dur += (finish.get(right) - start.get(right));
            left += 1;
            right += 1;
            next_start = right == start.size() ? t : start.get(right);
            int curr_start = finish.get(left-1);
            int window = (next_start - curr_start) - meetings_dur;
            ans = Math.max(ans, window);
        }
        return ans;
    }

}
