package ArrayHashMaps.Arrays;

import java.util.Arrays;

public class MinRequiredPlatform {

    public int minRequiredPlatform(int[] arr, int[] dept){

        Arrays.sort(arr);
        Arrays.sort(dept);
        int len = arr.length;

        int platforms = 0;
        int maxPlatforms = 0;
        int i=0;
        int j=0;

        while(i<len){
            if(arr[i] < dept[j]){
                platforms += 1;
                maxPlatforms = Math.max(platforms, maxPlatforms);
                i += 1;
            }
            else{
                j += 1;
                platforms -= 1;
            }
        }

        return maxPlatforms;
    }
}
