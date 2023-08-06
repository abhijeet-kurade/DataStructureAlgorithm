package FamousProblems.BasicCalculator;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {

        System.out.println(basicCalculator("4+2-( 10 + -9)"));
    }

    public static int basicCalculator(String expression){

        int n = expression.length();

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 1;

        for(int i=0; i<n; i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                int val = 0;
                while(i<n && Character.isDigit(expression.charAt(i))){
                    val = val * 10 + expression.charAt(i) - '0';
                    i += 1;
                }
                i -= 1;
                sum += val * sign;
                sign = 1;
            }
            else if(c == '('){
                stack.push(sum);
                stack.add(sign);
                sum = 0;
                sign = 1;
            }
            else if(c == ')'){
                sum *= stack.pop();
                sum += stack.pop();
            }
            else if(c == '-'){
                sign *= -1;
            }
        }

        return sum;
    }
}
