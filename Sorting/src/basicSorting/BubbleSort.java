package basicSorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = {5,4,3,2,1, 0, -1, -2, -3, -4, -5, -4, -6, -7, -8};
		
		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

	static void bubbleSort(int[] arr) {
		
		/**
		 * Bubble sort is a stable in-place sort
		 * 
		 * The CORE LOGIC of this sort is that in each iteration
		 * we move the largest element in the unsorted part to the end 
		 * by continuously swapping the elements next to it
		 * where it occupies it's rightful place in the unsorted section
		 * 
		 * Worst case time complexity is close to quadratic
		 * Best case is linear when the elements are already sorted
		 * 
		 * Auxiliary space required is constant, just for the temp variable
		 */
		
		/**
		 * Edge cases, when the elements are already sorted, 
		 * we will not find any sort in the first iteration.
		 * We can break the execution and return.
		 */
		
		// we run a loop through the array's length
		//we only use this i as a counter rather than 
		// for accessing the index of any element in the array
		for(int i = 0; i < arr.length ; i ++) {
			boolean swapped = false;
			
			// we run a loop only on the unsorted section hence 
			// after each iteration of the outer loop
			// the number of iterations on the inner loop reduces
			for(int j = 1; j < arr.length -i ; j ++) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					swapped = true;
				}
			}
			
			// if no swap happened in the above iteration
			if(!swapped) {
				return;
			}
		}
		
	}

}
