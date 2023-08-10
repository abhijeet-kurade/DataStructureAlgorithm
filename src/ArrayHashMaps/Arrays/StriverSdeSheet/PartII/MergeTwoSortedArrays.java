package ArrayHashMaps.Arrays.StriverSdeSheet.PartII;

public class MergeTwoSortedArrays {
    public static void mergeSortedArray(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int window = (int) Math.ceil((n+m)/2);
        while(window>0){
            int left = 0;
            int right = window;
            while (right < (m+n)){
                int num1 = left < n ? arr1[left] : arr2[left-n];
                int num2 = right < n ? arr1[right] : arr2[right-n];
                if(left < n ) arr1[left] = Math.min(num1, num2);
                else arr2[left-n] = Math.min(num1, num2);
                if(right < n) arr1[right] = Math.max(num1, num2);
                else arr2[right-n] = Math.max(num1, num2);
                left += 1;
                right += 1;
            }
            window += -1;
        }
    }
}
