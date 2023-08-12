package Stacks.AlgoExpert;

import java.util.*;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        Map<Character, Character> bracks =  new HashMap<>();
        bracks.put('(', ')');
        bracks.put('[', ']');
        bracks.put('{', '}');

        Set<Character> chars = new HashSet<>(bracks.keySet());
        for(char c : bracks.keySet())  chars.add(bracks.get(c));

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(!chars.contains(c)) continue;
            if(bracks.get(c) != null){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                if(bracks.get(stack.pop()) != c) return false;
            }
        }
        return stack.size() == 0;
    }
}
