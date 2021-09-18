package arrays;

import java.util.Arrays;

public class ReversingArray {

	/**
	 * Write a method to reverse the given elements in an array
	 * Using a 2 pointer method
	 * 
	 * 2 pointer method means we use 2 index values to keep track of array value positions
	 */
	public static void main(String[] args) {

		
		// array with even elements
		int[] arrayEven = {1,2,3,4,5,6,7,8};
		
		// array with odd elements
		int[] arrayOdd = {1,2,3,4,5,6,7,8, 9};
		
		System.out.println(reverse(arrayEven)); 
		// expect [8,7,6,5,4,3,2,1] // output [8, 7, 6, 5, 4, 3, 2, 1]
		
		System.out.println(reverse(arrayOdd)); 
		// expect [9, 8,7,6,5,4,3,2,1] // output [9, 8, 7, 6, 5, 4, 3, 2, 1]
	}
	
	static String reverse(int[] array ) {
		
		// Example we have an array [1,2,3,4,5,6,7] 
		
		// we initialize a start and an end index
		int start = 0, end = array.length - 1 ;  // start = 0, end = 6 
		
		// We run a loop where we swap the values start and the end index
		while(start <= end) {  // we end the loop if start >= end index
			
			// we increment the start index and decrement the end index after each swap
			swap(array, start++, end--);
			
		}
		
		return Arrays.toString(array);
	}
	
	static void swap(int[] array, int index1, int index2) {
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
