package TwoPointers;

//https://leetcode.com/problems/swap-adjacent-in-lr-string/

public class SwapAdjacentInLRString {
    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }
    public static boolean canTransform(String start, String end) {
        int n = start.length();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(int i=0; i<n; i++){
            if(start.charAt(i) != 'X') s1.append(start.charAt(i));
            if(end.charAt(i) != 'X') s2.append(end.charAt(i));
        }
        if(!s1.toString().equals(s2.toString())) return false;
        int i=0, j=0;
        while(i<n && j<n){
            if(start.charAt(i) == 'X') i+=1;
            else if(end.charAt(j) == 'X') j+= 1;
            else{
                if(start.charAt(i) == 'L' && i<j) return false;
                else if(start.charAt(i) == 'R' && i>j) return false;
                i += 1;
                j += 1;
            }
        }
        return true;

    }
}
