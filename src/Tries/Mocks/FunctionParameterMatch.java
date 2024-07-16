package Tries.Mocks;

import java.util.*;

public class FunctionParameterMatch {

    /**
     *
     *
     * FuncA: [String, Integer, Integer]; isVariadic = false
     * FuncB: [String, Integer]; isVariadic = true
     * FuncC: [Integer]; isVariadic = true
     * FuncD: [Integer, Integer]; isVariadic = true
     * FuncE: [Integer, Integer, Integer]; isVariadic = false
     * FuncF: [String]; isVariadic = false
     * FuncG: [Integer]; isVariadic = false
     * findMatches({String}) -> [FuncF]
     * findMatches({Integer}) -> [FuncC, FuncG]
     * findMatches({Integer, Integer, Integer, Integer}) -> [FuncC, FuncD]
     * findMatches({Integer, Integer, Integer}) -> [FuncC, FuncD, FuncE]
     * findMatches({String, Integer, Integer, Integer}) -> [FuncB]
     * findMatches({String, Integer, Integer}) -> [FuncA, FuncB]
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<Function> queue = new PriorityQueue<>();
        queue.remove(new Function("", null, true));
        Set<Function> functions = Set.of(
                new Function("FuncA", Arrays.asList("String", "Integer", "Integer"), false),
                new Function("FuncB", Arrays.asList("String", "Integer"), true),
                new Function("FuncC", Arrays.asList("Integer"), true),
                new Function("FuncD", Arrays.asList("Integer", "Integer"), true)
        );
        FunctionLibrary library = new FunctionLibrary();
        library.register(functions);
        List<String> testCase1 = Arrays.asList("Integer", "Integer", "Integer", "Integer");
        List<String> testCase2 = Arrays.asList("String", "Integer", "Integer");
        System.out.println(library.findMatches(testCase1));
        System.out.println(library.findMatches(testCase2));
    }
}

class Function {
    String name;
    List<String> argumentTypes;
    boolean isVariadic;

    Function(String name, List<String> argumentTypes, boolean isVariadic) {
        this.name = name;
        this.argumentTypes = argumentTypes;
        this.isVariadic = isVariadic;
    }

    @Override
    public String toString() {
        return "{ " +
                "name='" + name + '\'' +
                " }";
    }
}
class FunctionLibrary {

    Trie trie;

    public FunctionLibrary() {
        this.trie = new Trie();
    }

    public void register(Set<Function> functionSet)  {
        for(Function function : functionSet){
            trie.insert(function);
        }
    }

    public List<Function> findMatches(List<String> argumentTypes) {
        int idx = -1;
        String last = argumentTypes.get(argumentTypes.size()-1);
        for(int i=argumentTypes.size()-1; i>=0; i--){
            if(argumentTypes.get(i) != last){
                break;
            }
            idx = i;
        }
        return trie.search(argumentTypes, idx);
    }
}

class Trie{
    class TrieNode{
        Map<String, TrieNode> children;
        List<Function> variadicFunctions;
        List<Function> nonVariadicFunctions;

        public TrieNode() {
            this.children = new HashMap<>();
            this.variadicFunctions = new ArrayList<>();
            this.nonVariadicFunctions = new ArrayList<>();
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }
    TrieNode root;

    public void insert(Function function){
        TrieNode node = this.root;
        List<String> arguments = function.argumentTypes;
        for(String argument : arguments){
            if(!node.children.containsKey(argument)){
                node.children.put(argument, new TrieNode());
            }
            node = node.children.get(argument);
        }

        if(function.isVariadic){
            node.variadicFunctions.add(function);
        }
        else {
            node.nonVariadicFunctions.add(function);
        }
    }

    public List<Function> search(List<String> arguments, int idx){
        List<Function> matches = new ArrayList<>();
        TrieNode node = this.root;
        for(int i=0; i<arguments.size(); i++){
            String argument = arguments.get(i);
            TrieNode child = node.children.getOrDefault(argument, null);

            if(child == null){
                return matches;
            }

            if(idx <= i){
                matches.addAll(child.variadicFunctions);
            }

            node = child;
        }
        matches.addAll(node.nonVariadicFunctions);
        return matches;
    }
}

