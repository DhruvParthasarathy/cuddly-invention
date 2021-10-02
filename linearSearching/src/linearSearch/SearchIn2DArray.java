package linearSearch;

import java.util.Scanner;

public class SearchIn2DArray {
	
	public static void main(String[] args) {
		
		int[][] arr = {{1,2,3}, {4,5,6,10, 15, 18}, {7}};
		
		System.out.print("Enter the number to search for in the 2D array: ");
		
		Scanner sc = new Scanner(System.in);
		
		int target = sc.nextInt();
		
		int[] position = findPosition(arr, target);
		System.out.printf("The target number is at the following position in the 2d array: \nRow: %s\nCol: %s", position[0], position[1]);
		
		sc.close();
	}

	private static int[] findPosition(int[][] arr, int target) {
		

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == target) {
					return new int[] {i+1,j+1};
				}
			}
		}
		return new int[]{-1,-1};
	}

}
