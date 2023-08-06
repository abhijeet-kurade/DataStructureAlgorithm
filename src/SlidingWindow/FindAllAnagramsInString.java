package SlidingWindow;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInString {
    static int CHAR_SIZE = 26;
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length();
        int n = s.length();
        int[] pHash = new int[CHAR_SIZE];
        int[] wHash = new int[CHAR_SIZE];
        List<Integer> matchedAnagrams = new ArrayList<>();
        for(int i=0; i<m; i++){
            int c = (int) p.charAt(i) - 'a';
            pHash[c] += 1;
        }

        for(int i=0; i<m; i++){
            int c = (int) s.charAt(i) - 'a';
            wHash[c] += 1;
        }
        if(compareHashes(pHash, wHash)) matchedAnagrams.add(0);
        for(int i=m; i<n; i++){
            int prevChar = s.charAt(i-m) - 'a';
            int currChar = s.charAt(i) - 'a';
            wHash[prevChar] += -1;
            wHash[currChar] += 1;
            if(compareHashes(pHash, wHash)) matchedAnagrams.add(i-m+1);
        }
        return matchedAnagrams;
    }

    public static boolean compareHashes(int[] hash1, int[] hash2){
        for(int i=0; i<CHAR_SIZE; i++){
            if(hash1[i] != hash2[i]) return false;
        }
        return true;
    }
}
