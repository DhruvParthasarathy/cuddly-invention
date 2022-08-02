package sortingUsingRecursion;

public class QuickSortRecursion {

	public static void main(String[] args) {
		
		int[] usortedArray = {0, 1, 0, 2, 4 ,5, 7, 1, 2, 5, 7, 9, 23, 644, 756, 2888, -2123, -4634, 656, -123};
		quickSort(usortedArray, 0, usortedArray.length- 1 );

	}
	
	static void quickSort(int[] arr, int start, int end) {
		
		// Quick sort logic
		// We ensure all elements towards the left are lesser than the pivot
		// and all elements on the right are greater than the pivot
		
		int lo = start, hi = end;
		int mid = lo + (hi-lo)/2;
		
		int pivot = arr[mid];
		
		while(lo < hi) {
			// while the elements on the left are lesser than the pivot we keep moving forward
			while(arr[lo] < pivot) {
				lo++;
			}
			
			while(arr[hi] > pivot) {
				hi--;
			}
			
			if(arr[lo] > pivot && arr[hi] < pivot) {
				// we have encountered a position where the elements need to be swapped
				// the element on the left is greate than the pivot and the elem on the right is lesser
				swap(arr,lo, hi);
			}
		}
		
		// 

		
		
	}
	
	static void swap(int[] arr, int ind1, int ind2) {
		int temp = arr[ind2];
		arr[ind2] = arr[ind1];
		arr[ind1] = temp;
	}

}
