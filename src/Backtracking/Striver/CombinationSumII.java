package Backtracking.Striver;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {

        System.out.println(combinationSum2(new int[]{1,1,2,2,4,5}, 6));
    }

    /*
    Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.

    Examples:

    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8

    Output:
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]]


    Explanation: These are the unique combinations whose sum is equal to target.

    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5

    Output: [[1,2,2],[5]]

    Explanation: These are the unique combinations whose sum is equal to target.
    * */


    public static List<List<Integer>> combinationSum2(int[] arr, int target){
        List<List<Integer>> sets = new ArrayList<>();
        Arrays.sort(arr);
        Utils.Output.printArr(arr);
        combinationSum2(arr, 0, 0, target, sets, new ArrayList<>());
        return sets;
    }

    public static void combinationSum2(int[] arr, int idx, int sum, int target, List<List<Integer>> sets, List<Integer> curr){
        int n = arr.length;

        if( sum > target) {
            System.out.println(curr);
            return;
        }


        if(sum == target){
            System.out.println(curr);
            sets.add(new ArrayList<>(curr));
            return;
        }


        for(int i=idx; i<n; i++){
            if(i != idx && arr[i] == arr[i-1]) continue;
            //combinationSum2(arr, i, sum, target, sets, curr);

            // take
            curr.add(arr[i]);
            //System.out.println(idx + " "+ i +" "+ (sum+arr[i]) +" "+ curr);
            combinationSum2(arr, i+1, sum+arr[i], target, sets, curr);
            curr.remove(curr.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSumII(int[] arr, int target){

        ArrayList<ArrayList<Integer>> sums = new ArrayList<>();
        combinationSumII(0, arr, target,  new ArrayList<>(), sums);
        System.out.println(sums);
        return sums;
    }
    public static void combinationSumII(int idx, int[] arr, int target,  ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> sums){

        if(idx >= arr.length){
            if(target == 0) sums.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx; i<arr.length; i++){
            if(i!=idx && arr[i-1] == arr[i]) continue;
            if(arr[i] > target) return;

            curr.add(arr[i]);
            combinationSumII(i+1, arr, target-arr[i], curr, sums);
            curr.remove(curr.size()-1);
        }


    }
}
