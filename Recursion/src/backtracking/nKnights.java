package backTracking;

import javax.imageio.ImageTranscoder;

import static backTracking.nQueens2.display;

public class nKnights {
    public static void main(String[] args) {
        // place n knights on a board
        // this is a beautiful recursion based problem

        int possibilities = 0;

        int size = 3;
        int knights = 4;

        boolean [][] board = new boolean[size][size];

        findPossibilities(knights, board, 0, 0,0);


        System.out.println(possibilities);
    }

    static void findPossibilities(int numKnights, boolean [][] board, int row,  int col, int placed){


        // if we are done placing all the knights
        if(placed == numKnights){
            display(board, 'k');
            return;
        }

        // if we have crossed the board, we just return back
        if(row == board.length){
            return;
        }

        // we have more knights to place, have we reached the end of the row ?
        if(col == board[row].length){
            // we continue the op from the next line
            findPossibilities(numKnights, board, row+1, 0, placed);
        }

        // we are going to stay in the current row
        // can we place it in this cell ?
        if(placeMentAllowed(board, row, col)){
            board[row][col] = true;
            if(col+1 < board[row].length){
                // if there is space move right
                findPossibilities(numKnights, board, row, col+1, placed+1);
            } else {
                // move down
                findPossibilities(numKnights, board, row+1, 0, placed+1);
            }
            board[row][col] = false;
        } else {
            findPossibilities(numKnights, board, row, col+1, placed);
        }


    }

    private static boolean placeMentAllowed(boolean[][] board, int row, int col) {

        //if there is already a knight placed here, don't allow
        if(board[row][col]) return false;

        // check for knights that could have been placed above this,
        // as we don't have any knights plaved below

        // are there rows above this
        if(row - 2 >= 0 && col -1 >= 0 && board[row-2][col-1]) return false;
        if(row -2 >=0 && col + 1 < board[row].length && board[row-2][col+1]) return false;
        if(col - 2 >= 0 && row -1 >= 0 && board[row-1][col-2]) return false;
        if(col +2 < board[row].length && row -1 >= 0 && board[row-1][col+2]) return false;


        return true;
    }
}
