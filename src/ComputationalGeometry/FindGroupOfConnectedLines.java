package ComputationalGeometry;

import java.util.*;

public class FindGroupOfConnectedLines {
    public static void main(String[] args) {

    }

    static class Line {
        int x1, y1, x2, y2;
        int index; // Unique identifier for the line

        public Line(int x1, int y1, int x2, int y2, int index) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.index = index;
        }

        @Override
        public String toString() {
            return "{"+index+": ["+x1+", "+y1+"]["+x2+", "+y2+"]";
        }
    }

    static class Event implements Comparable<Event> {
        int x;
        boolean isStart;
        Line line;

        public Event(int x, boolean isStart, Line line) {
            this.x = x;
            this.isStart = isStart;
            this.line = line;
        }

        @Override
        public int compareTo(Event other) {
            return this.x - other.x;
        }
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
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
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static List<Set<Line>> findConnectedLines(List<Line> lines) {
        List<Event> events = new ArrayList<>();
        for (Line line : lines) {
            events.add(new Event(Math.min(line.x1, line.x2), true, line));
            events.add(new Event(Math.max(line.x1, line.x2), false, line));
        }
        Collections.sort(events);
        UnionFind uf = new UnionFind(lines.size());
        TreeMap<Integer, Line> activeLines =
                new TreeMap<>(Comparator.comparingInt(i -> lines.get(i).y1));

        for (Event event : events) {
            Line currentLine = event.line;
            if (event.isStart){
                Integer lowerKey = activeLines.lowerKey(currentLine.y1);
                Integer higherKey = activeLines.higherKey(currentLine.y1);
                if (lowerKey != null && linesIntersect(currentLine, activeLines.get(lowerKey))) {
                    uf.union(currentLine.index, activeLines.get(lowerKey).index);
                }
                if (higherKey != null && linesIntersect(currentLine, activeLines.get(higherKey))) {
                    uf.union(currentLine.index, activeLines.get(higherKey).index);
                }
                activeLines.put(currentLine.y1, currentLine);
            }
            else {
                activeLines.remove(currentLine.y1);
            }
        }
        Map<Integer, Set<Line>> groups = new HashMap<>();

        for (Line line : lines) {
            int root = uf.find(line.index);
            groups.computeIfAbsent(root, k -> new HashSet<>()).add(line);
        }

        return new ArrayList<>(groups.values());
    }

    private static boolean linesIntersect(Line l1, Line l2) {
        // Implement line intersection logic here
        // This can be done using orientation tests or line equation methods
        return false; // Placeholder for actual intersection test
    }


}
