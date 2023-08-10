package BitManipulations;

public class RepeatAndMissingNumber {
    public static void main(String[] args) {

    }

    public int[] findMissingReapingNumber(int[] nums){
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor ^= nums[i];
            xor ^= i +1;
        }

        int diff = xor & (-xor);
        int num1 = 0, num2 = 0;
        for(int i=1; i<=nums.length; i++){
            if( (i & diff) != 0){
                num1 ^= i;
            }
            else{
                num2 ^= i;
            }
        }
        return new int[]{num1, num2};
    }
}
