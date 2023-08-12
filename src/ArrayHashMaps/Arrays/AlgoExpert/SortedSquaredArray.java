package ArrayHashMaps.Arrays.AlgoExpert;

public class SortedSquaredArray {
    public int[] sortedSquaredArray(int[] array) {
        int len = array.length;
        int start = 0;
        int end = len-1;
        int[] squaredArray = new int[len];
        int index = len-1;

        while (start <= end){
            if(Math.abs(array[start]) > Math.abs(array[end])){
                squaredArray[index--] =  array[start] * array[start];
                start += 1;
            }
            else{
                squaredArray[index--] =  array[end] * array[end];
                end -= 1;
            }
        }
        return squaredArray;
    }
}
