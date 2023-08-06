package FamousProblems.JumpGame;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int next = nums[0];
        int curr = 1;
        while(curr < n){
            if(next < curr) return false;
            int p = next;
            for(; curr<=p; curr++ ){
                next = Math.max(next , curr + nums[curr]);
            }
        }
        return true;
    }
}
