package FamousProblems.TheMaze;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/the-maze/
public class TheMaze {
    class Cell{
        int row, col;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        int[][] dir = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<Cell> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;

        queue.offer(new Cell(start[0],start[1]));
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            int x = cell.row, y=cell.col;
            if(dest[0] == x && dest[1] == y){
                return true;
            }
            for(int[] d : dir){
                int dx = x + d[0], dy = y + d[1];
                while(0 <= dx && dx < n && 0 <= dy && dy < m && maze[dx][dy] == 0){
                    dx += d[0];
                    dy += d[1];
                }
                dx -= d[0];
                dy -= d[1];
                if(!visited[dx][dy]){
                    visited[dx][dy] = true;
                    queue.offer(new Cell(dx, dy));
                }
            }
        }
        return false;
    }
}
