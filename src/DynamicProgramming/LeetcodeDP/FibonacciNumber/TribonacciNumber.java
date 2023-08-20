package DynamicProgramming.LeetcodeDP.FibonacciNumber;

public class TribonacciNumber {

    public int tribonacci(int n) {
        if(n == 0) return 0;
        int step = 3;
        int step_1 = 0, step_2 = 1, step_3 = 1;

        while(step <= n){
            int temp = step_1 + step_2 + step_3;
            step_1 = step_2;
            step_2 = step_3;
            step_3 = temp;
            step += 1;
        }

        return step_3;
    }
}
