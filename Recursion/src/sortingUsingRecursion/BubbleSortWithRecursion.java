package sortingUsingRecursion;

import java.util.Arrays;

public class BubbleSortWithRecursion {

	public static void main(String[] args) {
		
		int[] usortedArray = {0, 1, 0, 2, 4 ,5, 7, 1, 2, 5, 7, 9, 23, 644, 756, 2888, -2123, -4634, 656, -123};
		
//		bubbleSortUsingRecursion(usortedArray, usortedArray.length-1);
		
		// IN the below implementation we notice that there are unnecessary iterations that happen
		// when we repeatedly iterate thruogh the array
		// what if we find the index of the previous largest number and store it whenever we do the bubble sort
		// that was in subsequent iterations we can directly start from that value

		bubbleSortRecursionShortedCode(usortedArray,usortedArray.length-1, 0, 0);
		
		System.out.println(Arrays.toString(usortedArray));
	}
	
	static void bubbleSortUsingRecursion(int[] unsortedArray, int endIndexToStopComparison) {
		
		// In bubble sort we run through the various iterations till we see that we are at the last index that has been sorted
		// so we need an variable to keep track of the index as well: startIndexForComparison
		
		if(endIndexToStopComparison == 0) {
			System.out.println(Arrays.toString(unsortedArray));
			return;
		}
		
		// ABOVE LINE IS THE EXIT CONDITION FOR RECURSION
		
		
		// FUNCTION LOGIC
		
		// We run a while loop to keep swapping the elements till we have sorted the entire array
		int i = 0;
		while( i < endIndexToStopComparison ) {
			
			// check if he element at given index is greater than next element
			if(unsortedArray[i] > unsortedArray[i+1]) {
				swap(unsortedArray, i, i +1);
			}

			// we have performed the check and swapped if needed
			// we proceed to check the next set
			i++;
			
		}
		
		// We have sorted the last part of the array
		
		bubbleSortUsingRecursion(unsortedArray, endIndexToStopComparison-1);
	}
	
	static void swap(int[] array, int index1, int index2) {
		int temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;
	}

	static void bubbleSortRecursionShortedCode(int[] arr, int row, int col, int prevLargestNumIndex) {
		
		System.out.println(Arrays.toString(arr));

 		if(row == 0) {return;}
		
		// function logic
		
//		if(prevLargestNumIndex > 0) {
//			col = prevLargestNumIndex;
//		}
		
		if(col < row) {
			if(arr[col] > arr[col+1]) {
				
				//swap 
				swap(arr, col, col+1);
				
				// optimization for iterations
//				if(prevLargestNumIndex >= 0 && arr[col] > arr[prevLargestNumIndex]) {
//					prevLargestNumIndex = col;
//				}

			}

			bubbleSortRecursionShortedCode(arr, row, col+1, prevLargestNumIndex);
		} else {
			prevLargestNumIndex = -1;
			bubbleSortRecursionShortedCode(arr, row-1, 0, prevLargestNumIndex);
		}
	}
}
