package basicSorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = {5,4,3,2,1, 0, -1, -2, -3, -4, -5, -4, -6, -7, -8};
//		int[] arr = {4,4,4,4,4};
//		int[] arr = {4};
//		int[] arr = {};
		
		selectionSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

	static void selectionSort(int[] arr) {
		/**
		 * Selection sort CORE LOGIC:
		 * 
		 * The logic here is that we 
		 * maintain a sorted section to the right
		 * 
		 * And in each iteration, we modify the unsorted section
		 * identify the max element in the un-sorted section 
		 * and swap it with the last element in the un-sorted section
		 * 
		 * This is an unstable sort as we 
		 * swap elements that are far apart
		 * 
		 * Since in every iteration we have to find the max element 
		 * we anyways have to do a linear number of comparisons
		 * 
		 * And since we do this n times, 
		 * even in the best case it would be O (n^2)
		 * 
		 * 
		 * Auxiliary space requirement is constant, 
		 * temp variable, the max value and the max index
		 */
		
		// Running an outer loop
		for(int i = 0; i < arr.length; i++) {
			
			// for each iteration, we compare the unsorted section
			// unsorted section is from 0 till n - 1 - ith index of the array
			
			// write code to find the max element in the unsorted section
			/* NOTE: Here we are not able to know if the array is already sorted or not
			 * Because we are trying to find the max element , 
			 * and until we parse through the unsorted section
			 * we cannot get to know the largest element
			 * 
			*/
			int max = Integer.MIN_VALUE;
			int maxIndex = 0;
			for(int j = 0; j < arr.length - i; j++) {
				
				if(arr[j] > max) {
					max = arr[j];
					maxIndex = j;
				}
				
			}
			
			// swap the max element with the last element in the unsorted section
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[arr.length-i - 1];
			arr[arr.length-1-i] = temp;
		}
		
	}

}
