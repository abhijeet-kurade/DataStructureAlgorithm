package ArrayHashMaps.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/detect-squares/
public class DetectSquares {


    class StringSolution{
        List<String> points;
        Map<String, Integer> map;
        public StringSolution() {
            this.points = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public void add(int[] point) {
            String pt = getPoint(point);
            this.points.add(pt);
            if(!this.map.containsKey(pt)) this.map.put(pt, 0);
            map.put(pt, map.get(pt)+1);
        }

        public int count(int[] point) {
            int x= point[0], y=point[1];
            int count = 0;
            for(String pt : points){
                int[] dia =  getPoint(pt);
                int dx = dia[0], dy = dia[1];
                if(Math.abs(x-dx) != Math.abs(y-dy)) continue;
                if(x == dx || y == dy) continue;

                int lx = dx, ly = y;
                int rx = x, ry = dy;

                String left = getPoint(new int[]{lx, ly});
                String right = getPoint(new int[]{rx, ry});

                if(this.map.containsKey(left) && this.map.containsKey(right)){
                    int leftPoints = this.map.get(left);
                    int rightPoints = this.map.get(right);
                    count += leftPoints * rightPoints;
                }
            }
            return count;
        }

        private int[] getPoint(String point){
            String[] pt = point.split(":");
            return new int[]{Integer.parseInt(pt[0]),Integer.parseInt(pt[1])};
        }

        private String getPoint(int[] point){
            return String.valueOf(point[0]) +":"+String.valueOf(point[1]);
        }


    }

    class ClassSolution{
        class Point{
            int x, y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return 1;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x && y == point.y;
            }
        }
        HashMap<Point, Integer> points;
        List<Point> list;
        public ClassSolution(){
            this.points = new HashMap<>();
            this.list = new ArrayList<>();
        }
        public void add(int[] point){
            Point p = new Point(point[0], point[1]);
            this.list.add(p);
            if(!this.points.containsKey(p)) this.points.put(p, 0);
            this.points.put(p, this.points.get(p)+1);
        }
        public int count(int[] point){
            int x1 = point[0], y1 = point[1];
            int count = 0;
            for(Point p : this.list){
                int x2 = p.x, y2 = p.y;

                if(x1 == x2 || y1 == y2) continue;
                if(Math.abs(x1 - x2) != Math.abs(y1 - y2)) continue;

                Point topLeft = new Point(x2, y1);
                Point bottomRight = new Point(x1, y2);

                if(this.points.containsKey(topLeft) && this.points.containsKey(bottomRight)){
                    count += this.points.get(topLeft) * this.points.get(bottomRight);
                }
            }
            return count;
        }

    }
}

