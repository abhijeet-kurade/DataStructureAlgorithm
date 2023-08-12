package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.List;

public class IsValidSubsequence {
    public boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int len = sequence.size();
        int index =0;
        for(int num : array){
            if(num == sequence.get(index)){
                index += 1;
                if(index == len) return true;
            }
        }
        return false;
    }
}
