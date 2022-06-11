package useCaseBasedSorting;

import java.util.Arrays;

public class CyclicSort {

	public static void main(String[] args) {
		
		int[] numsInRange = {9,2,4,1,6,7,3,5,8,10};
		
		cyclicSort(numsInRange);
		
		System.out.println(Arrays.toString(numsInRange));
		
		
	}

	static void cyclicSort(int[] numsInRange) {
		/***
		 * Cyclic sort is run in specific use cases where we have 
		 * a range of numbers from 1 until n
		 * 
		 * This algorithm has a linear time complexity 
		 * even in the worst case
		 * 
		 * Since the elements in the array are in a range, 
		 * we use the property that 
		 * value = index + 1 to perform the sort
		 */
		
		// We do not run a continuously incrementing loop
		int i = 0;
		while(i < numsInRange.length) {
			
			int el = numsInRange[i];
			
			// check if the element at index i is at the right position
			if(el == i + 1) {
				i++;
			}
			else {
				// swap it with the element at el - 1;
				int temp = numsInRange[el-1];
				numsInRange[el-1] = el;
				numsInRange[i] = temp;
			}
		}
		
	}
	
	

}
