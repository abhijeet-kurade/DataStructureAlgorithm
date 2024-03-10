package ComputationalGeometry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class FindGroupsOfConnectedCircles {
    public static void main(String[] args) {

    }

    static class Circle {
        int x, y, rad;

        public Circle(int x, int y, int rad) {
            this.x = x;
            this.y = y;
            this.rad = rad;
        }
    }

    static class Event {
        int x;
        boolean isStart;
        int index;

        public Event(int x, boolean isStart, int index) {
            this.x = x;
            this.isStart = isStart;
            this.index = index;
        }
    }

    static class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }

        public boolean allConnected() {
            int root = find(0);
            for (int i = 1; i < parent.length; i++) {
                if (find(i) != root) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean circlesOverlap(Circle c1, Circle c2) {
        int dx = c1.x - c2.x;
        int dy = c1.y - c2.y;
        int distanceSquared = dx * dx + dy * dy;
        int radiusSum = c1.rad + c2.rad;
        return distanceSquared < radiusSum * radiusSum;
    }


    public static boolean findOverlappingCircles(List<Circle> circles) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < circles.size(); i++) {
            Circle circle = circles.get(i);
            events.add(new Event(circle.x - circle.rad, true, i));
            events.add(new Event(circle.x + circle.rad, false, i));
        }
        events.sort(Comparator.comparingInt(e -> e.x));

        UnionFind uf = new UnionFind(circles.size());
        TreeSet<Integer> activeCircles = new TreeSet<>(Comparator.comparingInt(i -> circles.get(i).y));

        for (Event event : events) {
            int i = event.index;
            if (event.isStart) {
                for (int j : activeCircles) {
                    if (circlesOverlap(circles.get(i), circles.get(j))) {
                        uf.union(i, j);
                    }
                }
                activeCircles.add(i);
            } else {
                activeCircles.remove(i);
            }
        }

        return uf.allConnected();
    }


}
