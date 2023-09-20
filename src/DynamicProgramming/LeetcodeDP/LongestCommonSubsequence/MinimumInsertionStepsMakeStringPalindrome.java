package DynamicProgramming.LeetcodeDP.LongestCommonSubsequence;

public class MinimumInsertionStepsMakeStringPalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        String p = new StringBuilder(s).reverse().toString();
        return n - longestCommonSubsequence(s, p);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if(n > m) longestCommonSubsequence(text2, text1);
        int[] row = new int[n+1];

        for(int i=1; i<=m; i++){
            char c1 = text1.charAt(i-1);
            int[] temp = new int[n+1];
            for(int j=1; j<=n; j++){
                char c2 = text2.charAt(j-1);
                if(c1 == c2){
                    temp[j] = row[j-1] + 1;
                }
                else{
                    temp[j] = Math.max(temp[j-1], row[j]);
                }
            }
            row = temp;
        }
        return row[n];
    }
}
