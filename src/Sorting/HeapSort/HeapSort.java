package Sorting.HeapSort;

public class HeapSort{
    public static int[] heapSort(int[] array) {
        int len = array.length-1;
        for(int ind = (len-1)/2; ind>=0; ind--)
            shiftDown(array, ind, len);
        int headEnd = len;
        for(int ind=len; ind>=0; ind--){
            swap(array, ind, 0);
            headEnd -= 1;
            shiftDown(array, 0, headEnd);
        }
        for(int ind = 0; ind<=(len-1)/2; ind++)
            swap(array, ind, len-ind);
        return array;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shiftDown(int[] arr, int index, int len){
        int parent = index;
        while(index <= len){
            int leftChild = 2 * parent + 1;
            if(leftChild > len) break;
            int rightChild = 2 * parent + 2;
            if(rightChild <= len){
                int minChild = Math.min(arr[leftChild], arr[rightChild]);
                System.out.println(minChild);
                if(minChild >= arr[parent]) break;
                int swapIndex = minChild == arr[leftChild] ? leftChild : rightChild;
                swap(arr, parent, swapIndex);
                parent = swapIndex;
            }
            else{
                if(arr[parent] > arr[leftChild]) swap(arr, parent, leftChild);
                break;
            }
        }
    }

}