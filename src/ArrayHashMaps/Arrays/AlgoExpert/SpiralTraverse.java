package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        int height = array.length;
        int width = array[0].length;

        List<Integer> spiral = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = height-1;
        int colStart = 0;
        int colEnd = width-1;

        while(rowStart<=rowEnd && colStart <= colEnd){
            // top row
            for(int i=colStart; i<=colEnd; i++) spiral.add(array[rowStart][i]);
            //last col
            for(int i=rowStart+1; i<=rowEnd; i++) spiral.add(array[i][colEnd]);
            //last row
            for(int i=colEnd-1; i>=colStart; i--){
                if(rowStart==rowEnd) break;
                spiral.add(array[rowEnd][i]);
            }
            //first col
            for(int i=rowEnd-1; i>=rowStart+1; i--) {
                if(colStart==colEnd) break;
                spiral.add(array[i][colStart]);
            }

            rowStart += 1;
            rowEnd -= 1;
            colStart += 1;
            colEnd -= 1;
        }

        return spiral;
    }
}
