
public class FindNumInInfiniteArray {

	public static void main(String[] args) {
		
		
		
		int length = Integer.MAX_VALUE/4;
		
		// given a sorted array of infinite length, check if a given value is in the array, if so return it's index
		int[] infArray = new int[length];
		
		for(int i = 0; i < length; i++) {
			infArray[i] = i;
		}
		
		int target = 174759457;
		
		int targetLoc = checkInRange(infArray, target);
		
		System.out.printf("Index of the element in the array is %s", targetLoc);
		
		System.gc();

	}
	
	static int checkInRange(int[] infArray, int target) {
		
		int index = -1;
		
		// we do not know the length of the array, hence we need to check in chunks
		// we try checking different windows if the element exists and if so we proceed with searching the range
		int rangeSize  = 2;
		int start = 0;
		int end = start + rangeSize -1;
		
		
		// while the target value lies outside the range, we move the window further ahead
		while(target > infArray[end]) {
			start = end + 1;
			rangeSize *= 2; // to quickly converge at the solution, we exponentially increase the window size
			end = start + rangeSize - 1;
		}
		
		// once we have arrived at the given range to check , we can just call a binary search function
		// for the given array and the target element within that range
		// here the start and end value would be that which would contain the targetValue
		index = binarySearch(infArray, target, start, end);

		
		// -1 indicates that the element does not exist in the array
		return index;
	}
	
	
	static int binarySearch(int[] array , int target, int start, int end) {
		
		System.out.println();
		
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

}
