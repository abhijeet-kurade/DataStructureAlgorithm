package DynamicProgramming.NeetCode.OneD;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int j=0; j<n; j++){
            String subStr = s.substring(0, j+1);
            if(dict.contains(subStr)){
                dp[j] = true;
                continue;
            }
            for(int i=j-1; i>=0; i--){
                if(dp[i]){
                    subStr = s.substring(i+1, j+1);
                    if(dict.contains(subStr)){
                        dp[j] = true;
                        break;
                    }
                }
            }
        }
        return dp[n-1];
    }
}
