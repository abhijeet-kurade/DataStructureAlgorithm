package DynamicProgramming.LeetcodeDP.Matrix;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] last = new int[cols];
        int sqr = 0;

        for(int i=0; i<rows; i++){
            int[] temp = new int[cols];
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == '0') continue;
                int top = last[j];
                int left = j == 0 ? 0 : temp[j-1];
                int dia = j == 0 ? 0 : last[j-1];
                temp[j] = Math.min(top, Math.min(left, dia)) + 1;

                sqr = Math.max(sqr, temp[j]);
            }
            last = temp;
        }

        return sqr * sqr;

    }
}
