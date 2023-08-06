package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.add(4);
        stack.add(14);
        stack.add(2);
        stack.add(41);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    public static List<List<Integer>> combinations(int[] arr, int target){
        List<List<Integer>> output = new ArrayList<>();
        combinations(arr, 0, new ArrayList<>(), output, target);
        return output;
    }

    public static void combinations(int[] arr, int idx, List<Integer> curr, List<List<Integer>> output, int target){
        int  n = arr.length;
        if(target == 0) output.add(new ArrayList<>(curr));
        if(idx == n || target < 0) return;

        for(int i=idx; i<n; i++){
            curr.add(arr[i]);
            combinations(arr, i, curr, output, target - arr[i] );
            curr.remove(curr.size()-1);
        }

    }


    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty())return;
        int val = stack.pop();
        reverseStack(stack);
        reverseStk(val, stack);
    }

    public static void reverseStk(int val, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.add(val);
            return;
        }
        int temp = stack.pop();
        reverseStk(val, stack);
        stack.add(temp);
    }

    public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty())return;
        int val = stack.pop();
        sortStack(stack);
        sortStack(val, stack);
    }
    public static void sortStack(int val, Stack<Integer> stack){
        if(stack.isEmpty() || val <= stack.peek()){
            stack.add(val);
            return;
        }
        int temp = stack.pop();
        sortStack(val, stack);
        stack.add(temp);
    }
}
