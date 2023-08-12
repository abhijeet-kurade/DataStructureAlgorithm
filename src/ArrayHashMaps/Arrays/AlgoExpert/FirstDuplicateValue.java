package ArrayHashMaps.Arrays.AlgoExpert;

public class FirstDuplicateValue {


    public int firstDuplicateValue(int[] array) {
        int len = array.length;

        for(int i=0; i<len; i++ ){
            int ind = Math.abs(array[i]) - 1;
            if(array[ind] > 0)
                array[ind] *= -1;
            else
                return ind+1;
        }
        return -1;
    }
}
