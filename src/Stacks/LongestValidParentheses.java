package Stacks;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;
        int maxLen = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count += 1;
                stack.push(i);
            }
            else{
                if(count > 0){
                    stack.pop();
                    count -= 1;
                    maxLen = Math.max(maxLen, i-stack.peek());
                }
                else{
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }
}
