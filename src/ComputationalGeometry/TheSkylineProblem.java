package ComputationalGeometry;


import java.util.*;

// https://leetcode.com/problems/the-skyline-problem/description/
public class TheSkylineProblem {
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyline0(buildings
        ));
    }

    public static List<List<Integer>> getSkyline0(int[][] buildings) {

        SortedSet<Integer> sortedEnds = new TreeSet<>();
        for(int[] bld : buildings){
            sortedEnds.add(bld[0]);
            sortedEnds.add(bld[1]);
        }

        List<Integer> ends = new ArrayList<>(sortedEnds);
        int[] edges = new int[ends.size()];
        Map<Integer, Integer> reverseMap = new HashMap<>();
        for(int i=0; i<ends.size(); i++){
            reverseMap.put(ends.get(i), i);
        }

        for(int[] bld : buildings){
            int s = bld[0], e = bld[1], h = bld[2];
            int si = reverseMap.get(s), ei = reverseMap.get(e);

            for(int i=si; i<ei; i++){
                edges[i] = Math.max(h, edges[i]);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0; i<edges.length; i++){
            int h = edges[i], x = ends.get(i);
            if(answer.isEmpty() || answer.get(answer.size()-1).get(1) != h){
                answer.add(Arrays.asList(x,h));
            }
        }
        return answer;
    }
}
