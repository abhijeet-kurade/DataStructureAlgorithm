package ArrayHashMaps.Arrays.AlgoExpert;

public class LongestPeak {
    public int longestPeak(int[] array) {
        int len = array.length;
        int index=0;
        int maxPeak=0;

        while(index<len){
            boolean isPeak = false;
            if(index == 0 || index == array.length -1)
                isPeak = false;
            else
                isPeak = (array[index-1] < array[index]) && (array[index] > array[index+1]);
            if(isPeak){
                int peak = index;
                int currentPeakStart= index-1;
                while(currentPeakStart >=0 && array[index]>array[currentPeakStart]){
                    currentPeakStart--;
                    index--;
                }
                index = peak;
                int currentPeakEnd = index+1;
                while(currentPeakEnd < len && array[index]>array[currentPeakEnd]){
                    currentPeakEnd++;
                    index++;
                }
                maxPeak = Math.max(maxPeak, index - currentPeakStart);
            }
            index++;
        }
        return maxPeak;
    }
}
