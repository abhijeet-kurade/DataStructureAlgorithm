package DynamicProgramming.LeetcodeDP.FibonacciNumber;

public class ClimbingStairs {

    public int climbStairs(int n) {

        int step = 2;
        int step_1 = 1, step_2 = 1;
        while(step <= n){
            int temp = step_1 + step_2;
            step_1 = step_2;
            step_2 = temp;
            step += 1;
        }

        return step_2;

    }
}
