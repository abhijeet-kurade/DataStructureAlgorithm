package Backtracking.Striver;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {

        System.out.println(stringPermutation("ABCD"));
    }



    public static List<String> permute(char[] chars){
        return null;
    }



    public static ArrayList<String> stringPermutation(String str){
        ArrayList<String> permutations = new ArrayList<>();
        stringPermutation(0, new StringBuilder(str),  permutations);
        return permutations;
    }

    public static void stringPermutation(int idx, StringBuilder str, ArrayList<String> permutations){
        if(idx == str.length()){
            permutations.add(String.valueOf(str));
            return;
        }
        for(int i=idx; i<str.length(); i++){
            swap(str, idx, i);
            stringPermutation(idx+1, str, permutations);
            swap(str, idx, i);
        }
    }
    public static void swap(StringBuilder str, int i, int j){
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

}
