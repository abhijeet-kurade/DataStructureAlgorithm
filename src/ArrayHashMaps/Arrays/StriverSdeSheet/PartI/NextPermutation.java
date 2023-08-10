package ArrayHashMaps.Arrays.StriverSdeSheet.PartI;

public class NextPermutation {
    public static void main(String[] args) {

    }

    public static int[] nextPermutation(int[] arr){
        /*
         *
         * step 1 : the number from end that breaks ascending ordering. Let's say it's at index i.
         * step 2 : find the next max number after it. Index j.
         * step 3 : swap them index i & j
         * step 4 : reverse the array from i to end.
         *
         * */

        int n = arr.length;
        int index = -1;
        int idx = n-1;

        while(idx > 0){
            if(arr[idx-1] < arr[idx]){
                index = idx-1;
                break;
            }
            idx -= 1;
        }
        if(index == -1){
            reverseArray(arr, 0, n-1);
            return arr;
        }
        int nextGreater = index+1;
        for(int i=index+1; i<n;i++){
            if( arr[index] < arr[i] && arr[i] < arr [nextGreater]){
                nextGreater = i;
            }
        }
        swap(arr, index, nextGreater);
        reverseArray(arr, index+1, n-1);
        return arr;
    }

    public static void reverseArray(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 1;
            right += -1;
        }
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
