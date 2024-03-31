package DynamicProgramming.Striver;

public class CoinChangeII {

    public static void main(String[] args) {
        System.out.println(change(11, new int[]{1,3,5}));
    }

    public static int change(int n, int[] denoms) {
        int[] dp = new int[n+1] ;
        dp[0] = 1;
        for(int i=0; i < denoms.length; i++){
            for(int j=0; j<=n; j++){
                if(j<denoms[i]) continue;
                dp[j] += dp[j-denoms[i]];
            }
        }
        return dp[n];

    }
}
