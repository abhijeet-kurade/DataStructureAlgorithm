package Utils.DataStructure.Java;

import java.util.TreeMap;

public class Treemap {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap();
        map.put(30, "O");
        map.put(10, "G");
        map.put(20, "O");
        map.put(40, "G");
        map.put(50, "L");
        map.put(60, "E");
        for (Integer k : map.keySet()) System.out.print(map.get(k));

        System.out.println();

        // getting first key
        System.out.println(map.firstKey());
        // getting last key
        System.out.println(map.lastKey());
        // getting floor key
        System.out.println(map.floorKey(21));
        // getting ceiling key
        System.out.println(map.ceilingKey(601));

    }
}
