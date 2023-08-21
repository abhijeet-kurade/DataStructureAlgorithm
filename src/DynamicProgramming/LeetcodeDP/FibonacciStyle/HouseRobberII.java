package DynamicProgramming.LeetcodeDP.FibonacciStyle;

public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int first = rob(nums, 0, n-2);
        int last = rob(nums, 1, n-1);
        return Math.max(first, last);
    }

    public int rob(int[] nums, int curr, int end) {
        int last_1 = 0, last_2 = 0;

        while(curr <= end){
            int temp = Math.max(nums[curr] + last_2, last_1);

            last_2 = last_1;
            last_1 = temp;
            curr += 1;
        }
        return last_1;
    }

}
