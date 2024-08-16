package Amazon;

public class Warehouse {

    public int minDistance(int[] truck, int[] warehouse, int[][] lockers){
        int all_distance = 0;
        for(int[] locker : lockers){
            all_distance += 2 * getDistance(warehouse, locker);
        }
        int distance = Integer.MAX_VALUE;
        for(int[] locker : lockers){
            int oneTrip = getDistance(truck, locker) + getDistance(warehouse, locker);
            int roundTrip = 2 * getDistance(warehouse, locker);
            distance = Math.min(distance, all_distance + oneTrip - roundTrip );
        }
        return distance;
    }

    private int getDistance(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
