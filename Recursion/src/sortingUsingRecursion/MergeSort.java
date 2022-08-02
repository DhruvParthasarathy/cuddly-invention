package sortingUsingRecursion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
//		int[] unsortedArray = {0, 1, 0, 2, 4 ,5, 7, 1, 2, 5, 7, 9, 23, 644, 756, 2888, -2123, -4634, 656, -123};
//		int[] unsortedArray = {5,4,3,2,1,0};
		int[] unsortedArray = {100, 99, 98, 1, 0, -99, -100};
		
		
		
		mergeSortRec(unsortedArray, 0, unsortedArray.length-1);
		
		System.out.println(Arrays.toString(unsortedArray));

	}
	
	static void mergeSortRec(int[] arr, int start, int end) {
		

		// Merge sort logic =========================================================
		// we keep splitting the array into finer elements and 
		// we merge the elements as we return back up through the recursive call stack
		
		if((end - start) >= 1) {
			// we split the array into 2 parts and pass it down to 
			// child recursive calls
			int mid = start + (end-start)/2;
			mergeSortRec(arr, start, mid);
			mergeSortRec(arr, mid+1, end);
			merge(arr, start, mid, end);
			
		}
		
		
	}
	
	static void merge(int[] arr, int start, int mid, int end) {
		
		// int[] mergedArray = new int[arr1.length + arr2.length];
		
		// logic for merging
		// we have 2 pointers i and j, where i points to elements in arr1 and j to elements in arr2
		int i = start; int j = mid+1; int k = start;
		
		int[] mergedArr = new int[arr.length];
		
		// while we have arr as a single array, we assume it to be 2 parts 
		// that are split at the mid index ( j )
		
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				mergedArr[k] = arr[i];
				i++;
			} else {
				mergedArr[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			mergedArr[k] = arr[i];
			i++;
			k++;
		}
		
		while(j <= end) {
			mergedArr[k] = arr[j];
			j++;
			k++;
		}
		
		while(k <= arr.length -1) {
			mergedArr[k] = arr[k++];
		}

		for(int l = start; l < k; l++) {
			arr[l] = mergedArr[l];
		}
		
	}
	
	static void swap(int[]arr, int index1, int index2) {
		int temp = arr[index2];
		arr[index2] = arr[index1];
		arr[index1] = temp; 
	}

}
