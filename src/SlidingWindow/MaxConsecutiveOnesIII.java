package SlidingWindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(arr, 2));
    }
    public static int longestOnes(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int start = 0;
        int window = 0;
        for(int end=0; end<n; end++){
            if(nums[end] == 0){
                count += 1;
                if(count > k){
                    while(start <= end && nums[start] == 1){
                        start += 1;
                    }
                    start += 1;
                    count -= 1;
                }
            }
            window = Math.max(window, end - start + 1);
        }
        return window;
    }
}
