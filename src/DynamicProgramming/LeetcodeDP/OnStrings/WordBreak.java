package DynamicProgramming.LeetcodeDP.OnStrings;

import Utils.Trie;

import java.util.List;

public class WordBreak {

    public static boolean wordBreak1(String s, List<String> wordDict) {

        Trie trie = new Trie();
        for(String word : wordDict){
            trie.insert(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n];

        for(int i=0; i<n; i++){
            String substring = s.substring(0, i+1);
            if(trie.search(substring)){
                dp[i] = true;
                continue;
            }
            for(int j=i-1; j>=0; j--){
                if(dp[j]){
                    String right = s.substring(j, i+1);
                    if(trie.search(right)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n-1];
    }
    public static boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n];

        for(int i=0; i<n; i++){
            for(String word : wordDict){
                if(i < word.length() - 1){
                    continue;
                }
                if(i == word.length() - 1 || dp[i - word.length()] ){
                    if(word.equals(s.substring(i - word.length() + 1, i+1))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n-1];
    }

}
