package DynamicProgramming.LeetcodeDP.FibonacciStyle;

public class HouseRobber {
    public int rob(int[] nums) {
        int last_2 = 0, last_1 = nums[0];
        int house = 1;

        while(house < nums.length){
            int temp = Math.max(last_1, nums[house] + last_2);
            last_2 = last_1;
            last_1 = temp;
            house += 1;
        }
        return Math.max(last_2, last_1);
    }
}
