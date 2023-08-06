package DynamicProgramming.TusharRoy;

import Utils.Output;

import java.util.Stack;

public class MaximumSizeRectangle {
    public static void main(String[] args) {
        int[][] mat = {
                {1,0,0,1,1,1},
                {1,0,0,1,1,1},
                {1,0,0,1,1,1},
                {1,0,0,1,1,1}
        };
        int[] arr = {4, 0, 4, 4, 4};
        Output.printArr(maxSizeRectangle(mat));

    }

    public static int[] maxSizeRectangle(int[][] mat){
        int height = mat.length;
        int width = mat[0].length;
        int[] row = new int[width];
        int left=-1, right=-1, top=-1, bottom=-1;
        int area = -1;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(mat[i][j] == 0) row[j] = 0;
                else row[j] += 1;
            }
            int[] rect = maxRectangularArea(row);
            int curr = rect[0];
            if(area < curr){
                area = curr;
                left = rect[1];
                right = rect[2];
                top = i;
                bottom = i-rect[3]+1;
            }
        }

        return new int[]{area, left, right, top, bottom};
    }

    public static int[] maxRectangularArea(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.add(i);
        }
        stack.clear();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) right[i] = n;
            else right[i] = stack.peek();
            stack.add(i);
        }

        int area = 0, leftIdx =-1, rightIdx = n, top = 0;
        for(int i=0; i<n; i++){
            int curr = arr[i] * (right[i] - left[i] - 1);
            if(area < curr){
                area = curr;
                leftIdx = left[i] + 1;
                rightIdx = right[i] - 1;
                top = arr[i];
            }
        }

        return new int[]{area, leftIdx, rightIdx, top};
    }
}
