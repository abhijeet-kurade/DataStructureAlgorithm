package DynamicProgramming;

import Utils.Output;

import java.util.Arrays;

public class StrangePrinter {
    public static void main(String[] args) {


        String[] words = {"fdas","3"};
        Arrays.sort(words, (o1, o2)->{ return o1.length()-o2.length();});
        for(String s : words) System.out.print(s +" ");
    }
    public static  int strangePrinter(String s) {

        if (s.equals("")) return 0;

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int w = 1; w < n; w++) {
            for (int i = 0; w + i < n; i++) {
                int j = w + i;

                boolean endChars = s.charAt(i) == s.charAt(j);

                dp[i][j] = dp[i][j - 1] + (endChars ? 0 : 1);

                if(endChars) continue;

                for (int k = i + 1; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k][j - 1]);
                    }
                }
            }
        }

        Output.print2DArr(dp);
        return dp[0][n - 1];
    }
}
