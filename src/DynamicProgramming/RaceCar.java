package DynamicProgramming;

//https://leetcode.com/problems/race-car/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar {
    public static void main(String[] args) {
        System.out.println(racecar(3));
    }

    public static int racecar(int target) {

        int limit = 2 * target;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(new int[]{0, 1});
        seen.add(0+":"+1);
        int steps = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++){
                int[] node = queue.poll();
                int pos = node[0], speed = node[1];
                int newPos = pos + speed, newSpeed = speed * 2;

                if(newPos == target) return steps + 1;

                if(Math.abs(newSpeed) < limit && Math.abs(pos) < limit && !seen.contains(newPos+":"+newSpeed)){
                    queue.add(new int[]{newPos, newSpeed});
                    seen.add(newPos+":"+newSpeed);
                }
                int reverseSpeed = speed > 0 ? -1 : 1;
                if(!seen.contains(pos+":"+reverseSpeed)){
                    queue.add(new int[]{pos, reverseSpeed});
                    seen.add(pos+":"+reverseSpeed);
                }

            }
            steps += 1;
        }
        return -1;
    }
}
