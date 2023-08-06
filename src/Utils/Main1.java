package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static String arrayChallenge(String[] strArr){
        int n = strArr.length;
        int[][] arr = new int[n][2];
        int idx = 0;
        for(String slot : strArr){
            String[] t = slot.split("-");
            int s = getMinutes(t[0]), e = getMinutes(t[1]);
            arr[idx] = new int[]{s, e};
            idx += 1;
        }
        Arrays.sort(arr, (o1, o2)->{return o1[0] - o2[0];});
        List<int[]> merged = new ArrayList<>();
        int start = arr[0][0], end = arr[0][1];
        for(int i=1; i<n; i++){
            int nextStart = arr[i][0], nextEnd = arr[i][1];
            if(nextStart <= end){
                end = Math.max(end , nextEnd);
            }
            else{
                merged.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            }
        }
        merged.add(new int[]{start, end});
        int maxFreeTime = 0;
        int lastEnd = merged.get(0)[1];
        for(int i=1; i<merged.size(); i++){
            int currStart = merged.get(i)[0];
            maxFreeTime = Math.max(maxFreeTime, currStart - lastEnd);
            lastEnd = merged.get(i)[1];
        }
        String hh = (maxFreeTime / 60) < 10 ? "0" + (maxFreeTime / 60) : "" + (maxFreeTime / 60);
        String mm = (maxFreeTime % 60) < 10 ? "0" + (maxFreeTime % 60) : "" + (maxFreeTime % 60);
        String ans = hh +":"+mm;
        return ans;
    }

    public static int getMinutes(String time){
        int hh = Integer.parseInt(time.substring(0, 2));
        int mm = Integer.parseInt(time.substring(3, 5));
        int post = "PM".equals(time.substring(5, 7)) ? 12 : 0;
        return (hh+post) * 60 + mm;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = new String[] { "09:00AM-10:00AM", "10:30AM-12:00PM", "12:15PM-02:00PM"};
        System.out.println(arrayChallenge(str));
    }
}
