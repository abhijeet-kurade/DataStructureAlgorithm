package SlidingWindow;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        int[] chars = new int[256];
        int unique = 0;
        for(int i=0; i<t.length(); i++){
            int c = t.charAt(i);
            if(chars[c] == 0) unique += 1;
            chars[c] += 1;
        }
        int minSize = Integer.MAX_VALUE;
        String substring = "";
        int end = 0;
        int count = 0;
        for(int start = 0; start < s.length(); start++){
            int c = s.charAt(start);
            chars[c] -= 1;
            if(chars[c] == 0){
                count += 1;
                if(count == unique){
                    while(count >= unique && end <= start){
                        if(minSize > start - end + 1){
                            minSize = start - end + 1;
                            substring = s.substring(end, start + 1);
                        }
                        int cr = s.charAt(end);
                        chars[cr] += 1;
                        if(chars[cr] == 1) {
                            count -= 1;
                        }
                        end += 1;
                    }
                }
            }
        }
        return substring;
    }
}
