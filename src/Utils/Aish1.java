package Utils;

import java.util.*;
import java.util.LinkedList;

public class Aish1 {
    public static void main(String[] args) {
        System.out.println(perfectTeams("pcccmbzz"));
    }

    public static int[] prefix_queries(int N, int[] A, int Q, int[] queries){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=N-1; i>=0; i--){
            queue.offer(A[i]);
        }
        int pref = 0;
        for(int i=0; i<N; i++){
            if(A[i] == 0) break;
            pref += 1;
        }
        List<Integer> output = new ArrayList<>();
        for(int i=0; i<Q; i++){
            if(queries[i] == 1){
                int last = queue.poll();
                queue.offer(last);
                if(last == 1) pref += 1;
                else pref = 0;
            }
            else{
                output.add(pref);
            }
        }
        int[] ans = new int[output.size()];
        int idx = 0;
        for(int num : output){
            ans[idx++] = num;
        }
        return ans;
    }

    public static int minResult(int N, int[] S){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : S){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int key : map.keySet()){
            if(map.get(key) % 2 == 1) return -1;
        }
        int mismatches = 0;
        for(int itr = 0; itr <3; itr += 1 ){
            int left = itr * N, right = (itr+1)*N-1;
            while(left < right){
                if(S[left] != S[right]) mismatches += 1;
                left += 1;
                right -= 1;
            }
        }
        return mismatches/2;
    }

    public static int perfectTeams(String skills){
        if(skills.length() == 0) return 0;
        Map<Character, Integer> map = Map.of('p',0,'c',0,'m',0, 'b',0,'z',0);
        for(char c : skills.toCharArray()){
            map.put(c, map.get(c)+1);
        }
        int teams = Integer.MAX_VALUE;
        for(char c : map.keySet()){
            teams = Math.min(teams, map.get(c));
        }
        return teams;
    }
}
