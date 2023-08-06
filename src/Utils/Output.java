package Utils;

public class Output {
    public static void printArr(long[] arr){
        for(long num : arr) System.out.print(num + " ");
        System.out.println();
    }
    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num + " ");
        System.out.println();
    }
    public static void print2DArr(int[][] arr){
        for(int[] ar : arr) printArr(ar);
    }
}
