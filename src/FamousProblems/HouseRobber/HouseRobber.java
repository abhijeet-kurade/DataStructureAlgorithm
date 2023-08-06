package FamousProblems.HouseRobber;

public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        int second = 0, last = 0;

        for(int i=0; i<n; i++){
            int curr = Math.max(last, second + nums[i]);
            second = last;
            last = curr;
        }

        return last;

    }
}
