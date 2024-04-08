package FamousProblems.SubsetSum;

import java.util.*;

public class CountSubsetsSumEqualToK {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        arr[100] = 1;arr[101] = 1;arr[102] = 6;arr[103] = 1;
    }

    public static int countSubsetSum(int [] arr, int k){

        int N = arr.length;

        int n = N/2;


        int[] left = new int[n];
        int[] right = new int[n];
        if(N%2 == 1){
            right = new int[n+1];
            right[n] = arr[N-1];
        }

        for(int i=0; i<n; i++){
            left[i] = arr[i];
            right[i] = arr[i+n];
        }

        int[] leftSum = subsetSums(left);
        int[] rightSum = subsetSums(right);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : rightSum){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int count = 0;
        for(int i : leftSum){
            if(map.containsKey(k-i)){
                count += map.get(k-i);
            }
        }

        return count;
    }
    public static int[] subsetSums(int[] arr){
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : arr) {
            int l = subsets.size();
            for (int i=0; i<l; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                subsets.add(subset);
            }
        }

        int[] sums = new int[subsets.size()];
        int idx = 0;

        for(List<Integer> s : subsets){
            sums[idx++] = s.stream().mapToInt(Integer::intValue).sum();
        }
        Arrays.sort(sums);
        return sums;
    }
    public static boolean binarySearch(int[] arr, int target){
        int left = 0, right = arr.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target) return true;
            if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

}