package DynamicProgramming.NeetCode.OneD;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 1) return n;
        int second = 0, last = 1;
        for(int i=1; i<=n; i++){
            int curr = last + second;
            second = last;
            last = curr;
        }
        return last;
    }
}
