package SlidingWindow;

// https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {
    int CHAR_SIZE = 26;
    public boolean checkInclusion1(String s1, String s2) {
        int[] s1Chars = new int[CHAR_SIZE];
        int[] windowChars = new int[CHAR_SIZE];
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        for(int i=0; i<n; i++){
            int c = s1.charAt(i) - 'a';
            s1Chars[c] += 1;
        }
        for(int i=0; i<n; i++){
            int c = s2.charAt(i) - 'a';
            windowChars[c] += 1;
        }
        if(isMatch(s1Chars, windowChars)) return true;
        for(int i=n; i<m; i++){
            int prev = s2.charAt(i-n) - 'a';
            int curr = s2.charAt(i) - 'a';
            windowChars[prev] -= 1;
            windowChars[curr] += 1;
            if(isMatch(s1Chars, windowChars)) return true;
        }
        return false;
    }
    public boolean isMatch(int[] arr1, int[] arr2){
        for(int i=0; i<CHAR_SIZE; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] s1Chars = new int[CHAR_SIZE];
        int[] s2Chars = new int[CHAR_SIZE];

        for (int i = 0; i < n; i++) {
            s1Chars[s1.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < CHAR_SIZE; i++){
            if (s1Chars[i] == s2Chars[i]) count++;
        }

        for (int i = n; i < m; i++) {
            if (count == CHAR_SIZE) return true;

            int r = s2.charAt(i) - 'a', l = s2.charAt(i - n) - 'a';

            s2Chars[r]++;
            if (s2Chars[r] == s1Chars[r]) count++;
            else if (s2Chars[r] == s1Chars[r] + 1) count--;

            s2Chars[l]--;
            if (s2Chars[l] == s1Chars[l]) count++;
            else if (s2Chars[l] == s1Chars[l] - 1) count--;
        }

        return count == 26;
    }

}
