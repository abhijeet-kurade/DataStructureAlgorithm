package FamousProblems.SubsetSum;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        if(sum % 2 == 1) return false;

        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;
        for(int i=1; i<=n; i++){
            int num = arr[i-1];
            for(int j=0; j<=sum; j++){
                if(j < num) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = dp[i-1][j] || dp[i-1][j - num];
            }
        }
        return dp[n][sum/2];

    }
}
