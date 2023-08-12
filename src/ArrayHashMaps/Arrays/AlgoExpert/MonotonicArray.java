package ArrayHashMaps.Arrays.AlgoExpert;

public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        char o = 'N';
        int len = array.length;

        for(int i=0; i<len-1; i++){
            if(array[i]<array[i+1]){
                o = 'I';
                break;
            }
            else if(array[i]>array[i+1]){
                o='D';
                break;
            }
        }
        if(o == 'N'){
            return true;
        }

        for(int i=0; i<len-1; i++){
            if(o=='I'){
                if(array[i]>array[i+1])
                    return false;
                continue;
            }
            else{
                if(array[i]<array[i+1])
                    return false;
                continue;
            }
        }
        return true;
    }
}
