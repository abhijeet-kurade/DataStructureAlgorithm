package BasicQuestions;

import java.util.Arrays;
import java.util.Stack;

public class NextMinMaxInArray {
    public static void main(String[] args) {
        int[] arr = {6,2,5,1,3,12,2,3,6,8,4,5};
        Utils.Output.printArr(nextMinNumber1(arr));
        Utils.Output.printArr(nextMinNumber(arr));
    }

    public static int[] nextMinNumber(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        for(int i=arr.length-1; i>=0; i--){
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }
        return ans;
    }
    public static int[] nextMinNumber1(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                int idx = stack.pop();
                ans[idx] = i;
            }
            stack.add(i);
        }
        return ans;
    }

    public static int[] nextMinNumberInCircularArray(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        for(int i=n*2 - 1; i>=0; i--){
            int idx = i % n;
            while (!stack.isEmpty() && arr[idx] <= arr[stack.peek()]){
                stack.pop();
            }
            ans[idx] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(idx);
        }
        return ans;
    }
}
