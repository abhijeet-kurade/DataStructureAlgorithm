package Graphs.GraphStandardProblems.Scaler;

import java.util.*;

public class ReverseEdge {
    public static void main(String[] args) {
        ReverseEdge re = new ReverseEdge();
        int[][] edges = {{1,2},{2, 3},{4,3},{4,5}};
        System.out.println(re.reverseEdges(5, edges));
    }
    class Edge{
        int d;
        int isRevered;
        public Edge(int d, int isRevered){
            this.d = d;
            this.isRevered = isRevered;
        }
    }
    class Node{
        int node, steps, revered;
        public Node(int node, int steps, int revered){
            this.node = node;
            this.steps = steps;
            this.revered = revered;
        }
    }
    public int reverseEdges(int dest, int[][] edges) {
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for(int[] edge : edges){
            int s = edge[0], d = edge[1];
            graph.put(s, new ArrayList<>());
            graph.put(d, new ArrayList<>());
        }
        for(int[] edge : edges){
            int s = edge[0], d = edge[1];
            graph.get(s).add(new Edge(d, 0));
        }
        for(int[] edge : edges){
            int s = edge[0], d = edge[1];
            graph.get(d).add(new Edge(s, 1));
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(
                (o1, o2)->{
                    if(o1.revered != o2.revered) return o1.revered - o2.revered;
                    return o1.steps - o2.steps;
                }
        );
        queue.add(new Node(1, 0, 0));

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(visited.contains(curr.node)) continue;
            if(curr.node == dest) return curr.revered;
            visited.add(curr.node);
            for(Edge neighbor : graph.get(
                    curr.node)){
                if(visited.contains(neighbor.d)) continue;
                queue.offer(new Node(neighbor.d, curr.steps+1, curr.revered + neighbor.isRevered));
            }
        }
        return -1;
    }

}
