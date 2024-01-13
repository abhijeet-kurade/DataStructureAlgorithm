package Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestColorValueInDirectedGraph {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
        String colors = "abaca";
        System.out.println(largestPathValue(colors, edges));
    }

    public static int[] dfs(int curr, Map<Integer, List<Integer>> graph, int[][] color, boolean[] path, String colors){
        //if(graph.get(curr) == null) return new int[26];
        if(path[curr]){
            return null;
        }
        if(color[curr] != null){
            return color[curr];
        }
        path[curr] = true;
        color[curr] = new int[26];

        for(int neighbor : graph.get(curr)){
            int[] s = dfs(neighbor, graph, color, path, colors);
            if(s == null) return null;
            for(int i=0; i<26; i++){
                color[curr][i] = Math.max(color[curr][i], s[i]);
            }
        }
        color[curr][colors.charAt(curr) - 'a'] += 1;
        path[curr] = false;
        return color[curr];
    }
    public static int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();
        int[][] color = new int[n][];
        boolean[] path = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edg : edges){
            if(!graph.containsKey(edg[0])) graph.put(edg[0], new ArrayList<>());
            if(!graph.containsKey(edg[1])) graph.put(edg[1], new ArrayList<>());
            graph.get(edg[0]).add(edg[1]);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int[] s = dfs(i, graph, color, path, colors);
            if(s == null) return -1;
            for(int j=0; j<26; j++){
                ans = Math.max(ans, s[j]);
            }
        }
        return ans;
    }
}
