package PracticeWithMayur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SatApril2 {

    public static void main(String[] args) {
        System.out.println(editDistance("ecfbefdcfca", "badfcbebbf"));
    }

    static int minimizeMemory(List<Integer> processes, int m){
        int total = 0;
        for(int num : processes) total += num;
        int currBlock = 0;
        for(int i=0; i<m; i++){
            currBlock += processes.get(i);
        }
        int maxBlock = currBlock;
        for (int i=m; i<processes.size(); i++){
            int lastNum = processes.get(i-m);
            int currNum = processes.get(i);
            currBlock = currBlock -lastNum + currNum;
            maxBlock = Math.max(maxBlock, currBlock);
        }
        return total-maxBlock;
    }

    static int findEarliestMonth(List<Integer> stockPrices){
        int n = stockPrices.size();
        int[] left = new int[n];
        int[] right = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            left[i] = i==0? 0: (int)Math.floor(sum/(i));
            sum += stockPrices.get(i);
        }
        sum = 0;
        for(int i=n-1; i>=0; i--){
            sum += stockPrices.get(i);
            right[i] = (int)Math.floor(sum/(n-i));
        }
        int month = -1;
        int diff = Integer.MAX_VALUE;
        for(int i=1; i<n-1; i++){
            int currDiff = Math.abs(left[i] - right[i]);
            if(diff > currDiff){
                month = i;
                diff = currDiff;
            }
        }
        return month;
    }

    public static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // https://practice.geeksforgeeks.org/problems/rank-the-permutations2229/1/
    public static long findRank(String S){
        int n = S.length();
        int[] cnt = new int[256];
        long mul = fact(n);
        buildArray(cnt, S.toCharArray());
        long place = 0;
        for (int i=0; i<n; i++){
            char c = S.charAt(i);
            mul /= (n-i);
            place += mul * cnt[(int)c-1];
            updateCount(cnt, c);
        }
        return place;
    }

    public static long fact(int n){
        long fact = 1;
        for(int i=1; i<=n; i++){
            fact *= i;
        }
        return fact;
    }

    public static void buildArray(int[] arr, char[] str){
        for(int i=0; i<str.length; i++) arr[str[i]] += 1;
        for(int i=1; i<arr.length; i++) arr[i] += arr[i-1];
    }
    static void updateCount(int[] count, char ch){
        for (int i = ch; i < 256; ++i) count[i] -= 1;
    }

    // https://practice.geeksforgeeks.org/problems/8c8f95810b05b4cab665f2997d36991bd58308a2/1/
    static class Pair{
        char c;
        int count;
        public Pair(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public static String reduced_String(int k, String s){
        int n = s.length();
        Stack<Pair> stack = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.add(new Pair(c, 1));
            }
            else{
                Pair peek = stack.peek();
                if(peek.c == c){
                    stack.add(new Pair(c, peek.count+1));
                }
                else{
                    stack.add(new Pair(c, 1));
                }
            }
            if(stack.peek().count == k){
                for(int j=0; j<k; j++){
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) return "";
        StringBuilder output = new StringBuilder();
        while(!stack.isEmpty()){
            output.append(stack.pop().c);
        }
        output.reverse();
        return String.valueOf(output);
    }

    // https://practice.geeksforgeeks.org/problems/edit-distance3702/1/
    public static int editDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) dp[i][0] = i;
        for(int i=0; i<m+1; i++) dp[0][i] = i;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
            }
        }
        return dp[n][m];
    }

    // https://leetcode.com/problems/longest-valid-parentheses/
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;
        int maxLen = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count += 1;
                stack.push(i);
            }
            else{
                if(count > 0){
                    stack.pop();
                    count -= 1;
                    maxLen = Math.max(maxLen, i-stack.peek());
                }
                else{
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }

    // https://practice.geeksforgeeks.org/problems/search-pattern0205/1/
    public static ArrayList<Integer> search(String pat, String exp) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = exp.length();
        int m = pat.length();

        int[] match = new int[m];
        Arrays.fill(match, -1);

        int i = 1;
        int j = 0;

        while(i < m){
            if(pat.charAt(i) == pat.charAt(j)) match[i++] = j++;
            else if(j>0) j = match[j-1] + 1;
            else i += 1;
        }
        i=0; j=0;
        while (i < n) {
            if(pat.charAt(j) == exp.charAt(i)){
                i += 1;
                j += 1;
                if(j == m){
                    list.add(i-m+1);
                    j=match[j-1] + 1;
                }
            }
            else if(j > 0) j = match[j-1] + 1;
            else i += 1;
        }
        if(list.size() == 0){
            list.add(-1);
        }
        return list;
    }
}
