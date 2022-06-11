package matrixSearch;

public class ReducingSearchSpace {

	public static void main(String[] args) {
		
		/**
		 * Given a 2D matrix that is sorted row wise and column wise separately
		 * How do you reduce teh search space and find and element ?
		 */
		
		int[][] matrix = 
			{
					{10, 15, 25, 45}, 
					{13, 17, 30, 47}, 
					{16, 21, 35, 51}, 
					{24, 27, 46, 70}
			};
		
		int target = 35;
		
		int[] output = search(matrix, target);
		
		System.out.printf("%s,%s",output[0], output[1]);

	}

	static int[] search(int[][] matrix, int target) {
		
		int row = 0;
		int col = matrix.length - 1;
		
		while(row < matrix.length && col >= 0) {
			
			if(matrix[row][col] ==  target) {
				return new int[] {row,col};
			}
			else if(matrix[row][col] > target) {
				col --;
			}
			else {
				row ++;
			}
		}
		
		return new int[] {-1,-1};
	}

}
