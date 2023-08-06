package String;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-and-replace-in-string/
public class FindAndReplaceInString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(indices[i], i);
        }

        StringBuilder target = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(i)){
                target.append(s.charAt(i));
                continue;
            }
            int idx = map.get(i);
            String src = sources[idx];
            int len = src.length();
            String sbstr = s.substring(i, i+len);
            if(src.equals(sbstr)){
                target.append(targets[idx]);
            }
            else{
                target.append(sbstr);
            }
            i = i + len -1;
        }
        return target.toString();
    }
}
