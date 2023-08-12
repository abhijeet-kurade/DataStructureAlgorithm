package ArrayHashMaps.Arrays;

public class QuickSelect {
    public int quickSelect(int[] nums, int start, int end, int m){

        while(true){
            if(start > end) return -1;
            int pivot = start;
            int left = start + 1;
            int right = end;

            while(left <= right){
                if(nums[left] > nums[pivot] && nums[right] < nums[pivot]){
                    swap(nums, left, right);
                    left += 1;
                    right -= 1;
                }
                if(nums[left] <= nums[pivot]) left += 1;
                if(nums[right] >= nums[pivot]) right -= 1;
            }

            swap(nums, pivot, right);
            if(right == m) return nums[right];
            else if(right < m) start = right+1;
            else end = right -1;
        }


    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
