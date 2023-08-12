package Stacks.AlgoExpert;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShortenPath {
    public static String shortenPath(String path) {
        boolean startWithPath = path.charAt(0) == '/';
        String[] tokensArr = path.split("/");
        List<String> tokensList = Arrays.asList(tokensArr);
        List<String> filteredTokens = tokensList.stream().filter(token -> (token.length() > 0 && !token.equals(".")))
                .collect(Collectors.toList());

        Stack<String> stack = new Stack<>();
        if(startWithPath) stack.push("");

        for(String token : filteredTokens){
            if(token.equals("..")){
                if( stack.isEmpty() || stack.peek().equals(".."))  stack.push(token);
                else if( !stack.peek().equals("") )  stack.pop();
            }
            else stack.push(token);
        }
        if(stack.size() == 1 && stack.peek().equals("")) return "/";
        return String.join("/", stack);
    }
}
