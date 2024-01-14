package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contest {

    public static void main(String[] args) {
        System.out.println(beautifulIndices("kzlrqzldvy", "zl", "tfsr", 9));
    }

    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        Set<Integer> ans = new HashSet<>();
        List<Integer> as = getAllOccurOfSubstring(s, a);
        List<Integer> bs = getAllOccurOfSubstring(s, b);

        for(int i : as){
            for(int j : bs){
                if(Math.abs(i - j) <= k){
                    ans.add(i);
                }
            }
        }
        return new ArrayList(ans);
    }

    public static List<Integer> getAllOccurOfSubstring(String s, String sub){
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = sub.length();
        for(int i=0; i<n; i++){
            for(int j=0; j<m && i+j<n; j++){
                if(s.charAt(i+j) == sub.charAt(j)){
                    if(j == m -1){
                        ans.add(i);
                    }
                }
                else{
                    break;
                }
            }
        }

        return ans;
    }
}
