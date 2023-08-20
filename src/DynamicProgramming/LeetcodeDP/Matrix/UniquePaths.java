package DynamicProgramming.LeetcodeDP.Matrix;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);
        for(int i=1; i<m; i++){
            int[] temp = new int[n];
            temp[0] = 1;
            for(int j=1; j<n; j++){
                temp[j] = temp[j-1] + row[j];
            }
            row = temp;
        }
        return row[n-1];
    }
}
