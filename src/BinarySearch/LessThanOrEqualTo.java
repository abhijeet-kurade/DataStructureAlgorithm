package BinarySearch;

import java.util.Arrays;
import java.util.List;

public class LessThanOrEqualTo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 3, 4, 5);
        System.out.println(binarySearch(list, 1));
    }

    public static int binarySearch(List<Integer> list, int num){
        int idx = -1;
        int left = 0, right = list.size() - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) == num){
                idx = mid;
                left = mid + 1;
            }
            else if(list.get(mid) < num){
                idx = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

        }

        return idx;
    }
}
