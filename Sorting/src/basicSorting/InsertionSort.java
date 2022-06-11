package basicSorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int[] arr = {5,4,3,2,1, 0, -1, -2, -3, -4, -5, -4, -6, -7, -8};
//		int[] arr = {4,4,4,4,4};
//		int[] arr = {4};
//		int[] arr = {};
		
		insertionSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

	static void insertionSort(int[] arr) {
		
		/**
		 * Insertion sort is better than selection sort
		 * in the way that, in the best case situation, 
		 * the time complexity is linear 
		 * - this is a stupid thing to say
		 * because the array is already sorted
		 * 
		 * But insertion sort is used widely in 
		 * partially sorted arrays
		 * 
		 * and it is used in combination with other sorting algorithms
		 * when handling large amounts of data
		 */
		
		/**
		 * Core logic of insertion sort
		 * 
		 * We keep increasing the comparison space from the left to right
		 * by one element in each iteration
		 * 
		 * We have 2 indices
		 * 
		 * We take the right most element in the comparison space
		 * and keep swapping it with the element towards it's left
		 * as long as the element on the left is greater than the selected
		 * element we swap with it and bring it to the start point
		 * 
		 * The best case, in each iteration we always find that the 
		 * element to the left is < given element
		 * so no swap is required - linear time in best case
		 */
		
		for(int i = 0 ; i < arr.length - 1 ; i ++) {
			
			// we run this outer loop and increase 
			// the comparison space each iteration
			
			// since j start from i + 1, 
			// we limit i's value to < arr.length - 1
			
			for(int j = i + 1; j > 0 ; j-- ) {
				if(arr[j] < arr[j-1]) {
					// swap the elements
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
