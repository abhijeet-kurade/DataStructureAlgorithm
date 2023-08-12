package Stacks.AlgoExpert;

import java.util.Stack;

public class MinMaxStack {

    Stack<int[]> stack ;
    int size;

    public MinMaxStack(){
        this.stack = new Stack<>();
        this.size = 0;
    }
    public int peek() {
        return stack.peek()[0];
    }

    public int pop() {
        this.size -= 1;
        return stack.pop()[0];
    }

    public void push(Integer number) {
        int curr_min = this.size != 0 ? getMin() : Integer.MAX_VALUE;
        int curr_max = this.size != 0 ? getMax() : Integer.MIN_VALUE;
        this.size += 1;
        stack.push(new int[]{ number, Math.min(curr_min, number), Math.max(curr_max, number) });
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public int getMax() {
        return stack.peek()[2];
    }
}