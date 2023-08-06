package Graphs.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
public class ShortestPathInAGridWithObstaclesElimination {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},
                        {1,1,1,1},
                        {0,1,0,0},
                        {1,1,1,1},
                        {0,0,0,0}};
        System.out.println(shortestPath(grid, 1));
    }
    public static int shortestPath(int[][] grid, int k) {
        int n = grid.length, m=grid[0].length;
        int[][] power = new int[n][m];
        for(int[] arr : power) Arrays.fill(arr, -1);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,k,0});
        int[][] dir = {{0, 1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col=cell[1], dist=cell[3], lives = cell[2];
            if(row==n-1 && col==m-1) return dist;
            if(grid[row][col] == 1) lives -= 1;
            for(int[] d : dir){
                int nr = row + d[0], nc = col+d[1];
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(power[nr][nc] >= lives) continue;
                queue.add(new int[]{nr, nc, lives, dist+1});
                power[nr][nc] = lives;
            }
        }
        return -1;
    }

    public static int shortestPath(int[][] grid) {
        int n = grid.length, m=grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        int[][] directions = {{0, 1},{0, -1},{-1, 0},{1, 0}};
        boolean[][] visited = new boolean[n][m];
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], dist = cell[2];
            if(row == n-1 && col == m-1) return dist;
            if( row<0 || row>=n || col<0 || col>=m ) continue;
            if(grid[row][col] == 1) continue;
            if(visited[row][col]) continue;
            visited[row][col] = true;
            for(int[] dir : directions){
                queue.add(new int[] { row + dir[0], col + dir[1], dist + 1 });
            }
        }
        return -1;
    }


    public static int shortestPath1(int[][] grid) {
        int n = grid.length, m=grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        int[][] dir = {{0, 1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col=cell[1], dist=cell[2];
            if(row==n-1 && col==m-1) return dist;
            if(grid[row][col] == 1) continue;
            for(int[] d : dir){
                int nr = row + d[0], nc = col+d[1];
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(visited[nr][nc]) continue;
                queue.add(new int[]{nr, nc, dist+1});
                visited[nr][nc] = true;
            }
        }
        return -1;
    }




}
