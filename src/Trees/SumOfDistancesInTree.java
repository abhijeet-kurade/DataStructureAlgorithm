package Trees;

import java.util.*;


// https://leetcode.com/problems/sum-of-distances-in-tree/description/
public class SumOfDistancesInTree {

    public static void main(String[] args) {
        SumOfDistancesInTree solution = new SumOfDistancesInTree();

        int n = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        };

        int[] result = solution.sumOfDistancesInTree(n, edges);
        System.out.println("Sum of distances: " + Arrays.toString(result));
    }

    public int dfs(List<List<Integer>> adj, int node, int parent, int[] children) {
        int child = 1;
        int sum = 0;
        for (int nbr : adj.get(node)) {
            if (nbr == parent) continue;
            sum += dfs(adj, nbr, node, children);
            child += children[nbr];
        }
        sum += child;
        children[node] = child;
        return sum;
    }

    public void calculateSumOfDistances(List<List<Integer>> adj, int node, int parent, int parentSum, int[] children, int[] sumOfDistances) {
        int totalNodes = children.length;

        int mySum = node != 0 ? parentSum - children[node] + (totalNodes - children[node]) : parentSum;

        sumOfDistances[node] = mySum;

        for (int nbr : adj.get(node)) {
            if (nbr == parent) continue;
            calculateSumOfDistances(adj, nbr, node, mySum, children, sumOfDistances);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] children = new int[n];
        int[] sumOfDistances = new int[n];

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int sum = dfs(adj, 0, -1, children) - n;
        calculateSumOfDistances(adj, 0, -1, sum, children, sumOfDistances);

        return sumOfDistances;
    }
}

