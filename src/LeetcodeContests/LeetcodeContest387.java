package LeetcodeContests;

public class LeetcodeContest387 {
    public static void main(String[] args) {
        /*
        [[7,2,9],
        [1,5,0],
        [2,6,6]]
        20
         */
        int[][] grid = {{7,2,9},{1,5,0},{2,6,6}};
        System.out.println(countSubmatrices(grid, 20));
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                sum[i][j] = (i == 0 ? 0 : sum[i-1][j]) + (j == 0 ? 0 : sum[i][j-1]) + grid[i][j] - (i==0||j==0?0:sum[i-1][j-1]);
                if(sum[i][j] <= k) ans += 1;
            }
        }

        return ans;
    }
}
