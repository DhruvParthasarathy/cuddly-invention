package sortingUsingRecursion;

import java.util.Arrays;
import java.util.Stack;

public class SelectionSortUsingRecursion {

	public static void main(String[] args) {
		
		int[] unsortedArray = {0, 1, 0, 2, 4 ,5, 7, 1, 2, 5, 7, 9, 23, 644, 756, 2888, -2123, -4634, 656, -123};
		
		Stack<Integer> largestIndexList = new Stack<Integer>();
		largestIndexList.push(0);
		
		// trying out some memorization - needs to be redone
//		selectionSortWithRecursion(unsortedArray, unsortedArray.length -1 ,0, largestIndexList);
		
		System.out.println(Arrays.toString(unsortedArray));

	}
	
	static void selectionSortWithRecursion(int arr[], int row, int col, Stack<Integer> largestIndexList) {
		
		System.out.println(Arrays.toString(arr));
		System.out.println(largestIndexList.toString());
		
		// Breaking condition
		if(row==0) {
			return;
		}
				
		// Selection Sort Logic
		// find largest element in the array and shift it to the end element
		if(col < row) {
			// if we are at an index lesser than the last index to check
			if(arr[col] > arr[largestIndexList.peek()]) {
				largestIndexList.push(col);				
			}
			selectionSortWithRecursion(arr,row,col+1, largestIndexList);
		} else {
			// we have checked till the last element
			// swap the last element with the value in the largest elem index
			
			while(!largestIndexList.empty()) {
				// before we proceed with swapping, 
				// we check if the element that is going to be swapped, 
				// if that has to be a part of the stack as well
				
				int largestElemInStack = arr[largestIndexList.peek()];
				int smallestElemInStack = arr[largestIndexList.firstElement()];
				
				if(smallestElemInStack < arr[row] && arr[row] < largestElemInStack) {
					// we need to enter this in to the stack
					// find the smallest number in the stack that is larger than this number
					int nextInd = findIndexOfSmallestElemLargerThanGivenNum(arr, largestIndexList.toArray(), arr[row], 0, largestIndexList.size() -1);
					largestIndexList.insertElementAt(largestIndexList.pop(), nextInd);
				}
				swap(arr,row--, largestIndexList.pop());
			}
			
			
//			if(largestIndexList.peek() > 0) {
//				col = largestIndexList.peek();
//			} else {
//				col = 0;
//			}
			
			// we have completed sorting the last part of the array
			if(largestIndexList.empty()) {
				largestIndexList.push(0);
			}			
		
			selectionSortWithRecursion(arr, row, col, largestIndexList);
		}

		
		
		
	}
	
	static void swap(int[] array, int index1, int index2) {
		int temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;
	}
	
	static int findIndexOfSmallestElemLargerThanGivenNum(int[]numArr, Object[] arr, int target, int start, int end) {
		
		// we know that there is definitely an element larger than this element in the array
		
		int index = -1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(numArr[(int)arr[mid]] == target) {
				// the next immediate number is the largest number to the target
				return mid+1;
			} else if (numArr[(int)arr[mid]] > target) {
				// the location is somewhere towards the left of mid, 
				// mid could be the required index
				
				end = mid-1;
			} else {
				// value at mid is lesser than the target, we need values to the right of this mid
				start = mid + 1;
			}
		}
		
		return end;
		
		
	}

}
