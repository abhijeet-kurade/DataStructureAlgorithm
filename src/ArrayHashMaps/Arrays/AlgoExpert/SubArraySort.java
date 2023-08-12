package ArrayHashMaps.Arrays.AlgoExpert;

public class SubArraySort {

    public int[] subArraySort(int[] array) {

        int len = array.length;
        int unordered_min = Integer.MIN_VALUE;
        int unordered_max = Integer.MAX_VALUE;

        boolean num_found = false;
        for(int i=1; i<len; i++){
            if(!num_found && array[i-1] > array[i]){
                unordered_min = array[i];
                num_found = true;
                continue;
            }
            unordered_min = Math.min(unordered_min, array[i]);

        }
        if(unordered_min == Integer.MIN_VALUE) return new int[] {-1, -1};

        num_found = false;
        for(int i=len-2; i>=0; i--){
            if(!num_found && array[i] > array[i+1]){
                unordered_max = array[i];
                num_found = true;
                continue;
            }
            unordered_max = Math.max(unordered_max, array[i]);
        }

        for(int i=0; i<len; i++){
            if(unordered_min < array[i]){
                unordered_min = i;
                break;
            }
        }

        for(int i=len-1; i>=0; i--){
            if(unordered_max > array[i]){
                unordered_max = i;
                break;
            }
        }
        return new int[] {unordered_min, unordered_max};
    }

}
