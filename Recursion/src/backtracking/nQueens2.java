package backTracking;

public class nQueens2 {

    public static void main(String[] args) {
        // solve the n queens problems bro

        /**
         * We have a grid and we need to find all possible locations where we can
         * place n queens. A queen is a chess queen piece
         */

        // for simplicity we take a square grid
        int grid = 4; // 3x3 grid here

        int queens = 4; //  want to place 2 queens

        System.out.println(tryPlacingQueens(grid, queens));
    }

    static int tryPlacingQueens(int grid, int queens){

        /**
         * We need a boolean grid to mark all the locations we have placed the queen till now
         */

        boolean[][] gridMatrix = new boolean[grid][grid];

        int possibilities = 0;

        for(int i = 0; i < gridMatrix.length; i++){
            possibilities += startPlacingQueens(gridMatrix, queens, 0, i);
        }



        return possibilities;
    }


    static int startPlacingQueens(boolean[][] matrix, int queens, int placed,  int rowIndex){

        // if we have crossed all the rows,
        // we have to return
        if(rowIndex == matrix.length){
            // we have crossed the board

            // if all queens have been placed, we have found one answer
            if(placed == queens){
                display(matrix, 'Q');
                return 1;
            } else {
                return 0;
            }
        }

        if(placed == queens){
            display(matrix, 'Q');
            return 1;
        }
        // we place queens row wise
        // keeping track of how many placements we can do
        int count = 0;

        // for this row, we have a for loop
        for(int i = 0; i < matrix[rowIndex].length; i++){

            // for each cell we can spin up a recursive tree

            // check if we can place in this cell
            if(checkIfPlacementAllowed(matrix, rowIndex, i)){

                matrix[rowIndex][i] = true;

                // spin up a recursive tree for this cell
                count += startPlacingQueens(matrix, queens, placed + 1, rowIndex+1);

                matrix[rowIndex][i] = false;

            }

        }

        return count;

    }

    static void display(boolean[][] matrix, char ch) {
        // here we iterate through the matrix and print it
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j]){
                    System.out.print(ch+" ");
                } else {
                    System.out.print("_ ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean checkIfPlacementAllowed(boolean[][] matrix, int cellRow, int cellCol ){
        // given a cell we need to see if a queen can be placed in this cell
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

//        i = cellRow; j= cellCol;
        // cell towards bottom right
//        while(i <= matrix.length-1 && j <= matrix[i].length-1){
//            if(matrix[i][j]){
//                return false;
//            }
//            i++;
//            j++;
//        }

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
//        i = cellRow; j= cellCol;
//        while(i <= matrix.length-1  &&  j >= 0){
//            if(matrix[i][j]){
//                return false;
//            }
//            i++;
//            j--;
//        }



        return true;

    }
}
