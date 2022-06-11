package binarySearch;

public class SearchInRotdSortedArr {

	public static void main(String[] args) {
		
		int[] nums = {4,5,1,2,3};
		int target = 1;
		
		System.out.println(search(nums, target));

	}
	
	static int search(int[] nums, int target) {
        /*
        The array is possibly rotated at an index
        Edge case: It could not be rotated at all !!
        
        0 indexed array - index starts from 0
        
        Check which index the target is in
        
        O(log n) runtime complexity
        */
        
        
        /*
        - Minimum 1 element in the array
        - Negative numbers can be present
        - All unique values
        - Ascending order
        - The target could be a negative number
        */
        
        /*
        If there is only 1 element
        */
        if(nums.length == 1){
            if(nums[0] == target) return 0;
            else return -1;
        }
        
        else{
            /*There are more than 1 elements*/
            
            
            /*Check if the array is rotated or not*/
            
            boolean rotated = false;
            
            if(nums[0] > nums[nums.length-1]) rotated = true;
            
            
            if(!rotated){
                
                /*This array is not rotated, run a simple binary search*/
                return binSearch(nums, target, 0 , nums.length -1);
            }
            else {
                
                /*This is a rotated array, we need to first find the pivot index*/
                int pivot = findPivot(nums);
                
                if(target == nums[pivot]){
                    return pivot;
                }
                else if (target >= nums[0]){
                	/**
                	 * No value is greater than the pivot
                	 * 
                	 * but some values are greater than the first element ( before pivot )
                	 * 
                	 * remaining are lesser ( after pivot )
                	 */
                    return binSearch(nums, target, 0, pivot );
                }
                else {
                    return binSearch(nums, target, pivot + 1 , nums.length -1 );
                }
            }
        }
	}

	static int binSearch(int[] arr, int target, int start, int end){
        
        int index = -1;
        
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            
            if(target == arr[mid]){
                return mid;
            }
            else if (target < arr[mid]){
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
            
            
        }
        
        return index;
    }

	static int findPivot(int[] arr){
        

        /*
        We will have a minimum of 2 elements
        Since this is an ascending array
        the pivot element is the element after which
        the numbers are smaller
        Eg: [2,1]
        Eg: [1,2,3,4,5,6,7,0]. Here 7 is the pivot element
        Eg: [7, 1, 2, 3, 4, 5, 6] here also 7 is the pivot
        */
        
        /*
        We see here that the pivot element could be towards the left 
        towards the right or even the middle element
        */
        
        int start = 0; int end = arr.length -1; 
        
        while(start <= end){
            
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid+1] || arr[mid-1] > arr[mid]) {
                return mid;
            }
            else if (arr[mid] > arr[0] ){
                /*
                [1,2,3,4,5,6,7,0]
                pivot is towards the right*/ 
                start = mid + 1;
            }
            else {
                /*
                [7, 1, 2, 3, 4, 5, 6] - pivot towards the left
                arr[mid] < arr[0]
                */
                end = mid -1;
            }
            
        }
        
        return -1;

    }
}
