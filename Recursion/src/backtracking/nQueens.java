package backTracking;

public class nQueens {

    public static void main(String[] args) {
        /*
        The nQueens problem gives us n chess queen pieces and also gives us a n x n board

        the challenge here is to find in how many ways we can place those n queens on the board such that

        no 2 queens lie in the path of one another

        A queen can move vertically, horizontally and also diagonally

        There cannot be any row that has more than 1 queen and there cannot be a column that has more than one queen

        This question involves recursion and backtracking
         */

        boolean matrix[][] =  new boolean[3][3];
        System.out.println(findQueens(matrix, 0, 0, 0, 2, 0 ));
    }

    /**
     *
     * @param matrix - chess board with marks
     * @param row - start row value
     * @param col - start column value
     * @param queenPlaced - number of queens that have already been placed
     * @param n - the number of queens that need to be placed
     * @param count - count of possible solutions
     * @return
     */
    static int findQueens ( boolean[][] matrix, int row, int col, int queenPlaced, int n, int count) {

        // Logic is we start with one position on the first row and we keep running a recursive loop for the other
        // positions

        // when will we exit
        // if we see that we don't have any more spots available to put the required number of queens we return with count 0

        // else we have already reached a point where we have placed all the queens, we return 1

        // we will be in a position where row will  be greater than the length of the matrix

        if(queenPlaced == n){
            return 1;
        }
        // assume we have crossed the row
        if(row == matrix.length){
            // we have procesesed all rows
            // let's check the queens placed
            if(queenPlaced == n){
                return 1;
            } else {
                return 0;
            }
        }

        // we take the first row and we start a for loop where we place the queens in the following positions
        for(int i = row; i < matrix.length; i++){


            // what are we doing in each row ?

            // in each row, we check if we can place a queen in any given column

            for(int j = col ; j < matrix[i].length; j++){
                // check if we can keep a queen in this cell
                boolean okay = checkCell(matrix, i , j);


                if(okay){

                    matrix[i][j] = okay;

                    //now that we have placed a queen in this cell, we proceed to check the next row as to where we can keep
                    count += findQueens(matrix, i +1, 0, queenPlaced+1, n, count);
                    matrix[i][j] = false;
                } else {
                    // nothing just check the next iteration
                }
            }

        }
        return count;
    }

    static boolean checkCell(boolean[][] matrix, int cellRow, int cellCol){
        // we have to make the following checks,

        if(matrix[cellRow][cellCol]){
            // is there already is a queen there ?
            return false;
        }

        // is there any queen already present in the vertical file that this queen is in
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][cellCol]){
                return false;
            }
        }

        // is there any queen in the same horizontal file
        for(int j = 0; j < matrix[cellRow].length; j++){
            if(matrix[cellRow][j]){
                return false;
            }
        }

        // is there any queen in the major diagonal ( top left to bottom right )
        // check towards top left
        int i = cellRow, j= cellCol;

        // cell towards top left
        while(i >= 0 && j >= 0){

            if(matrix[i][j]){
                return false;
            }
            i--;
            j--;
        }

        i = cellRow; j= cellCol;
        // cell towards bottom right
        while(i <= matrix.length-1 && j <= matrix[i].length-1){
            if(matrix[i][j]){
                return false;
            }
            i++;
            j++;
        }

        i = cellRow; j= cellCol;
        // cell towards top right
        while(i >= 0 && j <= matrix[i].length-1){
            if(matrix[i][j]){
                return false;
            }
            i--;
            j++;
        }

        // cell towards botom left
        i = cellRow; j= cellCol;
        while(i <= matrix.length-1  &&  j >= 0){
            if(matrix[i][j]){
                return false;
            }
            i++;
            j--;
        }



        return true;
    }
}
