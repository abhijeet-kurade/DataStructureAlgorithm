package DynamicProgramming.TusharRoy;

import Utils.Output;

import java.util.Arrays;

public class MaximumSumRectangularSubMatrix {
    public static void main(String[] args) {
        int[] arr = {-7,-2,-17,-5};
        Output.printArr(kadane(arr));
    }

    public static int[] maxSumRectSubmatrix(int[][] mat){
        int height = mat.length;
        int width = mat[0].length;
        int[] sums = new int[height];
        int maxSum = (int)-1e8;
        int maxLeft=-1, maxRight=-1, maxUp=-1, maxDown=-1;
        for(int i=0; i<width; i++){
            for(int j=i; j<width; j++){
                addToSum(sums, mat, j);
                int[] maxSumSubArray  = kadane(sums);
                int currSum = maxSumSubArray[0];
                int up = maxSumSubArray[1];
                int down = maxSumSubArray[2];

                if(currSum > maxSum){
                    maxSum = currSum;
                    maxLeft = i;
                    maxRight = j;
                    maxUp = up;
                    maxDown = down;
                }
            }
            Arrays.fill(sums, 0);
        }

        return new int[]{maxSum, maxLeft, maxRight, maxUp, maxDown};
    }

    public static void addToSum(int[] sums, int[][] mat, int j){
        int n = mat.length;
        for(int i=0; i<n; i++){
            sums[i] += mat[i][j];
        }
    }

    public static int[] kadane(int[] arr){
        int n = arr.length;
        int curr = (int)-1e8, max = (int)-1e8;
        int start=-1, end=-1;
        for(int i=0; i<n; i++){
            if(curr <= 0){
                start = i;
            }
            curr = arr[i] + Math.max(curr, 0);
            if(max < curr){
                end = i;
            }
            max = Math.max(max, curr);
        }
        if(max < 0) start = end;
        return new int[]{max, start, end};
    }
}
