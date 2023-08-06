package FamousProblems.Subsets;

// https://leetcode.com/problems/target-sum/
//  https://bit.ly/3swy5uL
// https://www.youtube.com/watch?v=b3GD8263-PQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=22
public class TargetSum {

    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        int sum=0;
        for(int i:arr) sum+=i;
        if(sum-target<0 || (sum-target)%2!=0) return 0;
        target=(sum-target)/2;
        int[][] dp=new int[n][target+1];
        if(arr[0]==0) dp[0][0]=2;
        else dp[0][0]=1;
        if(arr[0] != 0 && target>=arr[0]) dp[0][arr[0]]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int pick=0;
                if(j>=arr[i]){
                    pick=dp[i-1][j-arr[i]];
                }
                int notPick=dp[i-1][j];
                dp[i][j]=pick+notPick;
            }
        }
        return dp[n-1][target];
    }

}
