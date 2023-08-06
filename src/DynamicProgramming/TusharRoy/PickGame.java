package DynamicProgramming.TusharRoy;

public class PickGame {
    public static void main(String[] args) {
        int[] arr = {3, 9, 1, 2, 1};
        System.out.println(optimalStrategy(arr));
    }

    public static int optimalStrategy(int[] arr){
        int n = arr.length;
        int[][][] dp = new int[n][n][2];
        for(int i=0; i<n; i++){
            dp[i][i][0] = arr[i];
        }

        for(int w=1; w<n; w++){
            for(int i=0; i+w<n; i++){
                int j = i + w;
                dp[i][j][0] = Math.max(
                        arr[i] + dp[i+1][j][1],
                        arr[j] + dp[i][j-1][1]
                );
                dp[i][j][1] = Math.min(
                        dp[i+1][j][0],
                        dp[i][j-1][0]
                );
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print("["+dp[i][j][0]+" "+dp[i][j][1]+"]");
            }
            System.out.println();
        }


        return Math.max(dp[0][n-1][0], dp[0][n-1][1]);
    }
}
