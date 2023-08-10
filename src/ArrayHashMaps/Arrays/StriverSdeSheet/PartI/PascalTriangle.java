package ArrayHashMaps.Arrays.StriverSdeSheet.PartI;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int i=1; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i) row.add(1);
                else row.add(triangle.get(i-1).get(j) + triangle.get(i-1).get(j-1));
            }
            triangle.add(row);
        }
        System.out.println(triangle);
        return null;
    }
}
