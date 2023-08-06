package DynamicProgramming.TusharRoy;

import Utils.Output;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[][] arr = {{10,30}, {30,5}, {5,60}};
        System.out.println(matrixChainMultiplication(arr));
    }

    public static int matrixChainMultiplication(int[][] matrices){
        int n = matrices.length;
        int[] d = new int[n+1];
        for(int i=0; i<n; i++){
            d[i] = matrices[i][0];
        }
        d[n] = matrices[n-1][1];

        Output.printArr(d);
        System.out.println();
        int[][] cost = new int[n][n];

        int curr = 0;
        for(int w=1; w<n; w++){
            for(int i=0; i+w<n; i++){
                int j = i+w;
                curr = Integer.MAX_VALUE;
                for(int k=i+1; k<=j; k++){
                    curr = Math.min(curr, cost[i][k-1] + cost[k][j] + d[i]*d[k]*d[j+1]);
                }
                cost[i][j] = curr;
            }
        }
        Output.print2DArr(cost);
        return curr;
    }

    public static int gfgMatrixMultiplication(int N, int d[]){
        int n = d.length-1;
        int[][] cost = new int[n][n];
        int curr = 0;
        for(int w=1; w<n; w++){
            for(int i=0; i+w<n; i++){
                int j = i+w;
                curr = Integer.MAX_VALUE;
                for(int k=i+1; k<=j; k++){
                    curr = Math.min(curr, cost[i][k-1] + cost[k][j] + d[i]*d[k]*d[j+1]);
                }
                cost[i][j] = curr;
            }
        }
        return curr;
    }
}
