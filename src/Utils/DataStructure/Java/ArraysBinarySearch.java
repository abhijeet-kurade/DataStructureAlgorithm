package Utils.DataStructure.Java;

import java.util.Arrays;

public class ArraysBinarySearch {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,0,2, 2));


    }
}
