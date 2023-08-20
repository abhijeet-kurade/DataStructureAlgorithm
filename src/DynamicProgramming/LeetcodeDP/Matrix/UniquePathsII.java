package DynamicProgramming.LeetcodeDP.Matrix;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[n];
        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    temp[j] = 0;
                    continue;
                }
                if(i==0 && j==0){
                    temp[j] = 1;
                    continue;
                }
                int x = i == 0 ? 0 : row[j];
                int y = j == 0 ? 0 : temp[j-1];
                temp[j] = x + y;
            }
            row = temp;
        }
        return row[n-1];
    }
}
