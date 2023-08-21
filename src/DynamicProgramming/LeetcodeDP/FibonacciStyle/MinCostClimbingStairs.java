package DynamicProgramming.LeetcodeDP.FibonacciStyle;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int last_2 = 0, last_1 = cost[0];
        int step = 1;
        while(step < cost.length){
            int temp = Math.min(last_2, last_1) + cost[step];

            last_2 = last_1;
            last_1 = temp;

            step += 1;
        }
        return Math.min(last_1, last_2);
    }
}
