package InterviewExperiences;

import java.util.Map;

public class Sse1 {
    public static void main(String[] args) {

    }

    static class MeetingScheduler{

        private Map<Integer, Integer> calendar;
        private final int interviews_per_window;
        private final int window;

        public MeetingScheduler(int interviews_per_window, int window) {
            this.interviews_per_window = interviews_per_window;
            this.window = window;
        }

        public boolean check(int day){
            int start = day - window + 1;
            int end = day;
            int interviews = 0;
            for(int i=start; i<=end; i++){
                interviews += this.calendar.getOrDefault(i, 0);
            }
            if(interviews >= this.interviews_per_window){
                return false;
            }
            while(start <= day){
                interviews += this.calendar.getOrDefault(end+1, 0);
                interviews -= this.calendar.getOrDefault(start, 0);
                if(interviews >= this.interviews_per_window){
                    return false;
                }
                start += 1;
                end += 1;
            }
            return true;
        }

        public boolean schedule(int day){
            if(!this.check(day)){
                return false;
            }
            this.calendar.put(day, this.calendar.getOrDefault(day, 0) +1);
            return true;
        }
    }
}
