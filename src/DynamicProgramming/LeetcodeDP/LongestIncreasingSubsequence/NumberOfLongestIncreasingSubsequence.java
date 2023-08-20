package DynamicProgramming.LeetcodeDP.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        findNumberOfLIS(new int[]{1, 100, 9, 8, 18, 171, 16, 25, 24, 23});
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        int lis = 0;

        for(int i=0; i<n; i++){
            int num = nums[i];
            int len = 0;
            for(int j=i-1; j>=0; j--){
                int curr = nums[j];
                if(curr < num){
                    len = Math.max(len, length[j]);
                }
            }
            length[i] = len + 1;
            lis = Math.max(lis, length[i]);
            int cnt = 0;
            for(int j=i-1; j>=0; j--){
                int curr = nums[j];
                if(curr < num && len == length[j]){
                    cnt += count[j];
                }
            }
            count[i] = cnt == 0 ? 1 : cnt;
            count[i] = cnt == 0 ? 1 : cnt;
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(length[i] == lis) ans += count[i];
        }
        return ans;
    }
}
