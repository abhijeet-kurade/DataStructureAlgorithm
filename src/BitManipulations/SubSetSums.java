package BitManipulations;

import java.util.ArrayList;
import java.util.List;

public class SubSetSums {

    public List<Integer> subsetSums(int[] nums){
        List<Integer> sums = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i< (1<<n) ; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                int bit = i & (1<<j);
                if(bit == 1){
                    sum += nums[j];
                }
            }
            sums.add(sum);
        }
        return sums;
    }
}
