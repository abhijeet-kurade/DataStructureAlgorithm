package DynamicProgramming.LeetcodeDP.Matrix;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n=grid[0].length;

        int[] row = new int[n];

        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(i==0 & j == 0){
                    temp[j] = grid[i][j];
                    continue;
                }
                int x = j == 0 ? Integer.MAX_VALUE : temp[j-1];
                int y = i == 0 ? Integer.MAX_VALUE : row[j];
                temp[j] = Math.min(x, y) + grid[i][j];
            }
            row = temp;
        }

        return row[n-1];
    }
}
