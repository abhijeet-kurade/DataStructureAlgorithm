package ArrayHashMaps.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6}
        };
        System.out.println(spiralOrder(arr));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int top = 0, left =0, bottom = n-1, right = m-1;

        while(top<=bottom && left<=right){


            for(int col=left; col<=right; col+=1){
                spiral.add(matrix[top][col]);
            }
            for(int row=top+1; row<=bottom; row+=1){
                spiral.add(matrix[row][right]);
            }
            if(left == right || top == bottom) break;
            for(int col=right-1; col>=left; col-=1){
                spiral.add(matrix[bottom][col]);
            }
            for(int row=bottom-1; row>top; row-=1){
                spiral.add(matrix[row][left]);
            }

            top += 1;
            left += 1;
            bottom -= 1;
            right -= 1;

        }

        return spiral;
    }
}
