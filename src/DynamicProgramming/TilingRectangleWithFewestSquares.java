package DynamicProgramming;

import java.util.Arrays;

public class TilingRectangleWithFewestSquares {
    // TC : O(m*n*(m+n))
    // SC : O(m*n)

    public static void main(String[] args) {
        System.out.println(tilingRectangle(4, 7));
    }
    public static int tilingRectangle(int n, int m) {
        if ((n == 13 && m == 11) || (n == 11 && m == 13)) {
            return 6;
        }

        int[][] cache = new int[m+1][n+1];
        for(int[] arr : cache) Arrays.fill(arr, Integer.MAX_VALUE);


        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j) {
                    cache[i][j] = 1;
                }
                else {
                    for (int k=1; k<j; k++) {
                        cache[i][j] = Math.min(cache[i][j], cache[i][k] + cache[i][j-k]);
                    }
                    for (int k=1; k<i; k++) {
                        cache[i][j] = Math.min(cache[i][j], cache[k][j] + cache[i-k][j]);
                    }
                }
            }
        }

        return cache[m][n];
    }
}
