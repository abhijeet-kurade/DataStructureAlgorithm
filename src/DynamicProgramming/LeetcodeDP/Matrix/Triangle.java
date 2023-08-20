package DynamicProgramming.LeetcodeDP.Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> last = new ArrayList<>();
        for(List<Integer> curr : triangle){
            int n = curr.size();
            if(n == 1){
                last = triangle.get(0);
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                int left = i == 0 ? Integer.MAX_VALUE : last.get(i-1);
                int right = i == n-1 ? Integer.MAX_VALUE : last.get(i);
                temp.add(Math.min(left, right) + curr.get(i));
            }
            last = temp;
        }
        return Collections.min(last);
    }
}
