package DynamicProgramming.TusharRoy;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int next = nums[0];
        int steps = 1;
        int curr = 1;
        while(curr < n){
            if(next >= n-1) return steps;
            int p = next;
            for(; curr<=p; curr++ ){
                next = Math.max(next , curr + nums[curr]);
            }
            steps += 1;
        }
        return steps;
    }
}
