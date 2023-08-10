package Recursion;

import java.util.Stack;

public class ReverseStack {
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
}
