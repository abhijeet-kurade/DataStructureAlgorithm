package ArrayHashMaps.Arrays.StriverSdeSheet.PartI;

public class ColorSort {

    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static int[] sortColors(int[] arr){
        int left = 0, mid = 0, right = arr.length - 1;
        while(mid <= right){
            if(arr[mid]==0) swap(arr, left++, mid);
            else if(arr[mid] == 2) swap(arr, right--, mid--);
            mid += 1;
        }
        return arr;
    }
}
