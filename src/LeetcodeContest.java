import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LeetcodeContest {

    public static int findChampion(int n, int[][] edges) {
        if(n == 1) return 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            int s = edge[0], d = edge[1];
            if(!graph.containsKey(s)) graph.put(s, new ArrayList<>());
            graph.get(s).add(d);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        int maxScore = -1;

        for(int start : graph.keySet()){
            dp.put(start, dfs(start, graph, visited) - 1);
            maxScore = Math.max(maxScore, dp.get(start));
            visited.clear();
        }
        int countOfChampions = 0;
        for(int player : dp.keySet()){
            if(maxScore == dp.get(player)) countOfChampions += 1;
        }

        if(maxScore < n-1) return -1;

        if(countOfChampions != 1) return -1;

        for(int player : dp.keySet()){
            if(maxScore == dp.get(player)) return player;
        }

        return -1;
    }

    public static int dfs(int curr, HashMap<Integer, List<Integer>> graph, Set<Integer> visited){
        if(visited.contains(curr)){
            return 0;
        }
        int count = 0;

        if(!graph.containsKey(curr)){
            visited.add(curr);
            return count + 1;
        }
        for(int child : graph.get(curr)){
            count += dfs(child, graph, visited);
        }

        visited.add(curr);
        return count + 1;
    }

    public static void main(String[] args) {

        //System.out.println(getMaximumSumOfHeights(Arrays.asList(4,8,6,7)));

        int[] gas = {4,3,4,1,1,3};
        int[] cost = {6,4,2,4,3,5};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static long getMaximumSumOfHeights(List<Integer> maxHeight){

        int n = maxHeight.size();
        int idx = 0, maxLen = 0, best = -1, start = -1, end = -1;

        while(idx < n){
            boolean isPeak = false;
            if(idx == 0 || idx == n-1)
                isPeak = false;
            else isPeak = (maxHeight.get(idx-1) < maxHeight.get(idx)) && maxHeight.get(idx+1) < maxHeight.get(idx);

            if(isPeak){
                int peak = idx;

                int currentPeakStart= idx-1;
                while(currentPeakStart >= 0 && maxHeight.get(idx)>maxHeight.get(currentPeakStart)){
                    currentPeakStart--;
                    idx--;
                }
                idx = peak;
                int currentPeakEnd = idx+1;
                while(currentPeakEnd < n && maxHeight.get(idx)>maxHeight.get(currentPeakEnd)){
                    currentPeakEnd++;
                    idx++;
                }
                int currentLength = idx - currentPeakStart;
                if(maxLen < currentLength){
                    best = peak;
                    maxLen = currentLength;
                    start = currentPeakStart + 1;
                    end = currentPeakEnd - 1;
                }
            }
            idx += 1;
        }

        long sum = 0;

        int s = best;
        while(s >= 0 && s >= start){
            sum += maxHeight.get(s);
            s -= 1;
        }
        int e = best + 1;
        while(e < n && e <= end){
            sum += maxHeight.get(end);
            e += 1;
        }

        return sum;
    }
    public static int[] rossGuess(int n, int[] guesses){
        int[] answer = new int[n+1];

        for(int j=0; j<=n; j++){
            double x = j+0.5;
            boolean prev = false, next = false;
            if(j == 0) prev = true;
            if(j == n) next = true;
            int count = 0;
            int prevSign = 0;
            for(int i : guesses){
                int currSign = compareNumbers(i,x);
                if(prevSign == 1 && currSign == -1) count += 1;
                prevSign = currSign;
                if(i == j+1) next = true;
                if(i == j) prev = true;

                if(next && prev ){
                    answer[j] = count;
                    break;
                }
            }
        }
        return answer;
    }

    public static int compareNumbers(int i, double t){
        return i < t ? -1 : 1;
    }

    public int countSafePermutations(int n){

        return -1;
    }

    public int permute(int n, int idx, boolean[] taken, List<Integer>[] candidates){
        if(idx > n) return 1;
        int count = 0;
        
        return count;
    }

    public List<Integer> getFactors(int n, int i){
        List<Integer> factors = new ArrayList<>();
        for(int j = 1; j<=n; i++){
            if(i%j == 0 || j%i==0) factors.add(j);
        }
        return factors;
    }

    public static int removeAlmostEqualCharacters(String word) {
        int m = word.length();
        int count = 0;
        for(int i=0; i<m-1; i++){
            char c=word.charAt(i), n=word.charAt(i+1);
            if(c == n || (Math.abs(c - n) < 2)){
                count += 1;
                i += 1;
            }
        }
        return count;
    }


    public static int maxSubarrayLength(int[] nums, int k) {

        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end =0;
        for(;start<nums.length; start+=1){
            map.put(nums[start], map.getOrDefault(nums[start], 0)+1);

            while(map.get(nums[start]) > k){
                map.put(nums[end], map.getOrDefault(nums[end], 0)-1);
                end += 1;
            }
            len = Math.max(len, start - end + 1);
        }
        return len;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int started = -1, remain = 0, curr = 0, req = 0;
        int idx = 0;
        for(int i=0; i<2*n; i++){
            idx = idx % n;
            if(idx == started) return idx;
            curr = gas[idx];
            req = cost[idx];
            remain = (remain + curr) - req;
            if(remain < 0){
                started = -1;
                remain = 0;
            }
            else if(started == -1){
                started = idx;
            }

            idx += 1;
        }
        return -1;
    }
}
