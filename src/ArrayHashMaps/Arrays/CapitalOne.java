package ArrayHashMaps.Arrays;

public class CapitalOne {
    public static void main(String[] args) {
        int[] arr  = {12, 23, 354, 32};
        System.out.println(sumOfFirstElementInCompleteBTree(arr));
    }

    public static int sumOfFirstElementInCompleteBTree(int[] arr){
        int sum = 0;
        int idx = 1;
        while(idx-1 < arr.length){
            sum += arr[idx-1];
            idx <<= 1;
        }
        return sum;
    }
}
