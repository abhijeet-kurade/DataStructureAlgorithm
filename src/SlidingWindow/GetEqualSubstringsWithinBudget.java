package SlidingWindow;

// https://leetcode.com/problems/get-equal-substrings-within-budget/
public class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {

    }
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int cost = 0;
        int right=0, left=0;
        int maxLen = 0;
        while(right < n){

            if(cost <= maxCost){
                cost += Math.abs(s.charAt(right) - t.charAt(right));
                right += 1;
            }
            else if(cost > maxCost && left < right){
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left += 1;
            }
            else{
                cost += Math.abs(s.charAt(right) - t.charAt(right));
                right += 1;
                continue;
            }
            if(cost <= maxCost) {
                maxLen = Math.max(maxLen, right - left );
            }
        }
        return maxLen;
    }
    public int equalSubstring1(String s, String t, int maxCost){
        int n = s.length(), cost = 0, ans = 0;
        int left = 0;
        for (int right = 0; right<n; right++) {
            if (s.charAt(right)!=t.charAt(right)) {
                cost += Math.abs(s.charAt(right)-t.charAt(right));
            }
            while (cost>maxCost && left<=right) {
                cost -= Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }

}
