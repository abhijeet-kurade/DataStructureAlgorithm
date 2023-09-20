package DynamicProgramming.LeetcodeDP.General1D;

public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        for(int i=n-1; i>=0; i--){
            dp[i] = Math.max( i==n-1 ? 0 : dp[i+1], questions[i][0] + (i+questions[i][1]+1 >= n ? 0 : dp[i+questions[i][1]+1]) );
        }

        return dp[0];
    }
}
