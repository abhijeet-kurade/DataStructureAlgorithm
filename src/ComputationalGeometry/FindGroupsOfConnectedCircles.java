package ComputationalGeometry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/*
The sweep line algorithm for detecting overlapping circles is generally more efficient than the simple approach of
comparing every pair of circles because it reduces the number of comparisons that need to be made.
In the simple approach, every circle is compared with every other circle, resulting in ( O(n^2) ) comparisons,
where ( n ) is the number of circles.

The sweep line algorithm improves on this by sorting the events (the start and end points of the circles along the x-axis)
and then only considering circles that are active (those that have started but not yet ended as the sweep line moves).
 While it still requires checking each new circle against all active circles, which can also lead to ( O(n^2) )
 comparisons in the worst case, it often performs better in practice for several reasons:

1. Early Termination: Circles that do not overlap along the x-axis can be quickly discarded without needing to
                      check their y-coordinates or radii.
2. Event Sorting: By processing circles in the order of their x-coordinates, the algorithm can efficiently manage the
                      active set of circles, adding and removing circles as needed.
3. Active Set Management: The active set typically contains fewer circles than the total set, especially if the circles
                       are spread out along the x-axis, which reduces the number of comparisons.

However, the efficiency gain depends on the distribution of the circles. If the circles are densely packed and many are
overlapping, the sweep line algorithm may not offer a significant improvement over the simple pairwise comparison
approach. For scenarios with a large number of circles or where circles are more sparsely distributed, the sweep line
algorithm can provide a more scalable solution. Additionally, further optimizations, such as spatial partitioning
techniques, can be applied to the sweep line algorithm to improve its performance in detecting overlapping circles.
 */
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
