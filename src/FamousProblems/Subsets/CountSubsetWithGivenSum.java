package FamousProblems.Subsets;

// https://www.youtube.com/watch?v=MqYLmIzl8sQ
public class CountSubsetWithGivenSum {
    int subsetCount(int arr[], int sum) {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=1;i<sum+1;i++) dp[0][i] = 0;
        for(int i=0;i<n+1;i++) dp[i][0] = 1;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j) dp[i][j] = (dp[i-1][j] + dp[i-1][j-arr[i-1]]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
