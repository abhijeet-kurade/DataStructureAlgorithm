package SlidingWindow;

//https://leetcode.com/problems/maximum-number-of-visible-points/

import java.util.*;

public class MaximumNumberOfVisiblePoints {
    public static void main(String[] args) {
        int[][] pts ={{41,7},{22,94},{90,53},{94,54},{58,50},{51,96},{87,88},{55,98},{65,62},{36,47},{91,61},{15,41},{31,94},{82,80},{42,73},{79,6},{45,4}};
        List<List<Integer>> points = new ArrayList<>();
        for(int[] p : pts) points.add(Arrays.asList(p[0], p[1]));
        int angle = 17;
        List<Integer> locations = Arrays.asList(6,84);

        System.out.println(visiblePoints(points, angle,locations));
    }
    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int same = 0;
        for(List<Integer> point : points){
            if(point.get(0) - location.get(0) == 0 && point.get(1) - location.get(1) == 0){
                same++;
                continue;
            }
            angles.add(Math.toDegrees(Math.atan2(point.get(0) - location.get(0), point.get(1) - location.get(1))));
        }
        Collections.sort(angles);
        Queue<Double> queue = new LinkedList<>();
        int answer  = 0;

        for(Double point : angles){
            queue.add(point);
            while (point - queue.peek() > angle) queue.poll();
            answer = Math.max(answer, queue.size());
        }

        for(Double point : angles){
            point += 360;
            queue.add(point);
            while (point - queue.peek() > angle) queue.poll();
            answer = Math.max(answer, queue.size());
        }
        return answer;
    }

    public static int visiblePoints1(List<List<Integer>> points, int angle, List<Integer> location) {
        int pointer = 0;
        List<Double> lis = new ArrayList<>();
        for(List<Integer> point : points){
            if(point.get(0) - location.get(0) == 0 && point.get(1) - location.get(1) == 0) {
                pointer++; continue;
            }
            lis.add(Math.toDegrees(Math.atan2(point.get(0) - location.get(0), point.get(1) - location.get(1))));
        }

        double[] arr = new double[lis.size() * 2];
        int counter = 0, output = pointer;
        for(Double v : lis){
            arr[counter++] = v; arr[counter++] = v + 360;
        }
        Arrays.sort(arr);
        for(int i=0,j=i+1;i<arr.length;i++){
            while(arr[i] - arr[j] > angle) j++;
            output = Math.max(output, pointer+i-j+1);
        }
        return output;
    }


}
