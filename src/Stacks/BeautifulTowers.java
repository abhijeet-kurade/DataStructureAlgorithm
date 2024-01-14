package Stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BeautifulTowers {
    public static void main(String[] args) {
        List<Integer> maxHeights = Arrays.asList(4,8,6,7);
        System.out.println(maximumSumOfHeights(maxHeights));
    }
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int[] prevSmall = new int[n]; // index of the last small number
        long[] leftSum = new long[n]; // left side sum considering the current element as a peak
        Arrays.fill(prevSmall, -1);


        int[] nextSmall = new int[n]; // index of the next small number
        long[] rightSum = new long[n];  // right side sum considering the current element as a peak
        Arrays.fill(nextSmall, n);

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            long curr = maxHeights.get(i);
            while(!stack.isEmpty() && curr <= maxHeights.get(stack.peek())){
                stack.pop();
            }
            if(!stack.isEmpty()) prevSmall[i] = stack.peek();
            stack.add(i);
            long prevSum = prevSmall[i] == -1 ? 0 : leftSum[prevSmall[i]];
            leftSum[i] = curr + ( i-1-prevSmall[i] ) * curr + prevSum;
        }
        stack.clear();

        for(int i=n-1; i>=0; i--){
            long curr = maxHeights.get(i);
            while(!stack.isEmpty() && curr <= maxHeights.get(stack.peek())){
                stack.pop();
            }
            if(!stack.isEmpty()) nextSmall[i] = stack.peek();
            stack.add(i);
            long nextSum = nextSmall[i] == n ? 0 : rightSum[nextSmall[i]];
            rightSum[i] = curr + (nextSmall[i] - (i+1) ) * curr + nextSum;
        }

        long ans = 0;

        for(int i=0 ; i<n; i++){
            ans = Math.max(ans, rightSum[i] + leftSum[i] - (long)maxHeights.get(i) );
        }

        return ans;
    }


}
