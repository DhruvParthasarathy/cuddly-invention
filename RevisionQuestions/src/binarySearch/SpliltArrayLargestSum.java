package binarySearch;

public class SpliltArrayLargestSum {

	public static void main(String[] args) {
		
		/**
		 * Given an array nums which consists of non-negative integers 
		 * and an integer m, you can split the array into m non-empty 
		 * continuous subarrays.
		 * Write an algorithm to minimize the largest sum among these 
		 * m subarrays.
		 */

		/**
		 * Eg: nums = [7,2,5,10,8], m = 2
		 * Output is 18
		 * 
		 * Eg: nums = [1,2,3,4,5], m = 2
		 * Output is 9
		 * 
		 * nums = [1,4,4], m = 3
		 * Output is 4
		 */
		
		/**
		 * Constraints
		 * 
		 * Min 1 element
		 * Numbers are positive
		 * Max num of splits asked would be 50, min would be 1
		 */
		
		int[] arr = {1,2,3,4,5}; int m = 2; // 9
		
		
//		int[] arr = {7,2,5,10,8}; int m = 2; // 18
		
//		int[] arr = {1,4,4}; int m = 3; // 4
		
		System.out.println(splitArray(arr, m));
	}
	
	static int splitArray(int[] arr, int m) {
		int out = 0;
		
		/**
		 * Given an array, we have to find the optimal split where in 
		 * for a given number of splits, the max sum of elements in 
		 * each split is the lowest amongst the various combinations
		 * 
		 * We try doing this by continually pushing the max sum possible to a lower value
		 * and checking if we can achieve that in with the given number of splits
		 */
		
		int[] temp = returnMaxAndSum(arr); 
		/**
		 * For a given array, the maximum split can be = to the number of element in the array
		 * in that case the max sum of each split will be the split which has the largest number
		 * This will be the lowest value the the highest value of each sub array can have
		 */
		int low = temp[0];
		
		/**
		 * Similarly the largest value a sub array can sum up to
		 * will be when we do not split the array
		 * so the sum of all the elements will be the largest value untill 
		 * any sub array can reach
		 */
		int high = temp[1];
		

		
		out = optimizeWithinRange(arr, low, high, m);
		
		return out;
	}
	
	static int optimizeWithinRange(int[] arr, int low, int high, int allowedSplit) {
		
		/**
		 * Now that we know the start and end value the max sum can go, let's try finding 
		 * the lowest we can go for the given number of splits
		 */
		
		/**
		 * This is the core of this algorithm
		 * We try fixing values of the max sum allowed within this range 
		 * and see if we can split the array such that
		 * each sub array has elements that sum up to that max value
		 * 
		 * In each iteration we try keep going lower until we cannot go lower further
		 */
		
		/**
		 * The while loop breaks when we have achieved a value that can not be further optimized
		 */
		while(low < high) {
			
			int mid = low + (high - low)/2; // here mid refers to the sum we are trying to set
			
			/**
			 * For this given mid value, let's see if we can 
			 * fit the numbers into sub arrays and how many 
			 * sub arrays we get
			 */
			int splits = splitValue(arr, mid);
			
			if(splits <= allowedSplit) {
				/**
				 * So we have split the array into a certain number of sub arrays
				 * But the case is that we have split it into either an equal or
				 * a lesser number of splits than it is allowed
				 * 
				 * So we can maybe try to still compress the allowed cap of max sum
				 * and see if we can still maintain the level of splitting
				 */
				high = mid;
			}
			else {
				/**
				 * The number of splits we got is more than the number of splits allowed
				 * So we have to take in more elements per sub array
				 * so that we have lesser splits
				 */
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	/**
	 *
	 * @param arr - array of numbers
	 * @param cap - max value of sum the sub array can have
	 * @return numSplits - the number of splits we were able to get for this max value of sum
	 */
	static int splitValue (int[] arr, int cap) {
		int numSplits = 1;
		
		/**
		 * Let's start filling the sub arrays
		 */
		int subArraySum = 0;
		int index = 0;
		
		/**
		 * Till we have elements, in the array
		 */
		while(index < arr.length) {
			
			if(subArraySum + arr[index] <= cap) { // if adding the next element is within the max limit
				subArraySum+= arr[index];         // we add the element
				index++;                          // we increment the index 
			}
			else { 
				// adding the next element is not within the allowed limit
				// we increment the number of split and proceed to the next iteration
				numSplits++; 
				subArraySum = 0;
			}
		}
		
		return numSplits;
	}

	static int[] returnMaxAndSum(int [] arr) {
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < arr.length ; i ++) {
		
			if(arr[i] > max) {
				max = arr[i];
				
			}
			sum += arr[i];
		}
		
		return new int[] {max, sum};
	}
	
	

}
