package DynamicProgramming.LeetcodeDP.OnStrings;

public class RegularExpression {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1; i<=m; i++){
            if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-2];
        }

        for(int i=1; i<=n; i++){
            char c1 = s.charAt(i-1);
            for(int j=1; j<=m; j++){
                char c2 = p.charAt(j-1);
                if(c1 == c2 || c2 == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(c2 == '*'){
                    char prev = p.charAt(j-2);
                    boolean zeroOcc = dp[i][j-2];
                    boolean singleOcc = dp[i][j-1];
                    boolean multiOcc = (c1 == prev || prev == '.')  && dp[i-1][j];
                    dp[i][j] = zeroOcc || singleOcc || multiOcc;
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
