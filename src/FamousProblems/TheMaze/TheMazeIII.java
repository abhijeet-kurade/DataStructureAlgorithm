package FamousProblems.TheMaze;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/the-maze-iii/
public class TheMazeIII {
    class Cell{
        int row, col, dist;
        StringBuilder path;
        public Cell(int row, int col, int dist, StringBuilder path){
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.path = path;
        }
    }
    public String findShortestWay(int[][] maze, int[] start, int[] dest) {
        int[][] dir = {{1, 0},{0, -1},{0, 1},{-1, 0}};
        int n = maze.length, m = maze[0].length;

        int[][] distance = new int[n][m];
        for(int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        String ans = "z";
        Queue<Cell> queue = new LinkedList<>();

        queue.offer(new Cell(start[0], start[1], 0, new StringBuilder()));
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            int x = cell.row, y=cell.col;

            if(distance[x][y] < cell.dist) continue;

            distance[x][y] = cell.dist;
            for(int i=0; i<4; i++){
                int[] d = dir[i];
                int dx = x , dy = y;
                int steps = 0;
                StringBuilder path= new StringBuilder(cell.path);
                path.append(getDir(i));
                while(0 <= dx && dx < n && 0 <= dy && dy < m && maze[dx][dy] == 0){

                    if(dx == dest[0] && dy == dest[1]){
                        if(cell.dist + steps < distance[dx][dy]){
                            ans = path.toString();
                            distance[dx][dy] = cell.dist + steps;
                        }
                        else if(cell.dist + steps == distance[dx][dy]){
                            if(ans.compareTo(path.toString()) > 0){
                                ans = path.toString();
                                distance[dx][dy] = cell.dist + steps;
                            }
                        }

                    }

                    dx += d[0];
                    dy += d[1];
                    steps += 1;


                }
                dx -= d[0];
                dy -= d[1];
                steps -= 1;
                if(dx == x && dy == y) continue;
                queue.offer(new Cell(dx, dy, cell.dist + steps, new StringBuilder(path)));
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? "impossible" : ans;
    }
    public char getDir(int d){
        if(d == 0) return 'd';
        if(d == 1) return 'l';
        if(d == 2) return 'r';
        return 'u';
    }
}
