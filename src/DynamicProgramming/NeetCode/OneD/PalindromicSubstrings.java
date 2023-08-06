package DynamicProgramming.NeetCode.OneD;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n<2) return n;
        int[][] dp = new int[n][n];
        int count = 0;
        for(int w=0; w<n; w++){
            for(int i=0; i+w<n; i++){
                int j = i + w;
                boolean isEqual = s.charAt(i) == s.charAt(j);
                if(w <= 1){
                    if(isEqual){
                        dp[i][j]  = 1;
                        count += 1;
                    }
                }
                else{
                    if(isEqual && dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                        count += 1;
                    }

                }
            }
        }
        return count;
    }
}
