package Stacks.AlgoExpert;

import java.util.ArrayList;
import java.util.Collections;

public class SunsetViews {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        int len = buildings.length;
        if(direction.equals("EAST")) {
            for(int i=0; i<(len / 2); i++) {
                int temp = buildings[i];
                buildings[i] = buildings[len-1-i];
                buildings[len-1-i] = temp;
            }
        }
        ArrayList<Integer> views = new ArrayList<>();
        int min_bld = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){
            if(min_bld < buildings[i]){
                views.add(i);
                min_bld = buildings[i];
            }
        }
        if(direction.equals("EAST")) {
            int len1 = views.size();
            Collections.reverse(views);
            for(int i=0; i<len1; i++){
                views.set(i, len-1-i);
            }
        }
        return views;
    }
}
