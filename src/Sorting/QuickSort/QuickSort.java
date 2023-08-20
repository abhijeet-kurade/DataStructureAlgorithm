package Sorting.QuickSort;

public class QuickSort{

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quickSort1(int[] arr, int start, int end){
        if(start >= end ) return;
        int p = start;
        int l = p+1;
        int r = end;

        while(l<r){
            if(arr[p] < arr[l] && arr[p] > arr[r]) swap(arr, l++, r--);
            if(arr[p] >= arr[l]) l += 1;
            if(arr[p] <= arr[r]) r -=1;
        }
        swap(arr, p, r);

        quickSort1(arr, start, r-1);
        quickSort1(arr, r+1, end);
        return;
    }
    public void quickSort(int[] arr, int start, int end){
        if(start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            if(arr[left] > arr[pivot] && arr[right] < arr[pivot]){
                swap(arr, left++, right--);
            }
            if(arr[left] <= arr[pivot]) left += 1;
            if(arr[right] >= arr[pivot]) right -= 1;
        }
        swap(arr, pivot, right);
        quickSort(arr, start+0, right-1);
        quickSort(arr, right+1, end+0);
        return;
    }
}
