package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UniqueString {

    public static int uniqueString(String str, int[] arr){
        int n= str.length();
        int left = -1, right = -1;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < n){
            while(++right < n && map.get(str.charAt(right)) == null){
                map.put(str.charAt(right), 1);
                if(max < (right-left)){
                    max = right -left;
                    arr[0]=max; arr[1]=left+1; arr[2]=right;
                }
            }
            if(right == n) break;
            map.put(str.charAt(right), 2);
            while(map.get(str.charAt(++left)) == 1){
                map.remove(str.charAt(left));
            }
            map.put(str.charAt(left), 1);
        }
        return max;
    }

}
