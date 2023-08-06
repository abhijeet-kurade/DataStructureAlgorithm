package DynamicProgramming;

//https://leetcode.com/problems/student-attendance-record-ii/

import Utils.Output;

public class StudentAttendanceRecord2 {

    public static void main(String[] args) {
        System.out.println(checkRecord(15));
    }

    public static int checkRecord(int n) {
        int M = 1000000007;
        long[] dp = new long[n <= 5 ? 6 : n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for(int i = 4; i <= n; i++)
            dp[i] = ((2 * dp[i - 1]) % M + (M - dp[i - 4])) % M;
        Output.printArr(dp);
        long total = dp[n];
        for (int i=1; i<=n; i++) total += (dp[i-1] * dp[n-i]) % M;
        return (int) (total%M);
    }
}
