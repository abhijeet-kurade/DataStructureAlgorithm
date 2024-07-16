package ArrayHashMaps.HashMap.Interview.Atlassian;

import java.time.LocalDateTime;
import java.util.*;

public class EntryExist {
    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        String[][] logs = {
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj", "enter"},
        };

        String[][] logs1 = {
                {"Paul", "enter"},
                {"Pauline", "exit"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Martha", "exit"},
                {"Joe", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Joe", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Joe", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Joe", "enter"},
                {"Joe", "enter"},
                {"Martha", "exit"},
                {"Joe", "exit"},
                {"Joe", "exit"}
        };
        //System.out.println(function(logs1));

        LocalDateTime tm = LocalDateTime.now();

        System.out.println(tm);
        LocalDateTime end = LocalDateTime.of(tm.getYear(), tm.getMonth(), tm.getDayOfMonth(), tm.getHour(), tm.getMinute()+1);
        System.out.println(end);
        System.out.println(tm.compareTo(end));
    }

    public static List<Set<String>> function(String[][] logs){

        Set<String> building = new HashSet<>();
        Set<String> noExit = new HashSet<>();
        Set<String> noEntry = new HashSet<>();

        for(String[] entry : logs){
            String name = entry[0], status = entry[1];
            if(status.equals("enter")){
                if(building.contains(name)){
                    noExit.add(name);
                }
                building.add(name);
            }
            else{
                if(!building.contains(name)){
                    noEntry.add(name);
                }
                else {
                    building.remove(name);
                }

            }
        }
        noExit.addAll(building);
        return Arrays.asList(noExit, noEntry);
    }
}
