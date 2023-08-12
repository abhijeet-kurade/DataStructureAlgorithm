package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String, Integer> score = new HashMap<>();
        int maxScore = 0;
        String winner = "";
        int index=0;
        for(ArrayList<String> game : competitions){
            int win = results.get(index) == 0 ? 1 : 0;
            if(score.get(game.get(win)) != null){
                int scr = score.get(game.get(win))+1;

                System.out.println(game.get(win) +" "+ scr);
                score.put(game.get(win), scr);
                if(maxScore < scr){
                    maxScore = scr;
                    winner = game.get(win);
                }
            }
            else{
                score.put(game.get(win), 1);
                if(maxScore <= 1){
                    maxScore = 1;
                    winner = game.get(win);
                }
            }
            index++;
        }
        return winner;
    }
}
