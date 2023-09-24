package SlidingWindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes1(arr, 2));
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


    public static int longestOnes1(int[] nums, int k){
        int n = nums.length;
        int start =0, end = 0, flips =0, ans =0;

        while(start < n){
            if(nums[start] == 1){
                start += 1;
            }
            else{
                if(flips < k){
                    flips += 1;
                    start += 1;
                }
                else {
                    while (flips == k){
                        if(nums[end] == 1){
                            end += 1;
                        }
                        else {
                            flips -= 1;
                            end += 1;
                        }
                    }
                }
            }
            ans = Math.max(ans, start-end);
        }
        return ans;
    }
}
