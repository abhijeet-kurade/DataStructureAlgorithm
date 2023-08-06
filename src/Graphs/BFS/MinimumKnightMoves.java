package Graphs.BFS;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumKnightMoves {
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.minKnightMoves(0, 1));
    }
}
class Solution {
    class Square{
        int x, y;
        int dist;
        int steps;
        public Square(int x, int y, int dist, int steps){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.steps = steps;
        }

        @Override
        public int hashCode(){
            int hash = 7;
            hash = hash * 31 + this.x;
            hash = hash * 31 + this.y;
            return hash;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Square obj = (Square) o;
            return (this.x == obj.x) && (this.y == obj.y);

        }
    }

    public int getManhattanDist(int x, int y, int a, int b){
        return Math.abs(x-a) + Math.abs(y-b);
    }
    public int minKnightMoves(int x, int y) {
        Set<Square> visited = new HashSet<>();
        PriorityQueue<Square> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.dist - o2.dist;
        });

        Square start = new Square(0,0, getManhattanDist(x, y, 0 ,0), 0);
        queue.add(start);


        int[][] dir ={{-2, -1},{-2, 1},{2, -1},{2, 1},{-1, -2},{1, -2},{-1, 2},{1, 2}};

        while(!queue.isEmpty()){
            Square square = queue.poll();
            int a = square.x, b = square.y;
            if(visited.contains(square)) continue;
            visited.add(square);
            if(a==x && b==y) return square.steps;
            for(int[] d : dir){
                int dx = a + d[0], dy = b + d[1];
                Square next = new Square(dx, dy, getManhattanDist(x, y, dx ,dy), square.steps+1);

                queue.add(next);

            }
        }
        return -1;
    }
}

