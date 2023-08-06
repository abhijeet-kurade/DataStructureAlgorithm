package Stacks;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] A) {
        Stack<Integer> st =new Stack<>();
        for(int i=0;i<A.length;i++){
            if(st.size()>=2 && (A[i].equals("+") || A[i].equals("-") || A[i].equals("*") || A[i].equals("/"))){
                int a=st.pop();
                int b=st.pop();
                if(A[i].equals("+")){
                    st.push(b+a);
                }else if(A[i].equals("-")){
                    st.push(b-a);
                }else if(A[i].equals("*")){
                    st.push(b*a);
                }else{
                    st.push(b/a);
                }

            }else{
                st.push(Integer.parseInt(A[i]));
            }
        }
        return st.isEmpty() ? 0 : st.pop();
    }
}
