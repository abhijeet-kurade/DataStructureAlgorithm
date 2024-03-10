package LeetcodeContests;

import java.util.Arrays;

public class LeetCodeContest381 {

    public static void main(String[] args) {
        System.out.println(countOfPairs(6,2,4));
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

    public static int[] countOfPairs1(int n, int x, int y) {
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

    public static long[] countOfPairs(int n, int x, int y) {
        if (x > y) {
            int t = x; x = y; y = t;
        }
        long[] A = new long[n];
        for (int i = 1; i <= n; ++i) {

            A[0] += 2;                                             // go left and right
            int k = Math.min(i - 1, Math.abs(i - y) + x);
            A[k]--;                                                // reach 1 then stop
            k = Math.min(n - i, Math.abs(i - x) + 1 + n - y);
            A[k]--;     // reach n then stop
            k = Math.min(Math.abs(i - x), Math.abs(y - i) + 1);
            A[k]++;   // reach x then split
            k = Math.min(Math.abs(i - x) + 1, Math.abs(y - i));
            A[k]++;   // reach y then split

            int r = Math.max(x - i, 0) + Math.max(i - y, 0);
            A[r + (y - x + 0) / 2]--;                              // i -> x -> y <- x
            A[r + (y - x + 1) / 2]--;                              // i -> y -> x <- y
        }
        for (int i = 1; i < n; ++i)
            A[i] += A[i - 1];
        return A;
    }
}
