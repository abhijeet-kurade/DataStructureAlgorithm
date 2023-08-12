package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching {

    public static void main(String[] args) {

        System.out.println("Matching Calendars for meetings!");
        List<StringMeeting> calendar1 = new ArrayList<StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("9:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("12:00", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 = new CalendarMatching.StringMeeting("6:00", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 = new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("7:00", "8:30"));
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:30"));
        calendar2.add(new CalendarMatching.StringMeeting("12:30", "14:30"));
        calendar2.add(new CalendarMatching.StringMeeting("14:30", "15:00"));
        calendar2.add(new CalendarMatching.StringMeeting("16:00", "17:00"));

        CalendarMatching.StringMeeting dailyBounds2 = new CalendarMatching.StringMeeting("6:00", "18:30");

        int meetingDuration = 30;

        List<CalendarMatching.StringMeeting> expected = new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("11:30", "12:00"));
        expected.add(new CalendarMatching.StringMeeting("15:00", "16:00"));
        expected.add(new CalendarMatching.StringMeeting("18:00", "18:30"));

        List<CalendarMatching.StringMeeting> actual =
                CalendarMatching.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        System.out.println(actual);

    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" +
                    "'" + start + '\'' +
                    " '" + end + '\'' + ']';
        }
    }

    static class IntMeeting {
        public int start;
        public int end;

        public IntMeeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" +
                    "'" + start + '\'' +
                    " '" + end + '\'' + ']';
        }
    }

    public static List<IntMeeting> mergeCalendars(List<IntMeeting> calendar1, List<IntMeeting> calendar2){

        int len1 = calendar1.size();
        int len2 = calendar2.size();

        int index1 = 0;
        int index2 = 0;

        List<IntMeeting> merged = new ArrayList<>();

        while(index1<len1 || index2<len2){
            if(calendar1.get(index1).start <= calendar2.get(index2).start){
                merged.add(calendar1.get(index1));
                index1 += 1;
                if(index1 == len1){
                    for(; index2<len2; index2++)
                        merged.add(calendar2.get(index2));
                    break;
                }
            }
            else{
                merged.add(calendar2.get(index2));
                index2 += 1;
                if(index2 == len2){
                    for(; index1<len1; index1++)
                        merged.add(calendar1.get(index1));
                    break;
                }
            }
        }

        return merged;
    }

    public static int timeToMinutes(String time){
        int i = time.indexOf(':');
        int hours = Integer.parseInt(time.substring(0,i));
        int minutes = Integer.parseInt(time.substring(i+1));
        return hours * 60 + minutes;
    }

    public static String minutesToTime(int minutes){
        int hours = minutes / 60;
        String hour = hours >= 10 ? hours+"" :"0"+hours;
        int minute = minutes % 60;
        String mnts = minute >= 10 ? minute+"" :"0"+minute;
        return hour + ":" + mnts;
    }

    public static List<IntMeeting> mergeMeetings(List<IntMeeting> calendar){
        int len = calendar.size();
        int start = calendar.get(0).start;
        int end = calendar.get(0).end;
        List<IntMeeting> merged = new ArrayList<>();
        for(int i=1; i<len; i++){
            if(end >= calendar.get(i).start){
                end = Math.max(end, calendar.get(i).end);
            }
            else {
                merged.add(new IntMeeting(start, end));
                start = calendar.get(i).start;
                end = Math.max(end, calendar.get(i).end);
            }
        }
        merged.add(new IntMeeting(start, end));
        return merged;
    }

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {




        int cal1_len = calendar1.size();
        List<IntMeeting> cal1 = new ArrayList<>();
        IntMeeting daily_bounds1 = new IntMeeting(timeToMinutes(dailyBounds1.start), timeToMinutes(dailyBounds1.end));
        int cal2_len = calendar2.size();
        List<IntMeeting> cal2 = new ArrayList<>();
        IntMeeting daily_bounds2 = new IntMeeting(timeToMinutes(dailyBounds2.start), timeToMinutes(dailyBounds2.end));



        cal1.add(new IntMeeting(0, daily_bounds1.start));
        for(StringMeeting meeting : calendar1){
            cal1.add(new IntMeeting(timeToMinutes(meeting.start), timeToMinutes(meeting.end)));
        }
        cal1.add(new IntMeeting(daily_bounds1.end,timeToMinutes("23:59")));



        cal2.add(new IntMeeting(0, daily_bounds2.start));
        for(StringMeeting meeting : calendar2){
            cal2.add(new IntMeeting(timeToMinutes(meeting.start), timeToMinutes(meeting.end)));
        }
        cal2.add(new IntMeeting(daily_bounds2.end,timeToMinutes("23:59")));



        List<IntMeeting> mergeCal = mergeCalendars(cal1, cal2);
        List<IntMeeting> mergedMeetings = mergeMeetings(mergeCal);




        List<IntMeeting> availableSlots = new ArrayList<>();
        for(int i=1; i<mergedMeetings.size(); i++){
            availableSlots.add(new IntMeeting(mergedMeetings.get(i-1).end, mergedMeetings.get(i).start));
        }



        List<IntMeeting> matchedSlots = new ArrayList<>();
        for(int i=0; i<availableSlots.size(); i++){
            if(availableSlots.get(i).end - availableSlots.get(i).start >= meetingDuration)
                matchedSlots.add(availableSlots.get(i));
        }

        /*System.out.println("calendar1 - " + calendar1);
        System.out.println("cal1 - " + cal1);
        System.out.println("dailyBounds1 - " + dailyBounds1);
        System.out.println("daily_bounds1 - "+daily_bounds1);
        System.out.println("calendar2 - " + calendar2);
        System.out.println("cal2 - " + cal2);
        System.out.println("dailyBounds2 - " + dailyBounds2);
        System.out.println("daily_bounds2 - "+daily_bounds2);
        System.out.println("mergeCal - " + mergeCal);
        System.out.println("mergedMeetings - " + mergedMeetings);
        System.out.println("availableSlots - "+ availableSlots);
        System.out.println("matchedSlots - " + matchedSlots);*/

        List<StringMeeting> calendarMatch = new ArrayList<>();
        for(IntMeeting meeting : matchedSlots ){
            calendarMatch.add(new StringMeeting(minutesToTime(meeting.start), minutesToTime(meeting.end)));
        }

        return calendarMatch;
    }


}