package Backtracking.Striver;

import java.util.*;

public class PermutationII {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new HashMap<>(Map.of('c',2,'a',3,'d',2))));
    }

    public static List<String> permuteUnique(Map<Character, Integer> logger) {
        List<String> results = new ArrayList<>();

        // count the occurrence of each number
        int N = 0;
        for (char c : logger.keySet()) {
            N += logger.get(c);
        }

        backtrackUsingMap(new StringBuilder(), N, logger, results);
        return results;
    }

     static void backtrackUsingMap(
            StringBuilder curr,
            Integer N,
            Map<Character, Integer> logger,
            List<String> results) {

        if (curr.length() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.

            results.add(String.valueOf(curr));
            return;
        }

        for (Map.Entry<Character, Integer> entry : logger.entrySet()) {
            Character num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) {
                continue;
            }
            // add this number into the current combination
            curr.append(num);
            logger.put(num, count - 1);

            // continue the exploration
            backtrackUsingMap(curr, N, logger, results);

            // revert the choice for the next exploration
            curr.deleteCharAt(curr.length()-1);
            logger.put(num, count);
        }
    }


    static void backtrackCharArray(StringBuilder curr, int N, int[] chars, List<String> result){
        if(curr.length() == N){
            result.add(curr.toString());
            return;
        }
        for(int i=0; i<26; i++){
            if(chars[i] == 0) continue;

            curr.append(i + 'a');
            chars[i] -= 1;

            backtrackCharArray(curr,N,chars,result);

            curr.deleteCharAt(curr.length()-1);
            chars[i] += 1;
        }
    }

    static void backtrack(int idx, char[] curr, Set<String> result){
        if(idx == curr.length){
            result.add(new String(curr));
            return;
        }

        for(int i=idx; i<curr.length;  i++){
            swap(curr, idx, i);
            backtrack(idx+1, curr, result);
            swap(curr, idx, i);
        }
    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }
}