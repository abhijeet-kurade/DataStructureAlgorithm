package ArrayHashMaps.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap2(int[] height) {
        int n = height.length;
        int water =0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];



        return water;
    }

    public static int trap(int[] height) {
        int n = height.length;
        int start = 1, end = n-2;
        int water =0;
        int left = height[0], right = height[n-1];
        while(start <= end){
            int level = Math.min(left, right);
            if(left <= right){
                if(level > height[start]){
                    water += level - height[start];
                }
                left = Math.max(left, height[start]);
                start += 1;
            }
            else{
                if(level > height[end]){
                    water += level - height[end] ;
                }
                right = Math.max(right, height[end]);
                end -= 1;
            }
        }
        return water;
    }
}
