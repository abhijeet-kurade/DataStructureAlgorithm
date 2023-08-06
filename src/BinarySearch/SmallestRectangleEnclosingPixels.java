package BinarySearch;

public class SmallestRectangleEnclosingPixels {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchColumns(image, 0, y, 0, m, true);
        int right = searchColumns(image, y + 1, n, 0, m, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') ++k;
            if (k < bottom == whiteToBlack) // k < bottom means the column mid has black pixel
                j = mid; //search the boundary in the smaller half
            else
                i = mid + 1; //search the boundary in the greater half
        }
        return i;
    }
    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') ++k;
            if (k < right == whiteToBlack) // k < right means the row mid has black pixel
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }


    public static void main(String[] args) {
        int[][] image = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0},
                {0,0,0,0,0,1,1,0,1,1,1,1,0,0,0},
                {0,0,0,0,1,1,0,0,0,1,0,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        int m = image.length, n=image[0].length;
        int x = 4, y =7;
        System.out.println(getTopLeftCornerRow(image, 0, y, 0, m, true));
        System.out.println(getTopLeftCornerRow(image, y+1, n, 0, m, false));
        System.out.println(getTopRightCornerRow(image, y+1, n, 0, m, false));
    }
    //                                              0      7        0             m = 9
    private static int getTopLeftCornerRow(int[][] image, int i, int j, int rowStart, int rowEnd, boolean goLeft){
        while(i != j){
            int mid = (i + j) / 2;
            int k = rowStart;
            while (k<rowEnd && image[k][mid] == 0) k++;
            if(k < rowEnd == goLeft){
                j = mid;
            }
            else{
                i = mid+1;
            }
        }
        return i;
    }

    private static int getTopRightCornerRow(int[][] image, int i, int j, int rowStart, int rowEnd, boolean goLeft){
        if(i != j){
            int k = rowStart;
            int mid = (i + j) / 2;
            while(k < rowEnd && image[k][mid] == 0) k += 1;
            if(k >= rowEnd){
                j = mid;
            }
            else{
                i = mid+1;
            }

        }
        return i;
    }

}
