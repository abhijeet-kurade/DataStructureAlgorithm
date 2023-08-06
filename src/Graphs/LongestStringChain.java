package Graphs;

//https://leetcode.com/problems/longest-string-chain/

import java.util.Arrays;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"wefr", "qsadf", "e", "ee"};
        sortArray(words);
        for(String s : words) System.out.print(s+" ");
    }
    public int longestStrChain(String[] words) {

        int n = words.length;
        Arrays.sort(words, (o1, o2)->{return o1.length() - o2.length();});



        return -1;

    }

    public static boolean isNextString(String s1, String s2){
        s1 += '.';
        s2 += '.';
        int n = s1.length(), m = s2.length();
        if(n > m) return isNextString(s2, s1);
        if(n+1 != m) return false;
        int i=0, j=0;
        while(i<n && j<m){
            if(s1.charAt(i) == s2.charAt(j)) i+=1;
            j+=1;
        }
        return i==n && j ==m;
    }

    public static void sortArray(String[] words){
        Arrays.sort(words, (o1, o2)->{return o1.length() - o2.length();});
    }
}
