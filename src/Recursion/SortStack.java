package Recursion;

import java.util.Stack;

public class SortStack {

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
