package FamousProblems.TheMaze;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/the-maze-ii/
public class TheMazeII {
    class Cell{
        int row, col, dist;
        public Cell(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] dir = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        int n = maze.length, m = maze[0].length;
        int[][] distance = new int[n][m];
        for(int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(start[0], start[1], 0));
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            int x = cell.row, y=cell.col;

            if(distance[x][y] < cell.dist) continue;

            distance[x][y] = cell.dist;
            for(int[] d : dir){
                int dx = x + d[0], dy = y + d[1];
                int steps = 0;
                while(0 <= dx && dx < n && 0 <= dy && dy < m && maze[dx][dy] == 0){
                    dx += d[0];
                    dy += d[1];
                    steps += 1;
                }
                dx -= d[0];
                dy -= d[1];
                if(dx == x && dy == y) continue;
                queue.offer(new Cell(dx, dy, cell.dist + steps));
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
