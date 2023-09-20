package DynamicProgramming.LeetcodeDP.Knapsack;

import java.util.*;

public class PerfectSquares {
    public static void main(String[] args) {

        System.out.println(GreedyBFS.numSquares(1));
    }

    static class GreedyBFS{

        public static int numSquares(int n) {
            List<Integer> squares = new ArrayList<>();
            for(int i=1; i*i<=n; i++){
                squares.add(i*i);
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{n, 0});
            while(!queue.isEmpty()){
                int len = queue.size();
                for (int i=0; i<len; i++){
                    int[] cell = queue.poll();
                    int remainder = cell[0], count = cell[1];
                    for(int sqr : squares){
                        if(remainder == sqr) return count + 1;
                        else if(remainder < sqr) break;
                        else queue.add(new int[]{remainder-sqr, count+1});
                    }
                }
            }
            return -1;
        }
    }

    class CoinChangeSolution{
        // TC : O(n * sqrt(n))
        // SC : O(n)
        public static int numSquares(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for(int i=0; i<=n; i++){
                for(int sqrt = 1; sqrt * sqrt <= n; sqrt++ ){
                    int sqr = sqrt * sqrt;
                    if(i < sqr) continue;
                    dp[i] = Math.min(dp[i], 1 + dp[i-sqr]);
                }
            }
            return dp[n];
        }
    }
}
