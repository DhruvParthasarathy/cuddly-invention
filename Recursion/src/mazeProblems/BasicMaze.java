package mazeProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicMaze {

	public static void main(String[] args) {
		
		/**
		 * Given a NxM maze, and a start co-ordinate and an end co-ordinate,
		 * print out all the possible ways in which you can traverse from the 
		 * start to the end point
		 */
		
		// 3 rows means, the indices are 0, 1, 2. Similarly for columns.
		
//		int rows = 3;
//		int cols = 3;
		
		// the X and Y points are calculated form the top left
		int startX = 0;
		int startY = 0;
		
		// keep it below 15 so that the value stay within range of integers
		int endX = 15;
		int endY = 15;
		
		// for simplicity we assume that this is an infinite grid on the 2D plane

		/**
		 * The problem with printing all the paths buy just thinking of it as as string problem won't give the right result
		 * because it misses the business logic while considering the various permutations, hence in this type of problems
		 * we need to keep the business logic in mind before coding the solution
		 */
//		printPaths(startX, startY, endX,endY, rows, cols);
		
		// just print the number of paths available and not actually print all the paths present
//		System.out.println(pathsPresent1(startX, endX, startY, endY));
		
		
		System.out.println(pathPresent2(startX, endX, startY, endY, 0));
		
		// we make the above computation efficient further by using an additional 2D array that stores the
		// already calculated values that happen in the previous iteration,
		// this way we can avoid redundant calculations
		
		int[][]memory = new int[endX - startX + 1][endY - startY + 1];
		
		int initialCount = 0;
		
//		System.out.println(pathPresent3(startX, endX, startY, endY, initialCount, memory));
		
		
		/**
		 * Writing a function to find all the path combinations
		 * but if we use a simple recursion we will be stuck in an endless loop
		 * 
		 */
		
		
		
		
	}
	
	static int pathPresent2(int startX, int endX, int startY, int endY, int count) {
		// The problem with using factorial or just calculating the various combinations is that, we tend to have duplicates
		// present in the answer
		// Hence we try calculating the number of unique paths using recursion where we know that we can return once we have 
		// hit the right wall or the bottom extreme
		// because once we reach either edges, there is only one way to proceed, either keep going right (if we hit down wall)
		// or keep going down (if we hit the right wall)
		
		// when we have hit the left or the bottom wall we return
		if(startX == endX || startY == endY) {
			return 1;
		}
		
		// if we are not at the edges, let's proceed by seeing what other paths we can take from here
		
		// let's see how many unique paths we get if we go right from here
		int countRight = pathPresent2(startX + 1, endX, startY, endY, count);
		
		// similarly if we go down from here
		int countLeft = pathPresent2(startX, endX, startY + 1, endY, count);
		
		return count + countRight + countLeft;
		
		
	}
	
	static int pathPresent3(int startX, int endX, int startY, int endY, int count, int[][]memo) {
		// The problem with using factorial or just calculating the various combinations is that, we tend to have duplicates
		// present in the answer
		// Hence we try calculating the number of unique paths using recursion where we know that we can return once we have 
		// hit the right wall or the bottom extreme
		// because once we reach either edges, there is only one way to proceed, either keep going right (if we hit down wall)
		// or keep going down (if we hit the right wall)
		
		// when we have hit the left or the bottom wall we return
		if(startX == endX || startY == endY) {
			return 1;
		}
		
		// let's check if we already have the value for this spot in the memory
		if(memo[startX][startY]!=0) {
			return memo[startX][startY];
		}
		
		// if we are not at the edges, let's proceed by seeing what other paths we can take from here
		
		// let's see how many unique paths we get if we go right from here
		int countRight = pathPresent3(startX + 1, endX, startY, endY, count, memo);
		
		// similarly if we go down from here
		int countLeft = pathPresent3(startX, endX, startY + 1, endY, count, memo);
		
		memo[startX][startY] = count + countRight + countLeft;
		
		return memo[startX][startY];
		
		
	}
	
	
	static int pathsPresent1(int startX, int endX, int startY, int endY) {
		
		/**
		 * One way is to calculate the number of steps to the right and number of steps to reach the bottom
		 * and calculate the various combinations of those steps using premutation
		 */
		
		int x = endX - startX;
		int y = endY - startY;
		
		// in how many ways can you go x steps to the right and y steps down ?
		// it is x+y factorial ways
		
		int[] memo = new int[x+y];
		
		// but the problem here is that we need to sort of eliminate the duplicates,
		// we can't directly rely on finding the factorial here
		
		return factorial(x+y, memo);
	}
	
	static int factorial(int num, int[] memo) {
		
		if(num == 0 || num ==1) {
			return 1;
		}
		
		if(memo[num-1] != 0) {
			return num*memo[num-1];
		} else {
			memo[num-1] = factorial(num-1, memo);
			return num*memo[num-1];
		}
		

	}
	
	static void printPaths(int startX, int startY, int endX, int endY, int mazeRows, int mazeColumns) {
		
		// first we need to calculate how many cells are there in between the start and the end point
		
		// Running validation -  for later use case
		
		// finding the cells along the x axis
		// in case the start is at 0 index and the end is at 2 index, number of cells are 2 - 0
		
		int cellsRight = endX - startX;
		
		// similarly we calculate the number of cells that have to be moved down
		int cellsDown = endY - startY;
		
		/**
		 * Now that we have the number of cells that have to be moved right and down, we have to print out the combination
		 * of D and Rs where the number of Ds available are == number of down moves, and the number of Rs are the number of
		 * available right moves
		 */
		
		/**
		 * Generating the moves array
		 */
		
		Character[] movesArray = new Character[cellsRight + cellsDown];
		
		int arrayIndex = 0;
		for(int i = 0; i < cellsRight; i++) {
			movesArray[arrayIndex] = 'R';
			arrayIndex++;
		}
		
		for(int i = 0; i < cellsDown; i++) {
			movesArray[arrayIndex] = 'D';
			arrayIndex++;
		}
		
		System.out.println(Arrays.toString(movesArray));
		
		// Now that we have the moves array, all we have to do is to print the various permutations in which 
		// these elements can be arranged
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < movesArray.length; i++) {
			sb.append(movesArray[i]);
		}
		
		System.out.println(printPermutations(sb.toString())) ;
		
		sb = null;
	}
	
	
	static ArrayList<String> printPermutations(String moveElements){
		
		// this is a permutation problem, where we need to find the various combinations of the elements, and we do
		// not drop any element
		
		// we start with a processed part and an unprocessed elements
		// we have the unprocessed part in the moveElements array itself
		String processed = "";
		
		// now we need to run a recursive loop where at each iteration we try inserting each element from the
		// unprocessed section into the available spots in the processed section
		
		// we need to ensure that we do not add elements that were already added
		
		ArrayList<String> options = new ArrayList<String>();
		
		getPermutations(processed, moveElements, options);
		
		return options;
	}
	
	static void getPermutations(String processed, String unprocessed, ArrayList<String> outPutArray){
		
		if(unprocessed.isEmpty() ) {
			// HERE WE DO A CHECK TO SEE IF THIS PATH HAS ALREADY BEEN TAKEN OR NOT, 
			// THIS MEANS UNNECESSARY CALCULATIONS HAVE HAPPENED to reach this path which was not needed
			// THIS is solve better using DP
//			if(!outPutArray.contains(processed)) {
				outPutArray.add(processed);
//				}
			return;
		}
		
		// check for available white spaces in the processed array
		int len = processed.length();
		
		// available whitespaces = length + 1;
		
		// here we take <= len as we want it to be array length + 1
		for(int i = 0; i <= len; i++) {
			
			// for each gap in the array, we split the processed array and add one element from the unprocessed section
			// we use string splitting for this, we split the processed string at the ith index
			// for sub string, start is inclusive and end is exclusive
			
			String first = processed.substring(0, i);
			String second = processed.substring(i);
			
			String newProcessed =  first + unprocessed.charAt(0) + second;
			
			// now we send off a recursive call with the new processed string and a changed unprocessed string
			getPermutations(newProcessed, unprocessed.substring(1), outPutArray);
			
		}
		
		
	}

}
