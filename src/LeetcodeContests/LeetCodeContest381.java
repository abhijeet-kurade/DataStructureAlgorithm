package LeetcodeContests;

import java.util.Arrays;

public class LeetCodeContest381 {

    public static void main(String[] args) {
        System.out.println(countOfPairs(3,3,1));
    }
    public static int minimumPushes(String word) {
        int[] cnt = new int[26];
        for(char c : word.toCharArray()){
            cnt[c - 'a'] += 1;
        }
        Arrays.sort(cnt);
        int ans = 0;
        int pushes = 0;
        for(int i=25; i>=0;){
            if(cnt[i] == 0) break;
            pushes += 1;
            for(int j=0; j<8 && i>=0; j++){
                if(cnt[i] == 0) break;
                ans += cnt[i] * pushes;
                i--;
            }
        }

        return ans;
    }

    public static int[] countOfPairs(int n, int x, int y) {
        x--;
        y--;
        if(x > y){
            int t = x;
            x = y;
            y = t;
        }
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int d1 = j - i;
                int d2 = Math.abs(x - i) + Math.abs(y - j) + 1;
                int d = Math.min(d1, d2);
                dist[d-1] += 2;
            }
        }
        return dist;
    }
}
