package ArrayHashMaps.Time;

public class MinimumPlatformRequired {
    public static void main(String[] args) {
        int[][] trains = {{10, 12}, {10, 100}, {12, 29}, {14, 120}, {17, 23}, {21, 24} };
        System.out.println(minPlatform(trains));
    }

    public static int minPlatform(int[][] trains){
        int[] clock = new int[(124 * 60) + 2];

        for(int[] train : trains){
            int at = train[0], dt = train[1];
            clock[at] += 1;
            clock[dt+1] -=1;
        }
        int platforms = 1;
        for(int i=1; i<= ((124 * 60) + 1); i++){
            clock[i] = clock[i] + clock[i-1];
            platforms = Math.max(platforms, clock[i]);
        }
        return platforms;
    }
}
