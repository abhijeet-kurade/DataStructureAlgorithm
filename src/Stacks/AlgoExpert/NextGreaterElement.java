package Stacks.AlgoExpert;

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] array) {
        int len = array.length;
        int[] nextGrtEle = new int[len];
        for(int i=0; i<len; i++) nextGrtEle[i] = -1;
        Stack<Integer> stack = new Stack<>();
        for(int idx = 2 * len -1; idx>=0; idx++){
            int ind = idx % len;
            while(!stack.isEmpty()){
                if(array[ind] >= stack.peek()){
                    stack.pop();
                }
                else {
                    nextGrtEle[ind] = stack.peek();
                    break;
                }
            }
            stack.push(array[ind]);
        }
        return nextGrtEle;
    }
}
