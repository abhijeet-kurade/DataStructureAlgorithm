package Stacks.AlgoExpert;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleUnderSkyline {

    public int largestRectangleUnderSkyline(ArrayList<Integer> bldgs) {
        int len = bldgs.size();
        int[] buildings = new int[len];
        int index = 0;
        for(int num : bldgs) buildings[index++] = num;

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        for(int i=0; i<len; i++){
            while(!stack.isEmpty()){
                if(buildings[stack.peek()] >= buildings[i])
                    stack.pop();
                else break;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        int[] right = new int[len];
        for(int i=len-1; i>=0; i--){
            while(!stack.isEmpty()){
                if(buildings[stack.peek()] >= buildings[i])
                    stack.pop();
                else break;
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        int max_area = 0;
        for(int i=0; i<len; i++){
            int curr_area = buildings[i] * (right[i] - left[i] -1);
            max_area = Math.max(max_area, curr_area);
        }
        return max_area;
    }
}
