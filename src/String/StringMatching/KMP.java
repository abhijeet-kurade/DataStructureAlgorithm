package String.StringMatching;

import Utils.Output;

import java.util.Arrays;
import java.util.regex.Pattern;

public class KMP {
    public static void main(String[] args) {
        String str  = "aefaefaefaefdaefaeae", pattern = "aefaefdaefae";
        Practice p = new Practice();
        System.out.println(p.KMP(str, pattern));
    }

    public static int[] buildPattern1(String substring){
        int n = substring.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int j = 0;
        for(int i=1; i<n; i++){

            while(substring.charAt(i) != substring.charAt(j) && j > 0){
                j = match[j-1]+1;
            }

            if(substring.charAt(i) == substring.charAt(j)){
                match[i] = j;
                j += 1;
            }
        }

        return match;
    }

    public static int[] buildPattern(String substring){
        int n = substring.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int i=1, j=0;
        while(i < n){
            if(substring.charAt(i) == substring.charAt(j)){
                match[i] = j;
                i += 1;
                j += 1;
            }
            else if(j > 0) j = match[j-1] + 1;
            else i += 1;
        }

        return match;
    }
}

class Practice{

    public boolean KMP(String str, String pattern){
        int n = str.length(), k = pattern.length();
        int[] pat = new int[k];
        Arrays.fill(pat, -1);

        buildPattern(pattern, pat);

        int i=0, j=0;

        while(i < n){
            char s = str.charAt(i);
            char p = pattern.charAt(j);
            if(s == p){
                j += 1;
                if(j == k) return true;
            }
            else{
                j = pat[j-1] + 1;
            }
            i += 1;
        }

        return false;
    }

    public void buildPattern(String pattern, int[] pat){
        int i = 0;
        for(int j=1; j<pat.length; j++){
            while(pattern.charAt(i) != pattern.charAt(j)){
                i = pat[j-1] + 1;
            }

        }
    }
}



