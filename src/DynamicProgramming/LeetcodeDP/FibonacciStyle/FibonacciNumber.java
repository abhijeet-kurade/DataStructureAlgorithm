package DynamicProgramming.LeetcodeDP.FibonacciStyle;

public class FibonacciNumber {

    public int fib(int n) {
        if(n == 0) return 0;
        int last = 1, second_last = 0;

        for(int i=2; i<=n; i++){
            int curr = last + second_last;
            second_last = last;
            last = curr;
        }
        return last;
    }
}
