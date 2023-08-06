package FamousProblems.Subsets;

// https://leetcode.com/problems/partition-equal-subset-sum/
// https://bit.ly/34iIIsH
// https://www.youtube.com/watch?v=7win3dcgo3k&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=16
// https://www.youtube.com/watch?v=obhWqDfzwQQ
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        int half = sum / 2;
        boolean[][] dp = new boolean[n+1][half+1];
        dp[0][0] = true;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=half; j++){
                if(j < nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][half];
    }
}
