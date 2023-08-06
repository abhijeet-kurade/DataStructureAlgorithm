package FamousProblems.JumpGame;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n<=1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            if(!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int steps = 0;
        queue.add(0);
        visited.add(0);

        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i=0; i<l; i++){
                int node = queue.poll();
                if(node == n-1) return steps;
                for(int neighbor : map.get(arr[node])){
                    if(visited.contains(neighbor)) continue;
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
                map.get(arr[node]).clear();
                if(node + 1 < n && !visited.contains(node + 1)){
                    visited.add(node + 1);
                    queue.add(node + 1);
                }
                if(node - 1 >= 0 && !visited.contains(node - 1)){
                    visited.add(node - 1);
                    queue.add(node - 1);
                }
            }
            steps += 1;
        }
        return -1;
    }
}
