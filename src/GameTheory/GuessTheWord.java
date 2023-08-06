package GameTheory;

//https://leetcode.com/problems/guess-the-word/

import java.util.*;
import java.util.List;

public class GuessTheWord {
    int matchNumber(String s1, String s2){
        int n= s1.length();
        int matches = 0;
        for(int i=0; i<n; i++){
            if(s1.charAt(i) == s2.charAt(i)) matches += 1;
        }
        return matches;
    }

    public static void main(String[] args) {
        String[] words = {"abcdef","acdefg","adefgh","aefghi","afghij","aghijk","ahijkl","aijklm",
                "ajklmn","aklmno","almnoz","anopqr","axcdef"};

    }
    static String guessWord(String[] words){
        int n = words.length;
        int[][] count = new int[n][26];

        for(int i=0; i<n; i++){
            for(int j=0; j<6; j++){
                int c = words[i].charAt(j) - 'a';
                count[i][c] += 1;
            }
//            for(int k=0; k<26; k++) System.out.print(count[i][k]+ " ");
////            System.out.println();
        }

        int best = Integer.MIN_VALUE;
        String guess = "";

        for(int i=0; i<n; i++){
            String word = words[i];
            int score = 0;
            for(int j=0; j<6; j++){
                int c = words[i].charAt(j) - 'a';
                score += count[i][c];
            }
            if(score > best){
                best = score;
                guess = word;
            }
        }

        return guess;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        for(int i=0; i<10; i++){
            String guess = guessWord(wordlist);
            System.out.println(guess);
            int matchWithSecrete =  master.guess(guess);

            if(matchWithSecrete == 6) return;
            List<String> wordList = new ArrayList<>();
            for(String word : wordlist){
                if(word == guess) continue;
                int match = matchNumber(guess, word);
                if(match == matchWithSecrete) wordList.add(word);
            }
            wordlist = wordList.toArray(new String[0]);
        }
    }

    interface Master {
        public int guess(String word);
    }
}

class Solution {
    interface Master {
        public int guess(String word);
    }
    int counter = 0;
    int matchNumber(String s1, String s2){
        int n= s1.length();
        int matches = 0;
        for(int i=0; i<n; i++){
            if(s1.charAt(i) == s2.charAt(i)) matches += 1;
        }
        return matches;
    }
    public void findSecretWord(String[] wordlist, Master master) {
        int n = wordlist.length;
        List<String> wordList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MIN_VALUE;
        String minString = "";
        for(int i=0; i<n; i++){
            map.put(wordlist[i], 0);
            for(int j=0; j<n; j++){
                int match = matchNumber(wordlist[i], wordlist[j]);
                if(match == 0) {
                    map.put(wordlist[i], map.get(wordlist[i])+1);
                }
            }
            if(min <= map.get(wordlist[i])){
                min = map.get(wordlist[i]);
                minString = wordlist[i];
            }
        }
        int matchWithSecrete =  master.guess(minString);

        if(matchWithSecrete == 6) return;
        for(String word : wordlist){
            int match = matchNumber(minString, word);
            if(match == matchWithSecrete) wordList.add(word);
        }
        String[] newWords = new String[wordList.size()];
        int idx = 0;
        for(String word : wordList) newWords[idx++] = word;
        findSecretWord(newWords, master);
    }
}