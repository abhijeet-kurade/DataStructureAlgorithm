package Graphs.TopologicalSort;


import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {
    // another solution
    // https://leetcode.com/submissions/detail/675777433/

    public int[] findOrder(int nodes, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashSet<Integer> zeroDegree = new HashSet<>();
        for(int node=0; node<nodes; node++){
            graph.put(node, new ArrayList<>());
            inDegree.put(node, 0);
            zeroDegree.add(node);
        }
        for(int[] edge : edges){
            graph.get(edge[1]).add(edge[0]);
            if(zeroDegree.contains(edge[0])) zeroDegree.remove(edge[0]);
            inDegree.put(edge[0], inDegree.get(edge[0])+1);
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for(Integer node : zeroDegree) queue.add(node);
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            stack.add(current);
            for(Integer neighbor : graph.get(current)){
                if(inDegree.get(neighbor)>0){
                    inDegree.put(neighbor, inDegree.get(neighbor)-1);
                    if(inDegree.get(neighbor)==0) queue.add(neighbor);
                }
            }
        }
        if(stack.size() != nodes) return new int[0];
        int[] topologicalOrder = new int[stack.size()];
        int idx = stack.size()-1;
        while(!stack.isEmpty()) topologicalOrder[idx--] = stack.pop();
        return topologicalOrder;
    }

}
