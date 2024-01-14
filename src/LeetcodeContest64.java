import java.util.*;

public class LeetcodeContest64 {
    public static void main(String[] args) {
        //int[] nums = {7,12,9,8,9,15};
        //System.out.println(findKOr(nums, 4));

        //int[] nums1 = {20,0,18,11,0,0,0,0,0,0,17,28,0,11,10,0,0,15,29};
        //int[] nums2 = {16,9,25,16,1,9,20,28,8,0,1,0,1,27};
        //System.out.println(minSum(nums1, nums2));

//        int[] nums = {0,1,3,3}; //{2,3,0,2,0,0,4,2,3,1};
//
//        System.out.println(minIncrementOperations(nums, 5));
//        int[][] grid = {{0,0,1},{1,0,1},{0,0,0}};
//        System.out.println(findChampion(grid));



    }
    public static int findKOr(int[] nums, int k) {
        int[] bits = new int[31];
        for(int num : nums){
            int temp = 1;
            for(int i=0; i<31; i++){
                int bit = num & temp;
                if(bit >= 1) bits[i] += 1;
                temp <<= 1;
            }
        }
        int ans = 0;
        int tmp = 1;
        for(int i=0; i<31; i++){
            if(bits[i] >= k){
                ans |= tmp;
            }
            tmp <<= 1;
        }
        return ans;
    }

    public static long minSum(int[] nums1, int[] nums2) {
        int zeros1 = 0, zeros2 = 0;
        long sum1 =0, sum2 = 0;
        for(int num : nums1){
            if(num == 0) zeros1 += 1;
            sum1 += num;
        }

        for(int num : nums2){
            if(num == 0) zeros2 += 1;
            sum2 += num;
        }

        if(sum1 == sum2){
            if(zeros1 == 0 && zeros2 == 0) return sum1;
            if(zeros1 == 0 || zeros2 == 0) return -1;
            return sum1 + Math.max(zeros1, zeros2);
        }


        if(sum1 + zeros1 > sum2 + zeros2){
            if(zeros2 == 0) return -1;

            long needed = sum1 + zeros1 - sum2;
            if(needed < zeros2) return -1;
            return sum1 + zeros1;
        }
        else{
            if(zeros1 == 0) return -1;
            long needed = sum2 + zeros2 - sum1;
            if(needed < zeros1) return -1;
            return sum2 + zeros2;
        }
    }

    public static long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        int[] numsK = new int[n];

        for(int i=0; i<n; i++){
            numsK[i] = Math.max(0, k - nums[i]);
        }

        if(n == 1) return numsK[0];
        if(n == 2) return Math.min(numsK[0], numsK[1]);

        long[] dp = new long[n];
        Arrays.fill(dp, -1L);

        long next = nextTwoMinimum(numsK, 0, dp);
        long next1 = nextTwoMinimum(numsK, 1, dp);
        long next2 =  nextTwoMinimum(numsK, 2, dp);
        return Math.min(Math.min(next, next1), next2);

    }

    public static long nextTwoMinimum(int[] nums, int idx, long[] dp){
        int n = nums.length;
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        long next = nextTwoMinimum(nums, idx + 1, dp);
        long next1 = nextTwoMinimum(nums, idx + 2, dp);
        long next2 =  nextTwoMinimum(nums, idx + 3, dp);

        dp[idx] = nums[idx] + Math.min(Math.min(next, next1), next2);

        return dp[idx];
    }

    public static int findChampion1(int[][] grid) {
        int n = grid.length;
        int max = 0, curr = 0, champion = -1;

        for(int i=0; i<n; i++){
            curr = 0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(grid[i][j] == 1) curr += 1;
            }
            if(curr > max){
                champion = i;
                max = curr;
            }
        }
        return champion;
    }

    public static int findChampion(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            int s = edge[0], d = edge[1];
            graph.getOrDefault(s, new ArrayList<>()).add(d);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0, champion = -1;

        for(int start : graph.keySet()){
            int count = dfs(start, graph, dp) - 1;
            if(count > max){
                champion = start;
                max = count;
            }
        }


        return champion;
    }

    public static int dfs(int curr, HashMap<Integer, List<Integer>> graph, Map<Integer, Integer> dp){
        if(dp.containsKey(curr)){
            return dp.get(curr) + 1;
        }
        int count = 0;
        if(!graph.containsKey(curr)){
            dp.put(curr, count);
            return count + 1;
        }
        for(int child : graph.get(curr)){
            count += dfs(child, graph, dp);
        }

        dp.put(curr, count);
        return count + 1;
    }
}
