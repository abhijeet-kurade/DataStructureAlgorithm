package SlidingWindow;


import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanEqualLimit {
    public static void main(String[] args) {
        int[] arr = {10,1,2,4,7,2};
        System.out.println(longestSubarray(arr, 5));
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int size = 0;
        int left =0;
        int right =0;
        while(right < nums.length){
            int val  = nums[right];

            while(!min.isEmpty() && nums[min.peekLast()]>=val) min.removeLast();
            while(!max.isEmpty() && nums[max.peekLast()]<=val) max.removeLast();

            min.add(right);
            max.add(right);

            int minVal = nums[min.peekFirst()];
            int maxVal = nums[max.peekFirst()];

            if(maxVal - minVal <= limit) {
                size = Math.max(size, right-left+1);
                right++;
            }
            else {
                left++;
                while(left > min.peekFirst()) min.removeFirst();
                while(left > max.peekFirst()) max.removeFirst();
            }
        }
        return size;
    }
}
