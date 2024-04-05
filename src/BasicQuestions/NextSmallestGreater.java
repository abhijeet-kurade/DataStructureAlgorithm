package BasicQuestions;

import java.util.TreeMap;

public class NextSmallestGreater {
    public static void main(String[] args) {
        int[] arr = {3,2,5,7,2,34,1,5,8,23,2,8,8};
        Utils.Output.printArr(nextSmallestGreater(arr));
    }

    public static int[] nextSmallestGreaterOrEqual(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        TreeMap<Integer, Integer> map  = new TreeMap<>();
        for(int i=n-1; i>=0; i--){
            Integer nextSmallestGreater = map.ceilingKey(arr[i]);
            ans[i] = nextSmallestGreater ==  null ? -1 : map.get(nextSmallestGreater);
            map.put(arr[i], i);
        }
        return ans;
    }

    public static int[] nextSmallestGreater(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        TreeMap<Integer, Integer> map  = new TreeMap<>();
        for(int i=n-1; i>=0; i--){
            Integer nextSmallestGreater = map.ceilingKey(arr[i]+1);
            ans[i] = nextSmallestGreater ==  null ? -1 : map.get(nextSmallestGreater);
            map.put(arr[i], i);
        }
        return ans;
    }
}
