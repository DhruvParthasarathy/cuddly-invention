package binarySearch;

public class FloorOfANumber {

	public static void main(String[] args) {
		
		
		int[] inputArray = {-41,-13,-5,-1,0,5,8,10,20,60, 100};
		
		int target = 200;		
		
		System.out.println(floor(inputArray, target));
	}
	
	static int floor(int[] arr, int target) {
		int floor = 0;
		
		/**
		 * To find the floor of a number, we have to find the biggest number lesser than
		 * or equal to the target number 
		 */
		
		/**
		 * Edge case : If the target is less than the smallest elment in the array
		 */
		if(target < arr[0]) {
			return Integer.MIN_VALUE;
		}
		
		else if (target > arr[arr.length-1]) {
			/**
			 * If the target is greater than the greatest number in the array
			 */
			return arr[arr.length-1];
		}
		else {
			/**
			 * This number lies somewhere in between the numbers present in the array 
			 * start and end values included
			 */
			floor = findFloorBinSearch(arr, target);
			
		}
		
		return floor;
	}
	
	static int findFloorBinSearch(int[] arr, int target) {
		
		/**
		 * Floor is the biggest number lesser than or equal to the given number
		 */
		int floor = 0;
		
		int start = 0;
		int end = arr.length-1;
		
		while(start <=  end) {
			
			int mid = start + (end - start)/2;
			
			if(target == arr[mid]) {
				return arr[mid];
			}
			else if (target < arr[mid]) {
				/**
				 * Eg: 1, 3, 4 and we have to find floor of 2
				 * 
				 * If the target, is lesser than the mid, then none of the numbers
				 * greater and equal to mid can be the floor
				 */
				end = mid -1 ;
			}
			else {
				/**
				 * When target > mid
				 * Here Eg, 1 , 2, 4 and we have to find the floor of 3
				 * 
				 * Mid could be the floor, So we move start to mid + 1 ,
				 * but when the while loop's rule get's violated, 
				 * we return the element at the end index
				 */
				start = mid + 1;
			}
			
			
		}
		
		floor = arr[end];
		
		return floor;
	}

}
