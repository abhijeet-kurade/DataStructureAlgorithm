package DynamicProgramming.LeetcodeDP.Knapsack;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l][m+1][n+1];

        return findMaxForm(strs, dp, 0, m, n);
    }

    public int findMaxForm(String[] strs, int[][][] dp, int i, int m, int n){
        if(i >= strs.length) return 0;

        if(dp[i][m][n] != 0){
            return dp[i][m][n];
        }

        int[] count = countZerosOnes(strs[i]);

        int ans = findMaxForm(strs, dp, i+1, m, n);

        if(m >= count[0] && n >= count[1]){
            ans = Math.max(ans, 1 + findMaxForm(strs, dp, i+1, m - count[0], n - count[1]));
        }
        dp[i][m][n] = ans;
        return ans;
    }

    public int[] countZerosOnes(String str){
        int[] cnt = new int[2];
        for(char c : str.toCharArray()){
            cnt[c - '0'] += 1;
        }
        return cnt;
    }
}
