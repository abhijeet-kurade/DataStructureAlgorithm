package Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static String searchingChallenge(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        String token = "opngt3ade5";
        Set<Character> set = new HashSet<>();
        for(char c : token.toCharArray()) set.add(c);
        int maxRep = 1;
        int start = -1, end =-1;
        int n = str.length();
        int idx = 0;
        while(idx < n){
            map.clear();
            boolean isMax = false;
            int s = idx;
            while(idx < n && str.charAt(idx) != ' '){
                char c = str.charAt(idx);
                map.put(c, map.getOrDefault(c, 0)+1);
                if(maxRep < map.get(c)){
                    maxRep = map.get(c);
                    isMax = true;
                }
                idx += 1;
            }
            if(isMax){
                start = s;
                end = idx;
            }
            idx += 1;
        }
        if(start == -1) return "-1";

        StringBuilder ans = new StringBuilder();
        for(int i=start; i<end; i++){
            if(!set.contains(str.charAt(i)))ans.append(str.charAt(i));
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(searchingChallenge(s.nextLine()));
    }
}
