import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ManaseeExam {
    public static void main(String[] args) {

        System.out.println(getMax(Arrays.asList(2,4,2,1,6), Arrays.asList(4,1,1,3)));
    }

    public static int getMax(List<Integer> arr, List<Integer> power){
        int M = (int)1e9+7;
        long pwr = 0;
        int n = arr.size();
        long[] prefix = new long[n];
        long sum = 0;
        int idx =0;
        while (idx < n){
            sum += arr.get(idx);
            prefix[idx] = sum;
            idx += 1;
        }
        Collections.sort(power);
        int s =0, e = power.size()-1;
        while(s < e){
            long sub = power.get(s) == 0 ? 0 : prefix[power.get(s) -1];
            long full = prefix[power.get(e)];
            pwr  = (pwr + (full - sub) ) % M;
            s += 1;
            e -=1;
        }
        return (int)pwr;
    }

}
