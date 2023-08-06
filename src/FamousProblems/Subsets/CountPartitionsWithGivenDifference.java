package FamousProblems.Subsets;

// https://bit.ly/3r8mG5b
// https://www.youtube.com/watch?v=QihB4bI6BJw
// https://leetcode.com/discuss/interview-question/1271034/count-no-of-subsets-with-given-difference-dp
// https://www.youtube.com/watch?v=zoilQD1kYSg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=19
public class CountPartitionsWithGivenDifference {
    int subsetSum(int arr[], int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= sum; i++) dp[0][i] = 0;
        for (int i = 1; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    int countWithGivenSum(int nums[ ], int n, int diff)
    {
        int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];
        int reqSum=(diff+sum)/2;
        return subsetSum(nums,reqSum);
    }
}
