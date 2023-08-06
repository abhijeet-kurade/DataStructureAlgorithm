package String.StringMatching;

import Utils.Output;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        Output.printArr(buildPattern("aefaedaefaefa"));
        Output.printArr(buildPattern1("aefaedaefaefa"));
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



