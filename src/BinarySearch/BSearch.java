package BinarySearch;

public class BSearch {
    public static void main(String[] args) {
        System.out.println(findKRotation(new int[]{1, 2 ,3}));

    }

    public static int binarySearch(int[] arr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            if(target < arr[mid]){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * target is 8
     * [ 1 3 5 12 15 17]
     *         ^
     * [1 3 8 8 8 20]
     *      ^
     */
    public static int greaterOrEqualBluePrint(int[] arr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                // go left
            }
            else if(target < arr[mid]){
                // go right
            }
            else if(arr[mid] < target){
                // go left
            }
        }
        return -1;
    }

    public static int greaterOrEqualOptimalCode(int[] arr, int left, int right, int target){
        int idx = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target){
                idx = mid;
                // go left
                right = mid - 1;
            }
            else{
                // go right
                left = mid + 1;
            }
        }
        return idx;
    }

    public static int findKRotation(int []arr){
        int left = 0, right = arr.length - 1;
        //[ 2 3 4 1]
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[left] < arr[mid] && arr[mid] < arr[right]) return left;
            if(arr[left] < arr[mid]){
                // go right
                left = mid;
            }
            else if(arr[mid] < arr[right]){
                // go left
                right = mid;
            }
            else{
                if(arr[left] <= arr[right]) return left;
                return right;
            }

        }
        return -1;
    }
}
