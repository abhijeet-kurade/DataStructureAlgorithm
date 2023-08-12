package ArrayHashMaps.Arrays;

import java.util.Arrays;

public class MergeArraysWithoutExtraSpace {
    public void mergeArraysWithoutExtraSpace(int[] arr1, int[]arr2){
        // O(n*logn + m*logm)
        for(int z : arr1)
            System.out.print(z +" ");
        for(int z : arr2)
            System.out.print(z +" ");
        System.out.println();

        int i=0, j=0, k= arr1.length-1;
        while(i<k && j< arr2.length-1){
            if(arr1[i] < arr2[j]){
                i++;
            }
            else{
                int temp = arr1[k];
                arr1[k] = arr2[j];
                arr2[j] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int z : arr1)
            System.out.print(z +" ");
        for(int z : arr2)
            System.out.print(z +" ");
    }
}
