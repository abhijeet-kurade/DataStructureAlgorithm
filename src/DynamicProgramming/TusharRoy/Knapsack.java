package DynamicProgramming.TusharRoy;

public class Knapsack {
    public static void main(String[] args) {

    }

    public static int knapsack(int[][] weights, int limit){

        int n = weights.length;
        int[][] dp = new int[n+1][limit+1];

        for(int i=1; i<=n ; i++){
            for(int j=1; j<=limit; j++){
                int p = weights[i-1][1];
                int w = weights[i-1][0];
                if(j < w){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - w] + p);
            }
        }
        return dp[n][limit];
    }

    int gfgKnapsack(int W, int wt[], int val[], int n) {
        if(n == 0) return 0;
        int[][] dp = new int[n+1][W+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                int w = wt[i-1];
                int p = val[i-1];
                if(j < w){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + p);
                }
            }
        }
        return dp[n][W];
    }
}
