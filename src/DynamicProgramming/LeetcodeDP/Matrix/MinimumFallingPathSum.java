package DynamicProgramming.LeetcodeDP.Matrix;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        dp[0] = matrix[0];

        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){

                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == cols - 1){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j+1]), dp[i-1][j]);
                }
                dp[i][j] += matrix[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<cols; i++) ans = Math.min(ans, dp[rows-1][i]);

        return  ans;
    }
}
