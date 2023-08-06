package SlidingWindow;


// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray1(int[] nums) {
        int n = nums.length;
        int count  = 0;
        int start = 0, ans = 0;
        for(int end=0; end < n; end ++ ){
            if(nums[end] == 1){
                ans = Math.max(ans, end - start + 1 - count);
            }
            else if(count <= 0){
                count += 1;
            }
            else{
                while(count > 0 && start <= end){
                    if(nums[start] == 0){
                        count -= 1;
                    }
                    start += 1;
                }
                end -= 1;
            }
        }
        return ans==n ? n-1 : ans;
    }

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int count  = 0;
        int end =0, start = 0, ans = 0;
        while (end < n){
            if(nums[end] == 1){
                ans = Math.max(ans, end - start + 1 - count);
                end += 1;
            }
            else if(count <= 0){
                count += 1;
                end += 1;
            }
            else{
                while(count > 0 && start <= end){
                    if(nums[start] == 0){
                        count -= 1;
                    }
                    start += 1;
                }
            }
        }
        return ans==n ? n-1 : ans;
    }

}
