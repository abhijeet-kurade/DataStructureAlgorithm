package FamousProblems.GaleShapleyAlgorithm;

import java.util.*;

public class StableMatching {

    public static List<int[]> stableMatching(int[][] internPref, int[][] teamPref){
        int N = internPref.length;

        Map<Integer, Integer>[] teams = new HashMap[N];

        for(int i=0; i<N; i++){
            teams[i] = new HashMap<>();

            for(int r=0; r<N; r++){
                teams[i].put(teamPref[i][r], r);
            }
        }

        Queue<Integer> freeInterns = new LinkedList<>();
        for(int i=0; i<N; i++){
            freeInterns.add(i);
        }

        int[] pref = new int[N];
        int[] matches = new int[N]; // index= team, value intern

        Arrays.fill(matches, -1);

        while(!freeInterns.isEmpty()){
            int intern = freeInterns.poll();
            int currPref = pref[intern];
            int team = internPref[intern][currPref];

            if(matches[team] == -1){
                matches[team] = intern;
            }
            else{
                int oldIntern = matches[team];
                if(teams[team].get(intern) < teams[team].get(oldIntern)){
                    // switch
                    freeInterns.add(oldIntern);
                    matches[team] = intern;
                }
                else{
                    // try agian
                    freeInterns.add(intern);
                }
            }
        }

        List<int[]> answer = new ArrayList<>();

        for(int i=0; i<N; i++){
            answer.add(new int[]{i, matches[i]});
        }

        return answer;
    }
}
