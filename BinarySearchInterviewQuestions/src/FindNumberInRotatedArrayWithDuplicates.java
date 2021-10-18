
public class FindNumberInRotatedArrayWithDuplicates {

	public static void main(String[] args) {
		
		// could be just 1 element in the array

//		int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}; // expect: 13 , true
//		 int[] arr = {6,6,7,8,1,1,2,2,3,4,5,6}; // expect: 3, true 
//		 int[] arr = {2,5,6,0,0,1,2}; // expect: 2 , tru
//		 int[] arr = {1,0,1,1,1}; // expect: 0, false
//		 int[] arr = {2,9,2,2,2}; // expect: 1, true
//		 int[] arr = {5,6,7,8}; // expect -1, false
//		 int[] arr = {1,1,1,1,1,2,1}; // expect: 5, true
//		int[] arr = {6,6,7,8,1,1,2,2,3,4,5,6}; // expect : 3, true
//		int[] arr = {2,5,6,0,0,1,2}; // expect: 2, true
		 int[] arr = {1,1}; // expect -1, false
		
		
		int target = 2;
		
		if(arr.length == 1) {
			if(target == arr[0]) {
				System.out.println(true);
			}
			else {
				System.out.println(false);
			}
		}
		
		// else go ahead and check if there is a pivot
		int pivot = findPivotWithDup(arr);

				
		System.out.println(findPivotWithDup(arr));
		
		int index;
		if(pivot == -1) {
			// no rotation
			index = binSearch(arr, target, 0, arr.length -1);
			
		}
		else {
			index = binSearch(arr, target, 0, pivot);
			
			if(index == -1) {
				index = binSearch(arr, target, pivot + 1, arr.length -1);
			}
		}
		
		if(index == -1) {
			System.out.println(false);
		}
		else System.out.println(true);
	}
	
	static int findPivotWithDup(int[] arr) {
		
		// pivot is the number post which we have a number lesser than it.
		
		int s = 0, e = arr.length -1;
		
		while(s <= e) {
			
			int m = s + (e-s)/2;
			
			// check if middle element is pivot
			if(m < e && arr[m] > arr[m+1]) {
				return m;
			}
			
			// check if middle - 1 element is pivot
			if(m > s && arr[m-1] > arr[m]) {
				return m-1;
			}
			
			if(arr[s] == arr[m] && arr[m] == arr[e]) {
				
				// check if start is not pivot
				if(arr[s] > arr[s+1]) {
					return s;
				}
				
				s++;
				
				// check if end is not pivot
				if(arr[e-1] > arr[e]) {
					return e-1;
				}
				
				e--;
			}
			else if(arr[s] > arr[m]) {
				e = m;
			}
			else {
				s = m + 1;
			}
			
			
		}

		
		return -1;
	}
	


	static int binSearch(int[] arr, int target, int start, int end) {
		
		// array sorted ascending
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				return mid;
			}
			
			else if(arr[mid] > target) {
				end = mid -1;
			}
			else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
