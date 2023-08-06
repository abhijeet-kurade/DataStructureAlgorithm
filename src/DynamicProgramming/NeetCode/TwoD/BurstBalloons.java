package DynamicProgramming.NeetCode.TwoD;

public class BurstBalloons {
    public static void main(String[] args) {

        int[] arr = {3, 1, 5, 8};
        System.out.println(burstBalloons(arr));
    }

    public static int burstBalloons(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int w=0; w<n; w++){
            for(int l=0; l+w<n; l++){
                int r = l+w;
                for(int i=l; i<=r; i++){
                    int ll = l == 0 ? 1 : arr[l-1];
                    int rl = r == n-1 ? 1 : arr[r+1];

                    int curr = ll * arr[i] * rl;
                    int leftWindow = i-1 < 0 ? 0 : dp[l][i-1];
                    int rightWindow = i+1 >= n ? 0 : dp[i+1][r];

                    dp[l][r] = Math.max(dp[l][r], leftWindow + curr + rightWindow);
                }
            }
        }
        return dp[0][n-1];
    }
}
