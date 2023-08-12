package ArrayHashMaps.Arrays;

public class LongestPeak {
    public int longestPeak(int[] array) {
        int len = array.length;
        int index=1;
        int maxPeak=0;

        while(index<len-1){
            boolean isThisPeak = (array[index-1] < array[index]) && (array[index] > array[index+1]);
            if(isThisPeak){
                System.out.println("Peak at " + index);
                int peak = index;
                int currentPeakStart= index-1;
                while(currentPeakStart >=0 && array[index]>array[currentPeakStart]){
                    currentPeakStart--;
                    index--;
                }
                currentPeakStart = index;
                index = peak;
                int currentPeakEnd = index+1;
                while(currentPeakEnd < len && array[index]>array[currentPeakEnd]){
                    currentPeakEnd++;
                    index++;
                }
                currentPeakEnd = index;
                System.out.println(currentPeakEnd + " "+ currentPeakStart);
                maxPeak = Math.max(maxPeak, (currentPeakEnd - currentPeakStart) + 1);
                index = currentPeakEnd;
            }
            index++;
        }

        return maxPeak;
    }
}
