package String;

import java.util.*;

public class SortStringObjectClass {
    class Word {
        String str1;
        String str;

        public Word(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            this.str1 = String.valueOf(chars);
            this.str = str;
        }

        @Override
        public String toString() {
            return "{"  + this.str1 + ":" + this.str +"} " ;
        }
    }
    public void sortStringObjectClass(){
        List<Word> words = new ArrayList<>();
        String[] strs = new String[]{"zx", "xza", "abk", "kba", "obj", "jbo", "object", "jectob", "bak"};

        for (String str : strs) words.add( new Word(str));

        Collections.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int lim= Math.min(o1.str1.length(), o2.str1.length());
                int k=0;
                while(k<lim) {
                    if(o1.str1.charAt(k) != o2.str1.charAt(k)) {
                        return (int) o1.str1.charAt(k) - o2.str1.charAt(k);
                    }
                    k++;
                }
                return o1.str1.length() - o2.str1.length();
            }
        });

        for(Word word : words) System.out.print( word.toString() );



    }

}
