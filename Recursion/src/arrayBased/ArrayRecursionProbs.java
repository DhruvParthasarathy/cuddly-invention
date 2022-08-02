package arrayBased;

import java.util.ArrayList;

public class ArrayRecursionProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {2,2,2,2,2,2,2,3};
//		System.out.println(check_sorted(array, false, 0, array.length -1));
		int target = 10;
//		System.out.println(linear_search(array, target,  -1, 0, array.length -1));
		System.out.println(linear_multiple_search(array, target,  new ArrayList<Integer>(), 0, array.length -1).toString());
	}
	
	static boolean check_sorted(int[] array, boolean isSorted, int start, int end) {
		
		// we need to check recursively if a given array is sorted or not
		// we can start checking from the start and start + 1 index if the array is sorted
		if(start == end) { // handling edge case when there is only one element in the array
			return false;
		}
		// we return once we hit the last index
		if(start == end - 1) {
			isSorted = array[start] <= array[end];
			return isSorted;
		} else {
			// we are not at the last but one index, there are some more indices to check
			// check if array is sorted at current indedx
			if(array[start]<=array[start+1]) {
				return check_sorted(array, true, start+1, end);
			} else {
				// the array is not sorted - we end the recursion here and return false all the way back up
				return false;
			}
		}
		
		
	}

	static int linear_search(int[] arr, int target, int index, int start, int end) {
		
		// in this function, we check linearly if a given element is present in the array or not
		
		// if there is only one element, just check and return the status
		if(start == end) {
			if( arr[start] == target ) {
				index = start;
			} 
			
			return index;
		} else {
			// there are more elements in the array
			if( arr[start] == target ) {
				// if we found the target
				index = start;
				return index;
			} else {
				// let's continue checking
				return linear_search(arr, target, index, start+1, end);
			}
		}
	}

	static ArrayList<Integer> linear_multiple_search(int[] arr, int target, ArrayList<Integer> indexArray, int start, int end) {

		// this is similar to the previous question, where rather than just returning a given index,
		// we return an array of indices were the element at given index == target number
		
		// if there is only one element in the array
		// we just check that and append that index to the array list and send back
		if(start == end) {
			if( arr[start] == target ) {
				indexArray.add(start);
				return indexArray;
			} else {
				return indexArray; // no index present such that elem at index == target, just return 
			}
		}
		
		else {
			// there are more elements
			if(arr[start] == target) {
				indexArray.add(start);
			}
			
			// continue searching from next index
			return linear_multiple_search(arr, target, indexArray, start+1, end);
		}
		
	}
}
