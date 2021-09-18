/**
 * 
 */
package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dhruv
 *
 */
public class MultiDimensionalArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * 2D Arrays
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 * 
		 * Syntax
		 * datatype[][] variableName = new dataType[value of dim 1][value of dim 2]
		 * 
		 * mentioning value of dim 1 is mandatory but not so for the other dimensions
		 * as the individual sizes of each array can change within the n-d array
		 * 
		 */
	
		int[][] twoDArray = new int[5][]; // here we have defined an array without mentioning the second dimension
		
		int[][] test2D = {{},{}, {}};
		
		// printing the arrays within arrays will again give the reference to it and not the value stored inside it
//		System.out.println(test2D[0]); // [I@2a139a55
//		System.out.println(test2D[1]); // [I@15db9742
//		System.out.println(test2D[2]); // [I@6d06d69c
				
		int[][][] threeDArray ; // declaring a new variable
		
		threeDArray = new int[1][][]; // initializing the value of the variable 
		
		int[][][][] fourDArray = new int[2][][][]; // no idea how this can be represented
		
		
		/**
		 * Taking input for an array
		 */

		int[][] newArray = new int[3][3];
		
		Scanner sc = new Scanner(System.in);
		
		/**
		 * Basic way of taking input for an array
		 */
		System.out.println("Enter the 9 integers of the array: ");
		// iterating for all rows
		for(int row = 0 ; row < newArray.length; row++) { 
			
			// iterating over each column of the
			for( int col = 0 ; col < newArray[row].length; col ++ ) {
				
				newArray[row][col] = sc.nextInt();
			}
		}
		
		/**
		 * Printing the array
		 */
		for(int row = 0 ; row < newArray.length; row++) { 
			for( int col = 0 ; col < newArray[row].length; col ++ ) {
				System.out.print(newArray[row][col] + " ");
			}
			System.out.println();
		}
		
		/**
		 * Smart 'for loop'
		 */
		System.out.println();
		System.out.println("Printing array with smart for loop");
		for( int[] row : newArray) {
			for(int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		
		/**
		 * To string method
		 */
		System.out.println();
		System.out.println("Printing array with to string method");
		for( int[] row : newArray) {
			System.out.println(Arrays.toString(row));
			
		}
		
	}

}
