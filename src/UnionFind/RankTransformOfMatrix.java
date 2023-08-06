package UnionFind;

import Utils.Output;

import java.util.*;

public class RankTransformOfMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {4,4,14},
                {-19,4,19},
                {22,-47,24},
                {-19,4,19}
        };
        LeetcodeRankTransformOfMatrix lc = new LeetcodeRankTransformOfMatrix();
        Output.print2DArr(lc.matrixRankTransform(matrix));
    }
}

class LeetcodeRankTransformOfMatrix {
    // implement find and union
    public int find(Map<Integer, Integer> UF, int x) {
        if (x != UF.get(x)) {
            UF.put(x, find(UF, UF.get(x)));
        }
        return UF.get(x);
    }

    public void union(Map<Integer, Integer> UF, int x, int y) {
        if (!UF.containsKey(x)) {
            UF.put(x, x);
        }
        if (!UF.containsKey(y)) {
            UF.put(y, y);
        }
        UF.put(find(UF, x), find(UF, y));
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // link row and col together
        Map<Integer, Map<Integer, Integer>> UFs = new HashMap<>();
        // UFs.get(v): the Union-Find of value v
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                if (!UFs.containsKey(v)) {
                    UFs.put(v, new HashMap<Integer, Integer>());
                }
                // union i to j
                union(UFs.get(v), i, ~j);
            }
        }

        // put points into `value2index` dict, grouped by connection
        // use TreeMap to help us sort the key automatically
        SortedMap<Integer, Map<Integer, List<int[]>>> value2index = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                if (!value2index.containsKey(v)) {
                    value2index.put(v, new HashMap<>());
                }
                Map<Integer, List<int[]>> indexes = value2index.get(v);
                int f = find(UFs.get(v), i);
                if (!indexes.containsKey(f)) {
                    indexes.put(f, new ArrayList<>());
                }
                indexes.get(f).add(new int[] { i, j });
            }
        }

        int[][] answer = new int[m][n]; // the required rank matrix
        int[] rowMax = new int[m]; // rowMax[i]: the max rank in i row
        int[] colMax = new int[n]; // colMax[j]: the max rank in j col
        for (int v : value2index.keySet()) {
            // update by connected points with same value
            for (List<int[]> points : value2index.get(v).values()) {
                int rank = 1;
                for (int[] point : points) {
                    rank = Math.max(rank, Math.max(rowMax[point[0]], colMax[point[1]]) + 1);
                }
                for (int[] point : points) {
                    answer[point[0]][point[1]] = rank;
                    // update rowMax and colMax
                    rowMax[point[0]] = Math.max(rowMax[point[0]], rank);
                    colMax[point[1]] = Math.max(colMax[point[1]], rank);
                }
            }
        }
        return answer;
    }
}

class IndexCompression{
    public static void main(String[] args) {
        int[] arr = {3, 7, -2, 4, 9 ,3};
        //Output.printArr(indexCompression(arr));
    }

    public static int[] indexCompression(int[] arr){
        int n = arr.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->{
            return o1[0] - o2[0];
        });
        for(int i=0; i<n; i++){
            queue.add(new int[]{arr[i], i});
        }
        int[] compressed = new int[n];
        int rank = 0, last = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(last != curr[0]){
                last = curr[0];
                rank += 1;
            }
            compressed[curr[1]] = rank;
        }
        return compressed;
    }
}

class IndexCompression2{
    public int find(HashMap<Integer, Integer> UF, int x){
        if(x != UF.get(x)){
            UF.put(x, find(UF, UF.get(x)));
        }
        return UF.get(x);
    }

    public void union(HashMap<Integer, Integer> UF, int x, int y){
        if(!UF.containsKey(x)) UF.put(x, x);
        if(!UF.containsKey(y)) UF.put(y, y);
        UF.put(find(UF, x), find(UF, y));
    }


    public int[][] rankCompression(int[][] arr){
        int rows = arr.length, cols = arr[0].length;
        HashMap<Integer, HashMap<Integer, Integer>> UFs = new HashMap<>();

        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                int num = arr[row][col];
                if(!UFs.containsKey(num)) UFs.put(num, new HashMap<>());
                union(UFs.get(num), row, ~col);
            }
        }

        TreeMap<Integer, Map<Integer, List<int[]>>> groups = new TreeMap<>();

        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                int num = arr[row][col];
                if(!groups.containsKey(num)) groups.put(num, new HashMap<>());
                Map<Integer, List<int[]>> indxs = groups.get(num);
                int p = find(UFs.get(num), row);
                if(!indxs.containsKey(p)) indxs.put(p, new ArrayList<>());
                indxs.get(p).add(new int[]{row, col});
            }
        }

        int[][] answer = new int[rows][cols];
        int[] rowMax = new int[rows];
        int[] colMax = new int[cols];

        for(int num : groups.keySet()){
            for(int gid : groups.get(num).keySet()){
                int rank = 1;
                for(int[] point : groups.get(num).get(gid)){
                    int x = point[0], y = point[1];
                    rank = Math.max(rank, Math.max(rowMax[x], colMax[y]) + 1);
                }
                for(int[] point : groups.get(num).get(gid)){
                    int x = point[0], y = point[1];
                    answer[x][y] = rank;
                    rowMax[x] = Math.max(rowMax[x], rank);
                    colMax[y] = Math.max(colMax[y], rank);
                }
            }
        }
        return answer;
    }
}

