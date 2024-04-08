package FamousProblems.SubsetSum;

import java.util.HashMap;
import java.util.Map;

public class PartitionSubsetMinDiff {
    public static void main(String[] args) {
        int[] arr = {-52706,66649,-25761,-25402,-78514,-22173,64310,-94230,30731,5190,23665,42545,4378,11126,45917,-57771,76046,-12994};
        int[] arr1 = new int[1000];
        for(int i=0; i<1000; i++){
            arr1[i] = i;
        }
        System.out.println(minimumDifference(arr));
    }

    public static int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0 ;
        for(int num : nums){
            sum += num;
        }
        Map<Integer, Integer>[][] dp = new Map[n+1][n+1];
        return rec(nums, 0, 0, 0, sum, dp);
    }

    public static int rec(int[] arr, int idx, int curr, int sum,  int total, Map<Integer, Integer>[][] dp){

        if(dp[idx][curr] == null) dp[idx][curr] = new HashMap<>();
        if(idx == arr.length){

            if(curr != arr.length/2) {
                dp[idx][curr].put(sum, Integer.MAX_VALUE);
                return Integer.MAX_VALUE;
            }
            int diff = Math.abs(sum - (total - sum));
            dp[idx][curr].put(sum, diff);
            return diff;
        }
        if(dp[idx][curr].containsKey(sum)){
            return dp[idx][curr].get(sum);
        }
        // skip
        int skip =rec(arr, idx+1, curr, sum, total, dp);

        // consider
        int take = rec(arr, idx+1, curr+1, sum+arr[idx], total, dp);

        dp[idx][curr].put(sum, Math.min(skip, take));
        return Math.min(skip, take);
    }
}
