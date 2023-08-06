package SlidingWindow;

public class MinimumWindowAllCharacter {

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
}
