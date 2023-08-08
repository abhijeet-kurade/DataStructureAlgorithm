package DynamicProgramming;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] arr){
        int height = arr.length;
        int width = arr[0].length;

        int[][] cache = new int[height][width];
        int maxPath = 1;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(cache[i][j] != 0) continue;
                int path = getLongestPath(i, j, arr, cache);
                maxPath = Math.max(maxPath, path);
            }
        }

        return maxPath;
    }

    public boolean isSafe(int[][] arr, int row, int col, int val){
        int height = arr.length;
        int width = arr[0].length;

        return 0<=row && row<height && 0<=col && col<width && arr[row][col]>val;
    }

    public int getLongestPath(int row, int col, int[][] arr, int[][] cache){
        int[] dx = {1, -1, 0,0};
        int[] dy = {0,0,1,-1};
        int maxPath = 1;
        for(int i=0; i<4; i++){
            int x = row + dx[i];
            int y = col + dy[i];
            if(!isSafe(arr, x, y, arr[row][col])) continue;
            if(cache[x][y] != 0){
                maxPath = Math.max(maxPath, cache[x][y]+1);
            }
            else{
                int path = getLongestPath(x, y, arr, cache);
                maxPath = Math.max(maxPath, path+1);
            }
        }
        cache[row][col] = maxPath;
        return maxPath;
    }
}
