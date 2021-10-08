
public class CeilingOfANum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbersAsc = {1,3,5,7,9,11,13,19,23,29,31};
		
		int target = 20;
		System.out.println(ceiling(numbersAsc, target));

	}

	static int ceiling(int[] numbersAsc, int target) {
		
		// checking for edge cases
		
		// if target is lesser than all elements in the array
		
		// this works well for finding the celing, 
		// but for finding the floor, we will have to handle what if the the 
		// target is < smallest element in the array case separately
		if (target <= numbersAsc[0]) {
			return numbersAsc[0];
			
		}
		// if target is equal to the greatest number in the array
		else if (target == numbersAsc[numbersAsc.length -1 ]) {
			return numbersAsc[numbersAsc.length -1 ];
			
		}
		// if target is greater than all elements in the array
		else if (target > numbersAsc[numbersAsc.length -1 ]) {
			return Integer.MAX_VALUE;
		}
		else {
			// if target is in between the range of elements in the array
			return binarySearchCeil(numbersAsc,target);
		}
	}

	private static int binarySearchCeil(int[] numbersAsc, int target) {

		int start = 0, end = numbersAsc.length-1;
		
		// condition to stop the while loop
		while(start<=end) {
			int middle = start + (end - start)/2;
			
			// move to right array if target is > middle element
			if(target > numbersAsc[middle]) {
				start = middle+1;
			}
			
			// move to left array if target value is < middle elemtns
			else if(target < numbersAsc[middle]) {

				end = middle-1;
			}
			
			// if in case number present in array , return the number
			else if(target == numbersAsc[middle]) {
				return numbersAsc[middle];
			}
		}

		// when we finally arrive at a single element in the array ( start becomes > end)
		// return the number at the current index
		
		// the given target number is not in the array, but the next largest number is the one
		// at the current start index
		// for ceiling, we return the element at start index, for floor of a number, we return the 
		// element at the end index
		
		// when the element is not found and the above while loop is violated, 
		// start will be = end + 1 ( start would be ahead of end )
		// hence for ceiling we use the element at start index and element at end index for floor
		return numbersAsc[start];
		
		
		
		
	}

}
