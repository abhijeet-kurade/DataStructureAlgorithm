package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse {

    public List<Integer> zigzagTraverse(List<List<Integer>> array) {

        int height = array.size()-1;
        int width = array.get(0).size()-1;

        int row = 0;
        int col = 0;

        List<Integer> traverse = new ArrayList<>();
        char direction = 'D';
        while(0<=row && row<=height && 0<=col && col<=width){
            traverse.add(array.get(row).get(col));
            if(direction == 'D'){
                if(col != 0 && row != height) {
                    row += 1;
                    col -= 1;
                }
                else{
                    direction = 'U';
                    if(row == height)
                        col += 1;
                    else
                        row += 1;
                }
            }
            else {
                if(row != 0 && col != width){
                    row -= 1;
                    col += 1;
                }
                else{
                    direction = 'D';
                    if(col == width)
                        row += 1;
                    else
                        col += 1;
                }
            }
        }
        return traverse;
    }
}
