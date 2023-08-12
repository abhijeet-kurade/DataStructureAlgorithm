package ArrayHashMaps.Arrays.AlgoExpert;

import java.util.Arrays;

public class SmallestDifference {
    public int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int lenOne = arrayOne.length;
        int lenTwo = arrayTwo.length;
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int indexOne = 0;
        int indexTwo = 0;

        int smallestDiff = Integer.MAX_VALUE;
        int[] smallestDiffPair = new int[2];

        while(indexOne < lenOne || indexTwo < lenTwo){
            int diff = Math.abs(arrayOne[indexOne] - arrayTwo[indexTwo]);
            if(diff < smallestDiff){
                smallestDiff = diff;
                smallestDiffPair[0] = arrayOne[indexOne];
                smallestDiffPair[1] = arrayTwo[indexTwo];
            }
            if(arrayOne[indexOne] < arrayTwo[indexTwo]){
                indexOne += 1;
                if(indexOne == lenOne) break;
            }
            else {
                indexTwo += 1;
                if(indexTwo == lenTwo) break;
            }
        }
        return smallestDiffPair;
    }

}
