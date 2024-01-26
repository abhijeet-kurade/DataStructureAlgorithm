package Backtracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Repeating {
    public static void main(String[] args) {
        String num = String.valueOf(245);
        System.out.println(num);
    }

    public static List<List<String>> solveNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] forwardDiagonals = new boolean[2*n-1];
        boolean[] backwardDiagonals = new boolean[2*n-1];
        List<List<String>> solutions = new ArrayList<>();
        solveNQueens(0, solutions, new ArrayList<>(), cols, forwardDiagonals, backwardDiagonals);
        return solutions;
    }

    public static void solveNQueens(int row, List<List<String>> solutions, List<String> curr,
                                    boolean[] cols, boolean[] forwardDiagonals, boolean[] backwardDiagonals){

        if(row == cols.length){
            solutions.add(new ArrayList<>(curr));
            return;
        }
        for(int col=0; col<cols.length; col++){
            if(canPlaceQueen(row, col, cols, forwardDiagonals, backwardDiagonals)){
                queenMove(row, col, cols, forwardDiagonals, backwardDiagonals, curr, true);
                solveNQueens(row+1, solutions, curr, cols, forwardDiagonals, backwardDiagonals);
                queenMove(row, col, cols, forwardDiagonals, backwardDiagonals, curr, false);
            }
        }

    }

    public static boolean canPlaceQueen(int row, int col,
                                        boolean[]cols, boolean[]forwardDiagonals,
                                        boolean[]backwardDiagonals){

        return !cols[col] && !forwardDiagonals[row+col] && !backwardDiagonals[col + cols.length - row];

    }

    public static void queenMove(int row, int col,
                                 boolean[]cols, boolean[]forwardDiagonals,
                                 boolean[]backwardDiagonals,
                                 List<String> curr, boolean whatToDo){

        cols[col] = whatToDo;
        forwardDiagonals[row+col] = whatToDo;
        backwardDiagonals[col + cols.length - row] = whatToDo;
        StringBuilder str = new StringBuilder();

        if(whatToDo){
            for(int i=0; i<cols.length; i++){
                if(i == col) str.append('Q');
                else str.append('.');
            }
            curr.add(str.toString());
        }
        else{
            curr.remove(curr.size()-1);
        }

    }


}
