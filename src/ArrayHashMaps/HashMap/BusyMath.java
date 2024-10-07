package ArrayHashMaps.HashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusyMath {
    public  String busyMonth(List<String> dateList){
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        for(String date : dateList){
            String month = date.substring(5, 7);
            map.put(month, map.getOrDefault(month, 0)+1);
            ans = month;
        }

        for(String month : map.keySet()){
            if(map.get(ans) <= map.get(month) && Integer.parseInt(ans) > Integer.parseInt(month)){
                ans = month;
            }
        }

        return ans;
    }
}
