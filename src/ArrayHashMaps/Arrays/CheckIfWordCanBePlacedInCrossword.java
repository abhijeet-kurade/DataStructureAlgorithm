package ArrayHashMaps.Arrays;

//https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/

import java.util.Collections;
import java.util.List;

public class CheckIfWordCanBePlacedInCrossword {
    public static void main(String[] args) {
        int[] arr = {20, 10, 30};
    }


    public static int minCost(List<Integer> arr){
        Collections.sort(arr);
        int totalSum = 0;
        int sum = arr.get(0);
        for(int i=1; i<arr.size(); i++){
            sum += arr.get(i);
            totalSum += sum;
        }
        return totalSum;
    }


    public static String getMinStr(String input_str){
        StringBuilder str = new StringBuilder(input_str);
        char next ;
        for(int i=0; i<str.length(); i++){
        }
        return "";
    }
    public static boolean placeWordInCrossword(char[][] board, String word) {
        int height = board.length, width=board[0].length;
        int n = word.length();
        for(int row=0; row<height; row++){
            for(int col=0; col<width; col++){
                //top
                if(row+1>=n){
                    int idx = row;
                    for(int i=0; i<n;i++){
                        char c = word.charAt(i);
                        if(!isValid(board, idx, col, c)) break;
                        idx-=1;
                        if(i==n-1) return true;
                    }
                }
                //bottom
                if(height-row>=n){
                    int idx = row;
                    for(int i=0; i<n;i++){
                        char c = word.charAt(i);
                        if(!isValid(board, idx, col, c)) break;
                        idx+=1;
                        if(i==n-1) return true;
                    }
                }

                //left
                if(col+1>=n){
                    int idx = col;
                    for(int i=0; i<n;i++){
                        char c = word.charAt(i);
                        if(!isValid(board, row, idx, c)) break;
                        idx-=1;
                        if(i==n-1) return true;
                    }
                }

                //right
                if(width-col>=n){
                    int idx = col;
                    for(int i=0; i<n;i++){
                        char c = word.charAt(i);
                        if(!isValid(board, row, idx, c)) break;
                        idx+=1;
                        if(i==n-1) return true;
                    }
                }
            }
        }
        return false;


    }
    public static boolean isValid(char[][] board, int row, int col, char c){
        if(board[row][col] == '#') return false;
        return board[row][col] == c || board[row][col] ==' ';
    }
}
