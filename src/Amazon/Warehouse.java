package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Warehouse {

    public int minDistance(int[] truck, int[] warehouse, int[][] lockers){
        int all_distance = 0;
        for(int[] locker : lockers){
            all_distance += 2 * getDistance(warehouse, locker);
        }
        int distance = Integer.MAX_VALUE;
        for(int[] locker : lockers){
            int oneTrip = getDistance(truck, locker) + getDistance(warehouse, locker);
            int roundTrip = 2 * getDistance(warehouse, locker);
            distance = Math.min(distance, all_distance + oneTrip - roundTrip );
        }
        return distance;
    }

    private int getDistance(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public String fizzBuz(int num){
        
        return "";
    }

    public static void main(String[] args) {
        System.out.println(towerLadder(new int[]{5,7,9,4,11}));
        /*System.out.println(compressNumber("112"));
        String[] ans = concateString(new String[]{"cat", "dog", "ferret", "scorpion"});
        for (String s : ans) System.out.println(s);*/
    }

    public static String[] concateString(String[] list){
        int n = list.length;
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            int j = (i+1) % n;
            answer[i] = String.valueOf(list[i].charAt(0)) + list[j].charAt(list[j].length()-1);
        }
        return answer;
    }

    public static String compressNumber(String number){
        StringBuilder sb = new StringBuilder();
        char last = 'a';
        int count = 0;
        boolean repeat = false;
        for(char c : number.toCharArray()){
            if(last == c){
                count += 1;
            }
            else{
                if(last != 'a'){
                    String num = String.valueOf(count* (last-'0'));
                    repeat = repeat || (!sb.isEmpty() && sb.charAt(sb.length()-1) == num.charAt(0));
                    sb.append(num);
                }
                count = 1;
                last = c;
            }
        }
        String num = String.valueOf(count* (last-'0'));
        repeat = repeat || (!sb.isEmpty() && sb.charAt(sb.length()-1) == num.charAt(0));
        sb.append(num);
        if(repeat){
            return compressNumber(sb.toString());
        }
        return sb.toString();
    }


    public static int towerLadder(int[] towers){
        int n = towers.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int increasing = 0;
            int descreasing = 0;
            int next = i-1;
            while(next > 0){
                
                increasing += towers[i] - (i-next) >= 0 ? Math.abs(towers[i] - (i-next)) : Integer.MAX_VALUE;
                descreasing += Math.abs(towers[i] + (i-next));
                next -= 1;
            }
            next = i+1;

            while (next<n){
                increasing = Math.abs(towers[i] + next-i);
                descreasing = Math.abs(towers[i] - (next-i));
                next += 1;
            }
            ans = Math.min(ans, increasing);
            ans = Math.min(ans, descreasing);

        }
        return ans;
    }

    public static int sumOfConsecutiveNumbers(int a, int b) {
        int n = b - a + 1;
        return n * (a + b) / 2;
    }

}
