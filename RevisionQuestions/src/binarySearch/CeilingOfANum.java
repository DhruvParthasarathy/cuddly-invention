package binarySearch;

public class CeilingOfANum {

	public static void main(String[] args) {
		
		/*To find the smallest number in the ascending sorted array 
		 * greater than the given target number*/
		
		int[] inputArray = {-41,-13,-5,-1,0,5,8,10,20,60, 100};
		
		int target = 0;
		
		System.out.println(ceiling(inputArray, target));
		

	}
	
	public static int ceiling(int[] arr, int target) {
		
		int ceiling = 0;
		
		/*For ceiling what do we have to do ? We need to go throug the array and 
		 * find the spot where all the numbers to the left are lesser than the given number
		 * The first number on the right will be the ceiling*/
		
		/*Edge cases: 
		 * The target is lesser than all the number in the array*/
		
		if(target < arr[0]) {
			return arr[0];
		}
		
		/*Edge case: If the target is greater than all the elements in the array 
		 * Return max value of int*/
		else if(target > arr[arr.length - 1]) {
			return Integer.MAX_VALUE;
		}
		
		/*Regular case - the number lies within the range of numbers present in the array*/
		else {
			
			/* We need to find the first number that is greater than or equal to the target number*/
			
			ceiling = binSearchCeil(arr, target);
		}
		
		return ceiling;
	}
	
	public static int binSearchCeil(int[] arr, int target) {
		
		int ceil = 0;
		
		int start = 0;
		int end = arr.length - 1;
		
		// the number lies within the range with edges inclusive
		
		while(start < end) {
			
			int mid = start + (end - start)/2;
			
			/*If the number in the mid is equal to the target*/
			
			if(target == arr[mid]) {
				return arr[mid];
			}
			else if (target > arr[mid]) {
				/*The value we are interested in is no longer in the left half*/
				start = mid + 1;
			}
			else {
				/*If the number is less than mid value
				 * mid value could be the ceiling*/
				end = mid;
				
			}
			
		}
		
		ceil = arr[start];
		
		
		return ceil;
		
	}

}
