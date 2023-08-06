package DynamicProgramming;

import java.util.Arrays;

public class NumberOfMusicPlaylists {
    public static void main(String[] args) {

    }
    public static int numMusicPlaylists(int n, int goal, int k) {

        int[][] dp = new int[109][109]; // why 109 works ???
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return (int)countPlaylists(goal, 0, 0, n, k, dp);

    }

    public static long countPlaylists(int goal, int songs, int uniqueSongs, int allSongs, int k, int[][] dp){

        if(goal == songs ) return uniqueSongs == allSongs ? 1 : 0;

        //if(uniqueSongs >= allSongs) return 0;

        if(dp[songs][uniqueSongs] != -1) return dp[songs][uniqueSongs];

        int M = (int)1e9+7;//1000000007;

        long withCurr = (countPlaylists(goal, songs+1, uniqueSongs, allSongs, k, dp) * (Math.max(0, uniqueSongs - k)) ) % M;
        long withNew = ((countPlaylists(goal, songs+1, uniqueSongs+1, allSongs, k, dp) % M) * (allSongs - uniqueSongs) ) % M;

        dp[songs][uniqueSongs] = (int) ( (withCurr + withNew) % M );

        return dp[songs][uniqueSongs];

    }
}
