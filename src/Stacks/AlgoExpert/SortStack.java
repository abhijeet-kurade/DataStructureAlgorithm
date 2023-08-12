package Stacks.AlgoExpert;

import java.util.ArrayList;

public class SortStack{
    public void insertIntoStack(ArrayList<Integer> stack, int val){
        int len = stack.size();
        if(len ==  0 || stack.get(len-1) <= val){
            stack.add(val);
            return;
        }
        int value = stack.remove(len-1);
        insertIntoStack(stack, val);
        stack.add(value);
        return;
    }
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        int len = stack.size();
        if(len == 0) return stack;
        int val = stack.remove(len-1);
        sortStack(stack);
        insertIntoStack(stack, val);
        return stack;
    }
}
