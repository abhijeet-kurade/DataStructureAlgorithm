package PracticeWithMayur;

import java.util.*;

public class FriApril1 {

    //https://leetcode.com/problems/roman-to-integer/
    public static int romanToInt(String number) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);

        int idx = 0, n = number.length();
        int total = 0;
        while(idx < n){
            int curr = map.get(number.charAt(idx));
            int next = idx==(n-1) ? 0 : map.get(number.charAt(idx+1));

            if(curr >= next){
                total += curr;
                idx+=1;
            }
            else{
                total += (next-curr);
                idx += 2;
            }
        }
        return total;
    }


    // https://practice.geeksforgeeks.org/problems/closest-strings0611/1/
    public static int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int M = Integer.MAX_VALUE;
        int idx1 = M, idx2 = M;
        int n = s.size();
        int dist = M;
        for(int i=0; i<n; i++){
            String curr = s.get(i);
            if(curr.equals(word1)){
                idx1 = i;
                dist = Math.min(dist, idx2==M?M:Math.abs(idx1-idx2));
            }
            if(curr.equals(word2)){
                idx2 = i;
                dist = Math.min(dist, idx1==M?M:Math.abs(idx1-idx2));
            }
        }
        return dist;
    }

    //https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1
    public static boolean isRotated(String str1, String str2){
        int n = str1.length();

        StringBuilder str = new StringBuilder(str1);
        char c1 = str.charAt(0);
        str.deleteCharAt(0);
        str.append(c1);
        c1 = str.charAt(0);
        str.deleteCharAt(0);
        str.append(c1);
        if(str2.equals(String.valueOf(str))) return true;

        str = new StringBuilder(str1);
        c1 = str.charAt(n-1);
        str.deleteCharAt(n-1);
        str.insert(0, c1);
        c1 = str.charAt(n-1);
        str.deleteCharAt(n-1);
        str.insert(0, c1);
        if(str2.equals(String.valueOf(str))) return true;

        return false;

    }

    //https://practice.geeksforgeeks.org/problems/implement-atoi/1
    public static int atoi(String str) {
        int n = str.length();
        int total = 0;
        int mul = 1;
        for(int i=n-1; i>=0; i--){
            char c = str.charAt(i);
            if(i==0 && c=='-') return total * -1;
            if(isNumber(c)){
                int num = c - '0';
                total += mul * num;
                mul *= 10;
            }
            else return -1;
        }
        return total;
    }
    public static boolean isNumber(char c){
        int num = c - '0';
        return 0<=num && num<=9;
    }
    public boolean isValid(String s) {
        int n = s.length();
        if(s.charAt(n-1) == '.') return false;

        int start  = 0;
        int idx = 0;
        int count = 0;

        while(idx < n){
            if (s.charAt(idx) == '.'){
                count += 1;
                String num = s.substring(start, idx);
                if(!isValidNum(num)) return false;
                start = idx+1;
            }
            idx += 1;
        }
        if(count != 3) return false;
        String num = s.substring(start, n);
        if(!isValidNum(num)) return false;
        return true;
    }

    // https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1
    public static boolean isValidNum(String num){
        if(num.length() == 0) return false;
        if(num.length() > 1 && num.charAt(0) == '0') return false;
        int number = atoi(num);
        return 0<=number && number <= 255;
    }

    //https://practice.geeksforgeeks.org/problems/add-binary-strings3805/1
    public static String addBinary(String A, String B) {
        int n = A.length(), m = B.length();
        int idx1 = n-1, idx2=m-1, carry =0;
        StringBuilder answer = new StringBuilder();
        while(idx1>=0 || idx2>=0){
            int num1 = idx1>=0?A.charAt(idx1)-'0': 0;
            int num2 = idx2>=0?B.charAt(idx2)-'0': 0;

            if(idx1>=0) idx1 -= 1;
            if(idx2>=0) idx2 -= 1;

            int sum = num1 + num2 + carry;
            char ans;
            if(sum == 2){
                ans = '0';
                carry = 1;
            }
            else if(sum == 3){
                ans = '1';
                carry = 1;
            }
            else{
                ans = (char)(sum+'0');
                carry = 0;
            }
            answer.append(ans);
        }
        answer.append((char)(carry+'0'));
        answer.reverse();
        int idx = 0;
        for(int i=0; i<answer.length(); i++){
            if(answer.charAt(i) == '1'){
                idx = i;
                break;
            }
            idx = i;
        }
        return String.valueOf(answer.substring(idx, answer.length()));
    }

    // https://practice.geeksforgeeks.org/problems/multiply-two-strings/1
    public String multiplyStrings(String s1,String s2){
        int n = s1.length(), m = s2.length();

        int isNegative = 0;
        if(s1.charAt(0) == '-'){
            isNegative += 1;
            s1 = s1.substring(1, s1.length());
        }
        if(s2.charAt(0) == '-'){
            isNegative += 1;
            s2 = s2.substring(1, s2.length());
        }

        n = s1.length();
        m = s2.length();

        String total = "0";
        for(int i=n-1; i>=0; i--){
            int num1 = s1.charAt(i) - '0';
            for(int j=m-1; j>=0; j--){
                int num2 = s2.charAt(j) - '0';
                if(num1 == 0 || num2==0) continue;
                int multi = num1 * num2;
                int zeros = (n-1-i) + (m-1-j);
                String curr = padZero(multi, zeros);
                total = addStrings(total, curr);
            }
        }
        if(total.length() == 1 && Integer.parseInt(total) == 0) return "0";
        if(isNegative % 2 == 1) total = "-"+total;
        return total;
    }
    public String addStrings(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int idx1=n-1, idx2=m-1;
        int carry=0;
        StringBuilder sum = new StringBuilder();
        while(idx1>=0 || idx2>=0){
            int num1 = idx1<0 ? 0 : s1.charAt(idx1) - '0';
            int num2 = idx2<0 ? 0 : s2.charAt(idx2) - '0';

            if(idx1>=0) idx1 -= 1;
            if(idx2>=0) idx2 -= 1;

            int s = num1 + num2 + carry;
            int unit = s % 10;
            carry = s/10;

            sum.append((char)(unit+'0'));
        }
        if(carry != 0) sum.append((char)(carry+'0'));
        sum.reverse();
        if(sum.length() == 1) return String.valueOf(sum);
        int idx = 0;
        for(int i=0; i<sum.length(); i++){
            if(sum.charAt(i)!='0'){
                idx = i;
                break;
            }
            idx=i;
        }
        if(sum.length()-1 == idx) return "0";
        return String.valueOf(sum.substring(idx, sum.length()));
    }
    public String padZero(int num, int zeros){
        StringBuilder number = new StringBuilder(String.valueOf(num));
        for(int i=0; i<zeros; i++){
            number.append('0');
        }
        return String.valueOf(number);
    }

    // https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1/
    static int countMin(String s)    {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int w=1; w<n; w++){
            for(int i=0; i<n; i++){
                int j = i+w;
                if(j>=n) continue;
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
            }
        }
        return dp[0][n-1];
    }

    // https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
    public static String minWindowAllChar(String s1, String s2){
        char[] str = s1.toCharArray(), word = s2.toCharArray();
        int[] chars = new int[256];
        int count = 0, ans = Integer.MAX_VALUE, s = 0;
        for(int i=0; i<word.length; i++){
            if(chars[word[i]] == 0) count += 1;
            chars[word[i]] += 1;
        }

        int i=0, j=0;
        while(j<str.length){

            chars[str[j]] -= 1;
            if(chars[str[j]] == 0) count -= 1;

            if(count == 0){
                while(count == 0){
                    if(ans > j-i+1){
                        ans = j-i+1;
                        s = i;
                    }

                    chars[str[i]] += 1;
                    if(chars[str[i]] > 0) count += 1;

                    i += 1;

                }
            }
            j += 1;
        }

        if (ans != Integer.MAX_VALUE)
            return String.valueOf(str).substring(s, ans+s);
        else
            return "-1";
    }


    public static int minDiff(int[] arr, long steps){
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] < arr[i+1]){
                int diff = arr[i+1]-arr[i];
                if(diff * (i+1) <= steps){
                    steps -= diff * (i+1);
                    if(steps==0) break;
                }
                else{
                    int max = arr[arr.length-1];
                    int min = arr[i] + ((int)Math.floor(steps/(i+1)));
                    return max - min;
                }
            }
        }
        if(steps != 0){
            if(steps%arr.length != 0) return 1;
            else return 0;
        }
        return 0;
    }

    public static int minStockValue(List<Integer> stockPrice, int k, int priceDrc, int attacks){
        int n = stockPrice.size();

        for(int i=0; i<attacks; i++){

        }

        return 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,5,6,6};

        System.out.println(minDiff(arr, 11));
    }

}
