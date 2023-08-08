package FamousProblems.Palindromes;

// //https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public String longestPalindromeOptimal(String s) {
        int n = s.length();
        int len = 0, start = -1, end = -1;
        for(int k=0; k<n; k++){
            int i = k, j = k;
            while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
                if(len < (j - i +1)){
                    len = j - i + 1;
                    start = i;
                    end = j;
                }
                i -= 1;
                j += 1;
            }
            i = k;
            j = k+1;
            while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
                if(len < j - i +1){
                    len = j - i + 1;
                    start = i;
                    end = j;
                }
                i -= 1;
                j += 1;
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0, start = -1, end = -1;
        for(int k=0; k<n; k++){
            int i = k, j = k;
            while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
                if(len < j - i +1){
                    len = j - i + 1;
                    start = i;
                    end = j;
                }
                i -= 1;
                j += 1;
            }
            i = k;
            j = k+1;
            while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
                if(len < j - i +1){
                    len = j - i + 1;
                    start = i;
                    end = j;
                }
                i -= 1;
                j += 1;
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        String palindrome = "";
        for(int w=0; w<n; w++){
            for(int i=0; i+w<n; i++){
                int j = i + w;
                boolean isEqual = s.charAt(i) == s.charAt(j);
                if(w <= 1){
                    if(isEqual){
                        dp[i][j]  = 1;
                        palindrome = s.substring(i, j+1);
                    }
                }
                else{
                    if(isEqual && dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                        palindrome = s.substring(i, j+1);
                    }

                }
            }
        }
        return palindrome;
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        String palindrome = "";
        int l = 0;
        for(int k=0; k<n; k++){
            String odd = getPalindrome(s, k, k, n);
            String even = getPalindrome(s, k, k+1, n);
            if(palindrome.length() < odd.length()){
                palindrome = odd;
            }
            if(palindrome.length() < even.length()){
                palindrome = even;
            }
        }
        return palindrome;
    }
    public String getPalindrome(String s, int i, int j, int n){
        String pal = "";
        while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
            pal = s.substring(i, j+1);
            i -= 1;
            j += 1;
        }
        return pal;
    }

}
