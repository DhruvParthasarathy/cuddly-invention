package linearSearch;

public class LinearSearch {

	public static void main(String[] args) {
		
		int[] nums = {23,45,1,2,8,19,-3,-11,28};
		
		int target = 10;
		
		System.out.println(linearSearch(nums, target)); // returns -1
		
		System.out.println(linearSearchRange(nums, 19, 1, 4)); // returns -1

	}
	
	/**
	 * Search in the array
	 * 
	 * return the index if item found
	 * otherwise return -1
	 */
	static int linearSearch(int[] arr, int target) {
		
		// check edge cases
		if(arr.length == 0 || arr == null) {
			return -1;
		}
		
		// run a for loop
		for (int index = 0 ; index < arr.length; index ++) {
			if(arr[index] == target) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Search in range
	 */
	static int linearSearchRange(int[] arr, int target, int start, int end) {
		
		// check edge cases
		if(arr.length == 0 || arr == null) {
			return -1;
		}
		
		// run a for loop
		for (int index = start ; index <= end; index ++) {
			if(arr[index] == target) {
				return index;
			}
		}
		return -1;
	}
}
