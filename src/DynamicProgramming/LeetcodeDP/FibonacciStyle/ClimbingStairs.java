package DynamicProgramming.LeetcodeDP.FibonacciStyle;

public class ClimbingStairs {

    public int climbStairs1(int n){
        return -1;


    }

    private void climb(int step, int last, int[] count){
        if(step > last) return;
        if(step == last) count[0] += 1;

        climb(step+1, last, count);
        climb(step+2, last, count);

    }

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
