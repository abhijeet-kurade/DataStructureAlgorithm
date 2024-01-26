package Graphs.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    public static void main(String[] args) {
        for(char c = 'a'; c<= 'z'; c++){
            System.out.println(c + " " +(int)(c));
        }
    }

    public static int shortestPath(int[][] grid, int k){

        int n = grid.length, m = grid[0].length;
        int[][] power = new int[n][m];

        for(int[] arr : power) Arrays.fill(arr, -1);
        Queue<int[]> queue = new LinkedList<>();

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.add(new int[]{0, 0, 0, k});

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], steps = cell[2], lives = cell[3];
            if(grid[r][c] == 1) lives -= 1;
            if(r == n-1 && c == m-1) return steps;
            for(int[] d : dir){
                int rx = r + d[0], cx = c + d[1];
                if(rx < 0 || rx >= n || cx < 0 || cx >= m) continue;
                if(power[rx][cx]>=lives) continue;
                queue.add(new int[]{rx, cx, steps+1, lives});
                power[rx][cx] = lives;
            }
        }

        return -1;
    }
}
