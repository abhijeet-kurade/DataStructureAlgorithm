package FamousProblems.SubsetSum;


//  https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(arr, 9));
    }

    public static boolean isSubsetSum(int[] arr, int sum){
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
        return dp[n][sum];
    }
}
