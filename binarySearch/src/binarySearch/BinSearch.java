package binarySearch;

public class BinSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayAsc = {1,2,3,4,5,6,7,8,9,10};
		int[] arrayDesc = {10,9,8,7,6,5,4,3,2,1,0};
		
		
		System.out.println(orderAgnosticBinarySearch(arrayAsc, 5)); // expect 4
		System.out.println(orderAgnosticBinarySearch(arrayDesc, 5)); // expect 5

	}
	
	// return the index of the elemement
	// return -1 if element does not exist
	static int binarySearch(int[] array , int target) {
		
		int start = 0, end = array.length -1;
		
		while(start <= end) {
			
            // int middle = ( start + end ) /2; 
			// sometimes, the value of start + end might exceed the value
			// that an integer can hold in java
			
			// better way to calculate the middle index
			int middle = start + ( (end - start) / 2);
			
			if (array[middle] == target) {
				return middle;
			}
			
			else if (target > array[middle]) {
				
				// search in right sub array
				start = middle + 1;
			}
			else {
				// target < middle element
				// search in left subarrray
				end = middle -1 ;
				
			}
		}
		
		return -1;
	}

	/**
	 * first check what order the array has been sorted in and proceed with searching
	 * @param array
	 * @param target
	 * @return
	 */
	static int orderAgnosticBinarySearch(int[] array, int target) {
				
		if(array.length == 0) {
			return -1;
		}
		
		// find the order of the array
		if(array[0] == array[array.length -1]) {
			// all elements are of the same value
			return array[0];
		}
		
		
		boolean ascending = isAscending(array);
		
		int start = 0, end = array.length -1;
		
		while(start <= end) {
			
            // int middle = ( start + end ) /2; 
			// sometimes, the value of start + end might exceed the value
			// that an integer can hold in java
			
			// better way to calculate the middle index
			int middle = start + ( (end - start) / 2);
			
			if (array[middle] == target) {
				return middle;
			}
			
			else if (target > array[middle]) {
				
				if(ascending) {
					// search in right sub array
					start = middle + 1;	
				}
				else {
					// search in left sub array
					end = middle -1 ;
				}
				
			}
			else {
				
				// target < middle element
				if(ascending) {
					// search in left subarray
					end = middle -1 ;
				}
				else {
					// search in right subarray
					start = middle + 1 ;
				}	
				
			}
			
		}
		
		
		return -1;
	}

	/**
	 * return if given sorted array is ascending or descending
	 * @param array
	 * @return
	 */
	static boolean isAscending(int[] array) {
		
		// find the order of the array
		if (array[0] > array[array.length -1 ]) {
			
			// descending order, first element is greater than the last element - decreasing order
			return  false;
		}
		else {
			
			// ascending order - first element is smaller than the last element - increasing order
			return true;
		}
	}
}
