package FamousProblems.Palindromes;


//https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1/
public class Palindrome {
    static int formPalindrome(String s)    {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int w=1; w<n; w++){
            for(int i=0; i<n; i++){
                int j = i+w;
                if(j>=n) continue;
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
            }
        }
        return dp[0][n-1];
    }
}
