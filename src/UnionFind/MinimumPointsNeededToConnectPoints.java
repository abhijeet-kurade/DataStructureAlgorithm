package UnionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MinimumPointsNeededToConnectPoints {
    public static void main(String[] args) {
        MinimumPointsNeededToConnectPoints obj = new MinimumPointsNeededToConnectPoints();
        int[][] points =  {
                {-1, 1},
                {1, 3},
                {2, 2},
                {-5, -5},
                {-4, -3},
                {-4, 3}
        };

        System.out.println(obj.addPoints(points));
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    class Pair{

        int rank;
        Point parent;

        public Pair(int rank, Point parent) {
            this.rank = rank;
            this.parent = parent;
        }
    }
    class UnionFind{
        public HashMap<Point, Pair> uf;

        public UnionFind() {
            this.uf = new HashMap<>();
        }

        public void union(Point x, Point y){
            if(!uf.containsKey(x)){
                uf.put(x, new Pair(0, x));
            }
            if(!uf.containsKey(y)){
                uf.put(y, new Pair(0, y));
            }

            Point px = find(x);
            Point py = find(y);

            if(px.equals(py)) return;

            if(uf.get(px).rank == uf.get(py).rank){
                uf.get(py).parent = px;
                uf.get(px).rank += 1;
            }
            else if(uf.get(px).rank > uf.get(py).rank){
                uf.get(py).parent = px;
            }
            else{
                uf.get(px).parent = py;
            }
        }


        public Point find(Point point){
            if(!uf.containsKey(point)){
                uf.put(point, new Pair(0, point));
            }
            if(point.equals(uf.get(point).parent)) return point;
            uf.get(point).parent = find(uf.get(point).parent);
            return uf.get(point).parent;
        }
    }

    public int addPoints(int[][] points){

        HashMap<Integer, Point> xCord = new HashMap<>();
        HashMap<Integer, Point> yCord = new HashMap<>();
        UnionFind uf = new UnionFind();

        for(int[] pt : points){
            Point point = new Point(pt[0], pt[1]);
            uf.find(point);
            if(xCord.containsKey(point.x)){
                Point point2 = xCord.get(point.x);
                uf.union(point, point2);
            }
            if(yCord.containsKey(point.y)){
                Point point2 = yCord.get(point.y);
                uf.union(point, point2);
            }
            xCord.put(point.x, point);
            yCord.put(point.y, point);
        }

        Set<Point> leaders = new HashSet<>();
        for(int[] pt : points){
            Point point = new Point(pt[0], pt[1]);
            Point leader = uf.find(point);
            leaders.add(leader);
        }

        return leaders.size() - 1;
    }
}
