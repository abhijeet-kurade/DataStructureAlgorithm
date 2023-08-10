package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinations(int[] arr, int target){
        List<List<Integer>> output = new ArrayList<>();
        combinations(arr, 0, new ArrayList<>(), output, target);
        return output;
    }

    public static void combinations(int[] arr, int idx, List<Integer> curr, List<List<Integer>> output, int target){
        int  n = arr.length;
        if(target == 0) output.add(new ArrayList<>(curr));
        if(idx == n || target < 0) return;

        for(int i=idx; i<n; i++){
            curr.add(arr[i]);
            combinations(arr, i, curr, output, target - arr[i] );
            curr.remove(curr.size()-1);
        }

    }

}
