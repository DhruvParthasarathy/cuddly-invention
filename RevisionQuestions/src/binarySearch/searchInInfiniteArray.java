package binarySearch;

public class searchInInfiniteArray {

	public static void main(String[] args) {
	
		/*
		 * We have an infinite sorted array
		 * We have to find if a given element is part of that infinite sorted array
		 * */
		
		int[] infArray = 
			{
				-1, 0, 1, 
				5, 6, 10, 
				13, 14, 21, 
				25, 30, 45, 
				65, 75, 80, 
				100, 200, 300, 
				400, 500, 600, 
				700, 800, 900, 
				1000, 1001, 1002, 
				1003, 1004, 1005, 
				1006, 1007, 1008
			};
		
		
		int target = 13;
		
		System.out.println(searchInf(infArray, target));

	}
	
	static int searchInf(int[] arr, int target) {

		
		/**
		 * We have an array for which there is no length
		 * So what we can do is we can keep increasing the search space till we find the element
		 * 
		 * Questions: How do we know if we have searched all the elements ? 
		 * We cannot, so then will the function run for ever ? 
		 * 
		 * But since this is a sorted, array, there will definitely be a range of numbers in between 
		 * which the number has to either be present or not present.
		 * 
		 * So I think one key here is to find that range
		 */
		
		int[] range = range(arr, target);
		
		/**
		 * Now that we have identified the range in which the element could lie, 
		 * we can run a binary search within that range and search for the element there
		 */
		
		return binSearchRange(arr, target, range[0], range[1]);
	}
	
	static int binSearchRange(int[] arr, int target, int start, int end) {
		int index = -1;
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(target == arr[mid]) {
				return mid;
			}
			else if(target < arr[mid]) {
				end = mid -1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return index;
	}
	
	static int[] range(int[] arr, int target) {
			
		
		/**
		 * Here our task will be to keep progressing the search space till we find a window within which
		 * the number could possibly lie
		 */
		
		int start = 0;
		int length = (int) Math.pow(2, 0);
		int end = start + length;
		
		/**
		 * We have a start and end position here that is just the first element
		 * 
		 * We check if this range does not include the element
		 * 
		 * till it does not we keep increasing the search space length and keep moving forward
		 * 
		 * if it does then we stop
		 */
		
		while(arr[start] < target && arr[end] < target) {
			start = end + 1;
			end = start + length*2;
		}
		
		/**
		 * When the above while loop is exited, we are in a region that holds the target element 
		 */
		
		return new int[] {start, end};
		
		
	}

}
