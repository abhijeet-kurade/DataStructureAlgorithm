package ArrayHashMaps.Arrays.StriverSdeSheet.PartII;

public class RotateMatrix {
    public static void main(String[] args) {

    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void rotateSqrMatrix(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            int left=0, right=n-1;
            while(left<right) swap(matrix[i], left++, right--);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1-i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;
            }
        }
    }
}
