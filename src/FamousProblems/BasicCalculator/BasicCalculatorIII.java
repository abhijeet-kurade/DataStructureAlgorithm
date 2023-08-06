package FamousProblems.BasicCalculator;

import java.util.Stack;

public class BasicCalculatorIII {


    public static class Pair{
        Stack<Integer> stack;
        char sign;

        public Pair(Stack<Integer> stack, char sign) {
            this.stack = stack;
            this.sign = sign;
        }
    }

    public static void getCal(Stack<Integer> stack, char sign, int val){
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

    public static int basicCalculator(String expression){
        int n = expression.length();
        Stack<Pair> stackP = new Stack<>();
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
                getCal(stack, sign, val);
            }
            else if(c== '('){
                stackP.add(new Pair(stack, sign));
                stack = new Stack<>();
                sign = '+';
            }
            else if(c == ')'){
                int val = 0;
                while (!stack.isEmpty()) val += stack.pop();
                Pair p = stackP.pop();
                stack = p.stack;
                sign = p.sign;
                getCal(stack, sign, val);
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
