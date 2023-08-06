package Stacks.BasicCalculator;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(basicCalculator("4+5*8/2"));
    }
    public static int basicCalculator(String expression){
        int n = expression.length();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i=0;  i<n; i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                int val = 0;
                while(i<n && Character.isDigit(expression.charAt(i))){
                    val = val * 10 + expression.charAt(i) - '0';
                    i += 1;
                }
                i -= 1;
                if(sign == '+' || sign == '-'){
                    int mul = sign == '-' ? -1 : 1;
                    stack.add(mul * val);
                }
                else{
                    int lastVal = stack.pop();
                    int ans;
                    if(sign == '*'){
                        ans = lastVal * val;
                    }
                    else{
                        ans = lastVal / val;
                    }
                    stack.add(ans);
                }
            }
            else if( c != ' '){
                sign = c;
            }
        }

        int sum = 0;

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}
