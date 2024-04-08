package UnionFind;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostWalkWeightedGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,4,7},{3,5,1},{1,3,5},{1,5,1}};

        int[][] query = {{0,4},{1,5},{3,0},{3,3},{3,2},{2,0},{7,7},{7,0}};
        Utils.Output.printArr(minimumCost(9, edges, query));
    }

    static class UnionFind{
        Map<Integer, Integer> uf;

        public UnionFind(int n) {
            uf = new HashMap<>();
            for(int i=0; i<n; i++){
                uf.put(i, i);
            }
        }

        public int find(int x) {
            if (x != uf.get(x)) {
                uf.put(x, find(uf.get(x)));
            }
            return uf.get(x);
        }

        public void union(int x, int y) {
            if (!uf.containsKey(x)) {
                uf.put(x, x);
            }
            if (!uf.containsKey(y)) {
                uf.put(y, y);
            }
            uf.put(find(x), find(y));
        }
    }

    public static int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> component = new HashMap<>();

        for(int[] edge : edges){
            int leader = uf.find(edge[0]);
            component.put(leader, component.getOrDefault(leader, Integer.MAX_VALUE) & edge[2] );
        }

        int[] ans = new int[query.length];
        int idx = 0;
        for(int[] q : query){
            if(uf.find(q[0]) != uf.find(q[1])) ans[idx] = -1;
            else ans[idx] = component.get(uf.find(q[0]));
            idx += 1;
        }

        return ans;
    }
}
