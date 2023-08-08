package DynamicProgramming.TusharRoy;

public class SubsetSum {
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
}
