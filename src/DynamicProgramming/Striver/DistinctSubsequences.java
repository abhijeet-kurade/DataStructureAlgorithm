package DynamicProgramming.Striver;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("", ""));
    }
    public static int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();

        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0], 1);

        for(int i=1; i<=m; i++){
            char c1 = t.charAt(i-1);
            for(int j=1; j<=n; j++){
                char c2 = s.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
