package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MinimumEdgeWeightEquilibriumQueriesInTree {

    public static void main(String[] args) {
        // n = 7, edges = [[0,1,1],[1,2,1],[2,3,1],[3,4,2],[4,5,2],[5,6,2]], queries = [[0,3],[3,6],[2,6],[0,6]]
        int[][] edges = {{0,1,1},{1,2,1},{2,3,1},{3,4,2},{4,5,2},{5,6,2}};
        int[][] queries = {{0,3},{3,6},{2,6},{0,6}};
        int[][] edges1 = {};
        int[][] queries1 = {{0,0}};



        MinimumEdgeWeightEquilibriumQueriesInTree mn = new MinimumEdgeWeightEquilibriumQueriesInTree();
        int[] ans = mn.minOperationsQueries(1, edges1, queries1);
        for (int num : ans) System.out.println(num);

    }
    public  int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        HashMap<Integer, List<int[]>> tree = new HashMap<>();
        for(int[] edge : edges){
            int s = edge[0], d = edge[1], w = edge[2];
            if(!tree.containsKey(s)) tree.put(s, new ArrayList<>());
            if(!tree.containsKey(d)) tree.put(d, new ArrayList<>());
            tree.get(s).add(new int[]{d, w});
            tree.get(d).add(new int[]{s, w});
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        HashMap<Integer, Integer> weightCount = new HashMap<>();
        for(int[] query : queries){
            int s = query[0], d = query[1];
            if(s == d || (!tree.containsKey(s)) || (!tree.containsKey(d))){
                idx +=1 ;
                continue;
            }
            weightCount.clear();
            boolean res = dfs(tree, -1, s, d, weightCount);
            if(res){
                int max = 0, total =0;
                for(Integer key : weightCount.keySet()){
                    int count = weightCount.get(key);
                    total += count;
                    max = Math.max(max, count);
                }
                ans[idx] = total-max;
                System.out.println(ans[idx-1]);
            }

            idx += 1;
        }

        return ans;

    }

    public boolean dfs(HashMap<Integer, List<int[]>> tree, int parent, int curr, int dest, HashMap<Integer, Integer> weightCount){


        List<int[]> neighbours = tree.get(curr);

        for(int[] neighbour : neighbours){
            int w = neighbour[1], d = neighbour[0];
            if(d == parent) continue;
            weightCount.put(w, weightCount.getOrDefault(w, 0)+1);
            if(d == dest) return true;
            boolean res = dfs(tree, curr, d, dest, weightCount);
            if(res) return true;
            weightCount.put(w, weightCount.getOrDefault(w, 0)-1);
        }
        return false;
    }

}

