package DynamicProgramming.TusharRoy;

public class MaximumSubSquareMatrix {
    public static void main(String[] args) {

    }

    public static int maxSubSquareMatrix(int[][] mat){
        int n=mat.length, m=mat[0].length;

        int side = 0;
        for(int i=0; i<n; i++){
            if(mat[i][0] == 1){
                side = 1;
                break;
            }
        }

        for(int i=0; i<m; i++){
            if(mat[0][1] == 1){
                side = 1;
                break;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) + 1;
                    side = Math.max(side, mat[i][j]);
                }
            }
        }


        return side * side;
    }

}
