package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.Collections;
import java.util.List;

public class MoveElementToEnd {
    public List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int len = array.size();

        int indToMove = -1;
        int indNonToMove = -1;

        for(int i=0; i<len; i++){
            if(array.get(i) == toMove) {
                indToMove = i;
                break;
            }
        }

        if(indToMove == -1 || indToMove == len-1) return array;

        for(int i=indToMove+1; i<len; i++){
            if(array.get(i) != toMove) {
                indNonToMove = i;
                break;
            }
        }

        if(indNonToMove == -1 ) return array;

        while (indNonToMove < len && indToMove < len){
            Collections.swap(array, indToMove, indNonToMove);
            indToMove = indToMove + 1;
            for(int i=indToMove; i<len; i++){
                if(array.get(i) != toMove){
                    indNonToMove = i;
                    break;
                }
            }
        }

        return array;
    }

}
