package Sorting.MergeSort;

public class MergeSort{
    public static void main(String[] args) {
        int[] arr = new int[]{9,-1,0,77,-90};

        int[] aux = mergeSort(arr);
        //print_arr(aux);
    }
    public static int[] mergeSort(int[] array) {
        int len = array.length;
        int[] aux = new int[len];
        splitList(array, 0, len-1, aux);
        return aux;
    }

    public static void splitList(int[] arr, int start, int end, int[] aux){
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        splitList(arr, start, mid, aux);
        splitList(arr, mid+1, end, aux);
        toMerge(arr, start,  end, aux);
    }

    public static void toMerge(int[] arr, int start, int end, int[] aux){
        int mid = start + (end - start) / 2;
        int middle = mid;
        mid += 1;
        int index = start;
        while(start <= middle || mid <= end){
            int numOne = start <= middle ? arr[start] : Integer.MAX_VALUE;
            int numTwo = mid <= end ? arr[mid] : Integer.MAX_VALUE;
            if(numOne <= numTwo){
                aux[index] = numOne;
                start += 1;
            }
            else {
                aux[index] = numTwo;
                mid += 1;
            }
            index += 1;
        }
    }
    public static int[] merge(int[] listOne, int[] listTwo){
        int lenOne = listOne.length;
        int lenTwo = listTwo.length;
        int[] merged = new int[lenOne + lenTwo];
        int indexOne = 0;
        int indexTwo = 0;
        int index = 0;
        while(indexOne < lenOne || indexTwo < lenTwo){
            int numOne = indexOne < lenOne ? listOne[indexOne] : Integer.MAX_VALUE;
            int numTwo = indexTwo < lenTwo ? listTwo[indexTwo] : Integer.MAX_VALUE;
            if(numOne <= numTwo){
                merged[index] = numOne;
                indexOne += 1;
            }
            else {
                merged[index] = numTwo;
                indexTwo += 1;
            }
            index += 1;
        }
        return merged;
    }
}
