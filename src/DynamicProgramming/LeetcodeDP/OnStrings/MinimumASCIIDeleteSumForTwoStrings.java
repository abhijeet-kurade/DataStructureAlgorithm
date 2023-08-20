package DynamicProgramming.LeetcodeDP.OnStrings;

public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }

        for(int i=1; i<=n; i++){
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }

        for(int i=1; i<=m; i++){
            char c1 = s1.charAt(i-1);
            for(int j=1; j<=n; j++){
                char c2 = s2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1] + c2, dp[i-1][j] + c1);
                }
            }
        }

        return dp[m][n];
    }
}
