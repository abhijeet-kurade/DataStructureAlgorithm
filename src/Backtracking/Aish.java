package Backtracking;

public class Aish {
    public static void main(String[] args) {
        String s = "-H-H-H-";
        System.out.println(problem2(s));
    }

    public static int problem1(String S){
        int l=0, r=0, intervals = 0;
        for(char c : S.toCharArray()){
            if(c == 'L') l += 1;
            else r += 1;
            if(l == r) intervals += 1;
        }
        return intervals;
    }


    public static int problem2(String S){
        int n = S.length();

        for(int i=1; i<n-1; i++){
            if(S.charAt(i) == 'H' && S.charAt(i-1) == 'H' && S.charAt(i+1) == 'H'){
                return -1;
            }
        }

        if(n == 2){
            if(S.equals("HH")) return -1;
            else return 1;
        }
        else{
            if(S.charAt(0) == 'H' && S.charAt(1) == 'H') return -1;
            if(S.charAt(n-1) == 'H' && S.charAt(n-2) == 'H') return -1;
        }
        int[] tanks = {0};
        int[] curr = {0};
        int lastHouse = -1;
        for(int i=n-1; i>=0; i--){
            if(S.charAt(i) == 'H'){
                lastHouse = i;
                break;
            }
        }
        backtracking(new StringBuilder(S), skipToNextHouse(0, new StringBuilder(S)), tanks, curr, lastHouse);
        return tanks[0];
    }

    public static void backtracking(StringBuilder s, int idx, int[] tanks, int[] curr, int lastHouse){
        int n = s.length();
        //System.out.println(idx +" "+s);
        if(idx >= lastHouse) {
            tanks[0] = Math.max(curr[0], tanks[0]);
            return;
        }
        if(idx == 0){
            if(s.charAt(idx+1) == '-'){
                s.setCharAt(idx+1, 'T');
                curr[0] += 1;
                int next = skipToNextHouse(idx, s);
                backtracking(s, next, tanks, curr, lastHouse);
                s.setCharAt(idx-1, '-');
                curr[0] -= 1;
            }
        }
        else if(idx  == n-1){
            if(s.charAt(idx-1) == '-'){
                s.setCharAt(idx-1, 'T');
                curr[0] += 1;
                int next = skipToNextHouse(idx, s);
                backtracking(s, next, tanks, curr, lastHouse);
                s.setCharAt(idx-1, '-');
                curr[0] -= 1;
            }

        }
        else{
            if(s.charAt(idx-1) == '-'){
                s.setCharAt(idx-1, 'T');
                curr[0] += 1;
                int next = skipToNextHouse(idx, s);
                backtracking(s, next, tanks, curr, lastHouse);
                s.setCharAt(idx-1, '-');
                curr[0] -= 1;
                backtracking(s, next, tanks, curr, lastHouse);
            }
            else if(s.charAt(idx-1) == 'H'){
                if(s.charAt(idx+1) == '-'){
                    s.setCharAt(idx+1, 'T');
                    curr[0] += 1;
                    int next = skipToNextHouse(idx, s);
                    backtracking(s, next, tanks, curr, lastHouse);
                    s.setCharAt(idx-1, '-');
                    curr[0] -= 1;
                    backtracking(s, next, tanks, curr, lastHouse);
                }
            }
            else if(s.charAt(idx-1) == 'T'){
                int next = skipToNextHouse(idx, s);
                backtracking(s, next, tanks, curr, lastHouse);
            }
        }
    }

    public static int skipToNextHouse(int idx, StringBuilder s){
        idx += 1;
        for(; idx<s.length(); idx++){
            if(s.charAt(idx) == 'H') return idx;
        }
        return idx;
    }
}
