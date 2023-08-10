package DynamicProgramming;

public class PredictTheWinner {
    public static void main(String[] args) {

    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[][][] dp = new int[n][n][2];

        for(int window = 0; window < n; window++){
            for(int i=0; i<n;i++){
                int j = i + window;
                if(j >= n) break;
                if(window == 0){
                    dp[i][j][0] = nums[i];
                    continue;
                }
                dp[i][j][0] = Math.max(nums[i] + dp[i+1][j][1], nums[j] + dp[i][j-1][1]);
                dp[i][j][1] = Math.min(dp[i+1][j][0], dp[i][j-1][0]);
            }
        }
        return dp[0][n-1][0] >= dp[0][n-1][1];
    }
}
