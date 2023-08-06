package DynamicProgramming;

//https://leetcode.com/problems/text-justification/

import java.util.ArrayList;
import java.util.List;

public class TextJustification1 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        return null;

    }
    public static List<String> fullJustifyDP(String[] words, int maxWidth){
        int n = words.length;
        final int MAX = Integer.MAX_VALUE;
        int[][] sqr = new int[n][n];

        for(int i=0; i<n; i++){
            int curr = 0;
            for(int j=i; j<n; j++){
                curr += words[j].length();
                if(curr + (j-i) <= maxWidth){
                    int leftSpace = maxWidth - (curr + (j-i));
                    sqr[i][j] = leftSpace * leftSpace;
                }
                else{
                    sqr[i][j] = MAX;
                }
                /*curr += words[j].length() + (j-i);
                if(curr <= maxWidth) sqr[i][j] = (maxWidth-curr)*(maxWidth-curr);
                else sqr[i][j] = MAX;*/
            }
        }

        int[] nextIdx = new int[n];
        int[] minCost = new int[n];

        for(int i=n-1; i>=0; i--){
            int index = -1;
            int val = MAX;
            for(int j=n-1; j>=i; j--){
                if(sqr[i][j] == MAX) continue;
                int curr = sqr[i][j] + ((j>=n-1) ? 0 : minCost[j+1]);
                if(val>=curr){
                    val = curr;
                    index = j+1;
                }
            }
            nextIdx[i] = index;
            minCost[i] = val;
        }

        ArrayList<ArrayList<String>> justified = new ArrayList<>();
        int idx = 0;
        while (idx<n){
            ArrayList<String> curr = new ArrayList<>();
            for(int i=idx; i<nextIdx[idx]; i++) curr.add(words[i]);
            justified.add(curr);
            idx = nextIdx[idx];
        }
        System.out.println(justified);
        List<String> strList = new ArrayList<>();
        for(ArrayList<String> l : justified){
            String line = "";
            int ln = l.size();
            for(int k=0; k<ln; k++){
                if(k == ln-1) line += l.get(k);
                else line += l.get(k)+" ";
            }
            strList.add(line);
        }
        return strList;
    }


    // https://leetcode.com/problems/text-justification/
    public static List<String> fullJustifyGreedy(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<StringBuilder> current = new ArrayList<>();
        int numOfLetters = 0;

        for(String w : words){
            StringBuilder word = new StringBuilder(w);

            // total no. of chars in current_list + total no. of chars in current word
            // + total no. of words previously (i.e. min. number of spaces between words)
            if(numOfLetters + w.length() + current.size() > maxWidth){
                // run the loop equal to number of spaces that needs to be added
                for(int i=0; i<(maxWidth-numOfLetters); i++){
                    // if there is only one element then add all spaces after it
                    if(current.size()==1) current.get(0).append(" ");
                        // else add space in round-robin way
                    else current.get(i % (current.size()-1)).append(" ");
                }
                //add to the result
                result.add(String.join("",current));

                // reset for the next line
                current = new ArrayList<>();
                numOfLetters = 0;
            }

            // current word goes in the current line
            current.add(word);
            numOfLetters += word.length();

        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", current));
        int spaces = maxWidth - lastLine.length();
        while(spaces-->0) lastLine.append(" ");

        result.add(lastLine.toString());

        return result;
    }
}
