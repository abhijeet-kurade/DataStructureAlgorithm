package ArrayHashMaps.HashMap.Interview.Atlassian;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    Map<Integer, Integer> lookup;
    LocalDateTime end;
    int threshold;

    public RateLimiter(int threshold) {
        this.threshold = threshold;
        this.lookup = new HashMap<>();
        reset();
    }

    private void reset(){
        this.lookup.clear();
        LocalDateTime now = LocalDateTime.now();
        this.end = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute()+1);
    }

    public boolean shallPass(int id){
        LocalDateTime now = LocalDateTime.now();
        if(now.compareTo(this.end) == 1){
            reset();
        }
        int count = this.lookup.getOrDefault(id, 0);
        if(count >= this.threshold){
            return false;
        }
        this.lookup.put(id, count+1);
        return true;
    }
}
