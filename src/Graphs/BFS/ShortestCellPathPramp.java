package Graphs.BFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ShortestCellPathPramp {

    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1},{0,0,0,1},{1,1,1,1}};

        System.out.println(shortestCellPath(arr,0,0,3,0));
    }
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here


        if(grid.length == 0) return -1;
        // if(grid.length<= tr) return -1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr,sc});
        Set<Integer> visited = new HashSet<>();

        int dir[] = {0,1,0,-1,0};
        int m = grid.length;
        int n = grid[0].length;
        visited.add(sr*m+sc);
        int level = 0;

        while(!queue.isEmpty()){
            level++;
            int size = queue.size(); //1
            for(int i=0; i<size; i++){
                int[] cell = queue.poll();  // 0 1
                // 4 directional
                // 0,1  1,0  0 -1  -1,0
                int x =0;
                for(int j=0; j< dir.length-1; j++){
                    int nrow = cell[0]+dir[j]; // 0
                    int ncol = cell[1]+dir[j+1]; // 2
                    int ncell = nrow*m+ncol;

                    if(nrow<0 || nrow>=m || ncol<0 || ncol>=n || grid[nrow][ncol]==0 || visited.contains(ncell)) continue;
                    if(nrow == tr && ncol == tc) return level;
                    visited.add(ncell); //
                    queue.add(new int[]{nrow,ncol});

                }
            }
        }
        return -1;

    }

}
