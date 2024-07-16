package ArrayHashMaps.HashMap.Interview.Atlassian;

import java.util.*;

public class SpecialRooms {
    public static void main(String[] argv) {
        String[][] instructions_1 = {
                {"jasmin", "tulip"},
                {"lily", "tulip"},
                {"tulip", "tulip"},
                {"rose", "rose"},
                {"violet", "rose"},
                {"sunflower", "violet"},
                {"daisy", "violet"},
                {"iris", "violet"}
        };

        String[][] instructions_2 = {
                {"jasmin", "tulip"},
                {"lily", "tulip"},
                {"tulip", "violet"},
                {"violet", "violet"}
        };

        String[] treasure_rooms_1 = {"lily", "tulip", "violet", "rose"};
        String[] treasure_rooms_2 = {"lily", "jasmin", "violet"};
        String[] treasure_rooms_3 = {"violet"};

        System.out.println(filter_rooms(instructions_1, treasure_rooms_1));
        System.out.println(filter_rooms(instructions_1, treasure_rooms_2));
        System.out.println(filter_rooms(instructions_2, treasure_rooms_3));
    }


    public static List<String> filter_rooms(String[][] instructions, String[] treasure_rooms){

        Set<String> treasures = new HashSet<>(Arrays.asList(treasure_rooms));

        Map<String, Integer> incoming = new HashMap<>();
        Set<String> nextToTreasure = new HashSet<>();

        for(String[] instruction : instructions){
            String source = instruction[0];
            String dest = instruction[1];

            if(treasures.contains(dest)){
                nextToTreasure.add(source);
            }

            if(!source.equals(dest)){
                incoming.put(dest, incoming.getOrDefault(dest, 0)+1);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String room : incoming.keySet()){
            if(incoming.get(room) >= 2){
                if(nextToTreasure.contains(room)){
                    ans.add(room);
                }
            }
        }
        return ans;
    }
}
