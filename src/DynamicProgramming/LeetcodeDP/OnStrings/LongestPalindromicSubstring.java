package DynamicProgramming.LeetcodeDP.OnStrings;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = -1, len = 0;

        for(int i=0; i<n; i++){
            int[] ans = longestPalindrome(i, i, s);
            if(ans[1] > len){
                start = ans[0];
                len = ans[1];
            }

            ans = longestPalindrome(i, i+1, s);
            if(ans[1] > len){
                start = ans[0];
                len = ans[1];
            }
        }

        return s.substring(start, start+len);
    }

    public int[] longestPalindrome(int left, int right, String s){
        int n = s.length();
        while(left >= 0  && right < n && s.charAt(left) == s.charAt(right)){
            left -= 1;
            right += 1;
        }
        left += 1;
        right -= 1;
        return new int[]{left, right - left + 1};
    }
}
