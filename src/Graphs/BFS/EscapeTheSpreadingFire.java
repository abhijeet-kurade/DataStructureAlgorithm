package Graphs.BFS;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class EscapeTheSpreadingFire {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 2, 1, 0},
                {0, 2, 0, 0, 1, 2, 0},
                {0, 0, 2, 2, 2, 0, 2},
                {0, 0, 0, 0, 0, 0, 0}
        };

        int[][] g = {
                {0,2,0,0,1},
                {0,2,0,2,2},
                {0,0,0,0,0},
                {0,0,2,2,2},
                {0,0,0,0,0}
        };
        int[][] grid2 = {
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        int[][] g1 = {
                {0,1,1},
                {0,2,2},
                {0,0,0},
        };
        System.out.println(maximumMinutes(g1));
    }

    static class Node {
        int wait, jump;
        int x, y;

        public Node(int x, int y, int wait, int jump) {
            this.wait = wait;
            this.jump = jump;
            this.x = x;
            this.y = y;
        }
    }

    public static int maximumMinutes(int[][] mat) {
        Map<Integer, Integer> map = Map.of(2, -3, 0, 0, 1, 1);
        /*
        * wall = -3
        * grass = 0
        * fire = 1
        * */
        int rows = mat.length, cols = mat[0].length;
        int[][] grid = mat.clone();
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                grid[i][j] = map.get(mat[i][j]);
            }
        }
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    spreadFire(grid, i, j, 1);
                }
            }
        }

        Utils.Output.print2DArr(grid);
        if(pathWithNoFire(grid)) return (int) 1e9;
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2)-> {return o2.wait - o1.wait;});

        if(grid[0][0] != 1) queue.add(new Node(0, 0, grid[0][0] - 2, 1));
        visited[0][0] = true;
        int[][] dir = {{0,1},{0,-1},{1, 0},{-1, 0}};
        int ans = (int) 1e9;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x, y = node.y;
            int jump = node.jump;
            int wait = node.wait;
            ans = Math.min(ans, wait);
            for(int[] d : dir){
                int dx = x + d[0], dy = y + d[1];
                if(dx < 0 || rows <= dx || dy < 0 || cols <= dy) continue;
                if(grid[dx][dy] == -3 || visited[dx][dy]) continue;
                visited[dx][dy] = true;
                if(dx == rows-1 && dy == cols-1){
                    ans = Math.min(ans, grid[dx][dy] - (jump + 1));
                    return ans;
                }
                int wait_time = grid[dx][dy] - (jump + 2);
                if(wait_time < 0) continue;
                queue.add(new Node(dx, dy, wait_time, jump+1));
            }
        }
        return -1;
    }

    public static boolean pathWithNoFire(int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int[][] dir = {{0,1},{0,-1},{1, 0},{-1, 0}};
        while(!queue.isEmpty()){
            int[] c = queue.poll();
            int x = c[0], y = c[1];
            for(int[] d : dir){
                int dx = x+d[0], dy = y+d[1];
                if(dx<0 || rows <= dx || dy<0 || cols <= dy || grid[dx][dy] != 0 || visited[dx][dy]) continue;
                if(dx == rows-1 || dy==cols-1) return true;
                visited[dx][dy] = true;
                queue.add(new int[]{dx, dy});
            }
        }
        return false;
    }
    public static void spreadFire(int[][] grid, int row, int col, int time){
        int rows = grid.length, cols = grid[0].length;
        if(row<0 || rows <= row || col < 0 || cols <= col) return;
        if(grid[row][col] <= -2) return;

        if(grid[row][col] == 0 || grid[row][col] >= time){
            grid[row][col] = time;
            int[][] dir = {{0,1},{0,-1},{1, 0},{-1, 0}};
            for(int[] d : dir){
                spreadFire(grid, row+d[0], col+d[1] , time+1);
            }
        }
    }

}
