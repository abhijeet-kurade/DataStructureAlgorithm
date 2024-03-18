package FamousProblems.Intervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{3,6},{9,15},{0,2},{2,3},{12, 20},{25,27}};
        mergeIntervals(intervals);
    }

    public static int[][]  mergeIntervals1(int[][] intervals){
        List<int[]> merged  = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2)-> { return o1[0] -  o2[0]; });
        int s = intervals[0][0], e = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            int ns = intervals[i][0], ne = intervals[i][1];
            if(ns<=e){
                s = Math.min(s,ns);
                e = Math.max(e,ne);
            }
            else{
                merged.add(new int[]{s, e});
                s = ns;
                e = ne;
            }
        }
        merged.add(new int[]{s, e});
        return merged.toArray(new int[0][]);
    }
    public static int[][]  mergeIntervals2(int[][] intervals){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals){
            int start = interval[0], end = interval[1];
            while(map.floorKey(start) != null){
                int ls = map.floorKey(start);
                int le = map.get(ls);
                if(le < start) break;
                map.remove(ls);
                start = Math.min(start, ls);
                end = Math.max(end, le);
            }
            while(map.floorKey(end) != null){
                int ls = map.floorKey(end);
                int le = map.get(ls);
                if(le < start) break;
                map.remove(ls);
                start = Math.min(start, ls);
                end = Math.max(end, le);
            }
            map.put(start, end);
        }
        int[][] merged = new int[map.size()][];
        int idx =0;
        for(int s : map.keySet()){
            merged[idx] = new int[]{s, map.get(s)};
            idx+=1;
        }
        return merged;
    }

    public static int[][]  mergeIntervals(int[][] intervals){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval : intervals){
            int s = interval[0], e = interval[1]+1;
            map.put(s, map.getOrDefault(s,0)+1);
            map.put(e, map.getOrDefault(e,0)-1);
        }
        for(int k : map.keySet()){
            if(map.floorKey(k-1) != null){
                map.put(k, map.get(k) + map.get(map.floorKey(k-1)));
            }
        }
        List<int[]> ints = new ArrayList<>();
        for(int k : map.keySet()){
            ints.add(new int[]{k, map.get(k)});
        }
        List<int[]> merged= new ArrayList<>();
        int s = ints.get(0)[0];
        for(int i=1; i<ints.size(); i++){
            if(ints.get(i)[1] == 0){
                merged.add(new int[]{s, ints.get(i)[0]-1});
                i += 1;
                if(i==ints.size()){
                    break;
                }
                s = ints.get(i)[0];
            }
        }
        return merged.toArray(new int[0][]);
    }
}
