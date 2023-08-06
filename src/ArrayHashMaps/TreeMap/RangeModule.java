package ArrayHashMaps.TreeMap;

import java.util.Scanner;
import java.util.TreeMap;

public class RangeModule {

    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        Scanner sc = new Scanner(System.in);
        String l1 = sc.nextLine();
        String l2 = sc.nextLine();
        l1 = l1.substring(1, l1.length()-1);
        l2 = l2.substring(1, l2.length()-1);

        String[] functions = l1.split(",");
        String[] vals = l2.split("-");

        int[][] values = new int[vals.length][2];
        for(int i=1; i< vals.length; i++){
            String v = vals[i];
            v = v.substring(1, v.length()-1);
            String[] vs = v.split(",");
            values[i] = new int[]{Integer.parseInt(vs[0]), Integer.parseInt(vs[1])};
        }

        int count = 1;
        for(int i=1; i<functions.length; i++){
            String fun = functions[i];
            if(fun.contains("add")){
                System.out.println("add " + values[i][0] +" "+ values[i][1]);
                rm.addRange(values[i][0], values[i][1]);
            }
            else if(fun.contains("remove")){
                System.out.println("remove " + values[i][0] +" "+ values[i][1]);
                rm.removeRange(values[i][0], values[i][1]);
            }
            else{
                System.out.print("range  " + values[i][0] +" "+ values[i][1] +" : ");
                System.out.println(rm.queryRange(values[i][0], values[i][1]));
            }
        }

    }

    TreeMap<Integer, Integer> map;

    public RangeModule() {
        this.map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        int start = left, end = right;
        while(this.map.floorKey(start) != null){
            int key = this.map.floorKey(start);
            int prevStart = key;
            int prevEnd = this.map.get(key);
            if(prevEnd < start) break;
            this.map.remove(key);
            start = Math.min(start, prevStart);
            end = Math.max(end, prevEnd);
        }
        while(this.map.floorKey(end) != null){
            int key = this.map.floorKey(end);
            int prevStart = key;
            int prevEnd = this.map.get(key);
            if(prevEnd < start) break;
            this.map.remove(key);
            start = Math.min(start, prevStart);
            end = Math.max(end, prevEnd);
        }
        this.map.put(start, end);
        return;
    }

    public boolean queryRange(int left, int right) {
        if(this.map.floorKey(left) == null) return false;
        int prevEnd = this.map.get(this.map.floorKey(left));
        boolean ret = right <= prevEnd;
        return right <= prevEnd;
    }

    public void removeRange(int left, int right) {
        int start = left, end = right;
        while(this.map.floorKey(start) != null){
            int key = this.map.floorKey(start);
            int prevStart = key;
            int prevEnd = this.map.get(key);
            if(prevEnd <= start) break;
            if(prevEnd <= end){
                this.map.remove(key);
                this.map.put(prevStart, start);
            }
            else{
                int s1 = prevStart, e1 = start;
                int s2 = end, e2 = prevEnd;
                this.map.remove(key);
                this.map.put(s1, e1);
                this.map.put(s2, e2);
            }
        }
        while(this.map.floorKey(end-1) != null){
            int key = this.map.floorKey(end-1);
            int prevStart = key;
            int prevEnd = this.map.get(key);
            if(prevEnd <= start) break;
            if(prevStart == end) break;
            if(prevEnd <= end){
                this.map.remove(key);
            }
            else{
                this.map.remove(key);
                this.map.put(end, prevEnd);
            }
        }
        return;
    }
}
