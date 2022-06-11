package matrixSearch;

public class ReducingSearchSpace2 {

	public static void main(String[] args) {
		
		/**
		 * Here, given a matrix that is continuously sorted 
		 * write an algorithm to reduce the search space and 
		 * search for a given target value
		 */
		
		int[][] mat = 
			{
					{1,2,3},
					{4,5,6},
					{7,8,9},
					{10,11,12}
			};
		
		int target = 6;

		int[] output = search(mat, target);
		System.out.printf("%s, %s",output[0], output[1]);
	}
	
	static int[] search(int[][] mat, int target) {
		
		/**
		 * Logic: here we know that the matrix will be sorted continuously 
		 * as in the example given in the main method
		 * 
		 * So if we take any element, if the target is less than that given element,
		 * we can ignore the rows below
		 * 
		 * if the target, is greater than the given element,
		 * we can ignore the rows above
		 * 
		 * Finally we will be left with 2 rows,
		 * in this situation, we can check the end element of each row
		 * and then further eliminate the rows
		 * 
		 * and finally when we have a single row we can run a binary search on that row and get the answer
		 */
		
		/**
		 * To start with we take the middle column and the middle row
		 */
		
		int rStart = 0, cStart = 0, rEnd = mat.length-1, cEnd = mat[0].length-1;
		
		
		/**
		 * EDGE cases:
		 * 1. the matrix has a single row
		 */
		
		if(rStart == rEnd) {

			return searchRow(mat, rStart, target);
		}
		else {
			/**
			 * Till we end up with 2 rows, we run our logic
			 */
			
			int cMid = cStart + (cEnd - cStart)/2;
			
			
			/**
			 * If we have more than 2 rows
			 * Let's try taking the middle column and check which rows to eliminate
			 */
			while(rStart < rEnd -1 ) {
				
				int rMid = rStart + (rEnd - rStart)/2;
				
				if(target == mat[rMid][cMid]) {
					return new int[]{rMid,cMid};
				}
				else if (target < mat[rMid][cMid]) {
					/**
					 * Value is less that the given, value, 
					 * ignore the rows after
					 */
					rEnd = rMid;
				}
				else {
					/**
					 * target is greater than the given value,
					 * ignore the rows before
					 */
					rStart = rMid;
				}

			}
			
			/**
			 * Now that we only have 2 rows,
			 * Write logic to check end elements
			 * we keep the last element of the top row as the mark
			 */
			int mark = mat[rStart][cEnd];
			
			if(target == mark) {
				return new int[]{rStart, cEnd};
			}
			else if (mark < target) {
				// run binary search in the next row
				return searchRow(mat, rStart + 1, target);
			}
			else {
				// run binary search in the same row
				return searchRow(mat, rStart, target);
			}
			
			
		}
		
	}
	
	static int[] searchRow(int[][] mat, int row, int target) {
		
		
		/**
		 * Since we know the row that we are going to search for, that would be fixed,
		 * but the column value would change
		 */
		
		int[] arr = mat[row];
		
		int start = 0; int end = arr.length -1;
		
		while(start <= end ) {
			
			int mid = start + (end - start)/2;
			
			if(target == arr[mid]) {
				return new int[] {row,mid};
			}
			else if (target < arr[mid]) {
				end = mid -1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return new int[]{-1,-1};
	}

}
