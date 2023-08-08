package DynamicProgramming;

// https://leetcode.com/problems/maximum-number-of-points-with-cost/
public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int height = points.length, width = points[0].length;
        long[][] grid = new long[height][width];
        long maxVal = Integer.MIN_VALUE;
        for(int k=0; k<width; k++){
            maxVal = Math.max(maxVal, points[0][k]);
            grid[0][k] = points[0][k];
        }
        if(height == 1) return maxVal;

        for(int i=1; i<height; i++){
            for(int j=0; j<width; j++){
                if(j==0) grid[i][j] = grid[i-1][j];
                else grid[i][j] = Math.max(grid[i][j-1]-1, grid[i-1][j]);
            }
            for(int j=width-1; j>=0; j--){
                if(j==width-1) grid[i][j] = Math.max(grid[i][j], grid[i-1][j]);
                else{
                    long max2 = Math.max(grid[i][j+1]-1, grid[i-1][j]);
                    grid[i][j] = Math.max(grid[i][j], max2);
                }
            }
            for(int j=0; j<width; j++){
                grid[i][j] += points[i][j];
                maxVal = Math.max(maxVal, grid[i][j]);
            }
        }
        return maxVal;
    }
}
