package BitManipulations;

public class TwoNonRepeatingNumbers {
    public static int[] twoNonRepeatingNumbers(int[] arr){
        int xor = 0;
        for( int num : arr) xor ^= num;
        //getBinaryRepresentation(xor);
        //getBinaryRepresentation(-xor);
        xor &= (-xor);
        //getBinaryRepresentation(xor);
        int num1=0, num2=0;
        for(int num : arr){
            if((num & xor) > 0) num1 ^= num;
            else num2 ^= num;
        }
        //getBinaryRepresentation(num1);
        //getBinaryRepresentation(num2);
        return new int[]{num1, num2};
    }

}
