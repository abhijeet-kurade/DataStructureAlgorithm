package DynamicProgramming.NeetCode.OneD;

public class MinimumCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1) return cost[0];
        int second = cost[0], last = cost[1];
        for(int i=2; i<n; i++){
            int curr = cost[i] + Math.min(second, last);
            second = last;
            last = curr;
        }
        return Math.min(second, last);
    }
}
