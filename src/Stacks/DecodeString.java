package Stacks;

import java.util.Stack;

public class DecodeString {

    class StackSolution {
        public String decodeString(String s) {
            Stack<String> stack = new Stack<>();
            int n = s.length();

            for(int i=0; i<n; i++){
                char c1 = s.charAt(i);
                if(c1 != ']'){
                    stack.add(String.valueOf(c1));
                }
                else{
                    StringBuilder str = new StringBuilder();
                    while(!stack.peek().equals("[")){
                        str.insert(0, stack.pop());
                    }
                    String concat = String.valueOf(str);
                    stack.pop();
                    StringBuilder num = new StringBuilder();
                    while(!stack.isEmpty() && isDigit(stack.peek())){
                        num.insert(0, stack.pop());
                    }
                    int number = Integer.parseInt(num.toString());
                    StringBuilder multiplied = new StringBuilder();
                    for(int j=0; j<number; j++){
                        multiplied.append(concat);
                    }
                    stack.add(multiplied.toString());
                }
            }

            String decoded = "";
            while(!stack.isEmpty()){
                decoded = stack.pop() + decoded;
            }
            return decoded;
        }

        public boolean isDigit(String s){
            int c = s.charAt(0) - '0';
            return 0<=c && c<10;
        }
    }

    class RecursiveSolution {
        public String decodeString(String s) {
            int n = s.length();
            int idx = 0;
            String dcode = "";
            while(idx < n){
                char c = s.charAt(idx);
                if(0 <= (c-'0') && (c-'0')<=9){
                    int b = idx;
                    while(s.charAt(b) != '[') b += 1;
                    int mul = Integer.parseInt(s.substring(idx, b));
                    int last = getNextBrac(s, b);
                    String decoded = decodeString(s.substring(b+1, last));
                    for(int i=0; i<mul; i++){
                        dcode += decoded;
                    }
                    idx = last+1;
                }
                else {
                    idx += 1;
                    dcode += c;
                }
            }
            return dcode;
        }

        public int getNextBrac(String str, int idx){
            int count = 1;
            int last =idx;
            for(int i=idx+1; i<str.length(); i++){
                char c = str.charAt(i);
                if(c == ']'){
                    count -= 1;
                    if(count == 0){
                        last = i;
                        break;
                    }
                }
                else if(c == '[') count += 1;
            }
            return last;
        }
    }

}
