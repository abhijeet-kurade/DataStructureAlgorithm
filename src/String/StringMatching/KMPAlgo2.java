package String.StringMatching;

import java.util.Arrays;

public class KMPAlgo2 {
    public static void main(String[] args) {
        Utils.Output.printArr(KMP("aaafaa", "aa"));
    }

    public static int[] KMP(String s, String p){
        int n = s.length(), m = p.length();
        int[] matches = new int[n];

        int[] dp = new int[m];
        Arrays.fill(dp, -1);

        int i=1, j=0;
        while(i < m){
            if(p.charAt(i) == p.charAt(j)){
                dp[i] = j;
                i += 1;
                j += 1;
            }
            else if(j > 0) j = dp[j-1]+1;
            else i += 1;
        }

        i = 0; j =0;

        while(i < n){
            if(s.charAt(i) == p.charAt(j)){
                i += 1;
                j += 1;
                if(j == m){
                    matches[i-j] = 1;
                    j = dp[j-1] + 1;
                }
            }
            else if(j > 0) j = dp[j-1] + 1;
            else i += 1;
        }

        return matches;
    }
}
