package stringPatterns;

public class Patterns {

	public static void main(String[] args) {
		
		
		/**
		 * Steps to solve pattern problems
		 * 
		 * Step 1. Run the outer for loop for n times where n is the number of rows
		 * Step 2. Run the inner for loop for k times were k is the number of cols for row i
		 * 			Figure out the equation for each row based on conditions
		 *          Figure out what type of elements are printed in each col of a row
		 * Step 3. Create a new line after each row's iteration
		 */

		pattern31(4);
	}
	
	/**
	 * #1. For a given number n, print the following pattern
	 * 	*****
	    *****
	    *****
	    *****
	    *****
	 * @param number
	 */
	static void pattern1(int number) {
		char[] elements = new char[]{'*'};
		// step 1.
		for (int i = 1; i <= number; i++) {
			
			// step 2.
			for (int j = 1; j <= number ; j++) {
				
				// step 3.
				System.out.print(elements[0]);
			}
			
			// step 4.
			System.out.println();
		}
	}

	/**
	 * #2. For a given number n, print the following pattern
	 * 	*
	    **
	    ***
	    ****
	    *****
	 * @param number
	 */
	static void pattern2(int number) {
		char[] elements = new char[]{'*'};
		// step 1.
		for (int i = 1; i <= number; i++) {
			
			// step 2.
			for (int j = 1; j <= i ; j++) {
				
				// step 3.
				System.out.print(elements[0]);
			}
			
			// step 4.
			System.out.println();
		}
	}
	
	/**
	 * #3. For a given number n, print the following pattern
	 * 	*****
	    ****
	    ***
	    **
	    *
	 * @param number
	 */
	static void pattern3(int number) {
		char[] elements = new char[]{'*'};
		// step 1.
		for (int i = 0; i < number; i++) {
			
			// step 2.
			for (int j = 1; j <= number - i ; j++) {
				
				// step 3.
				System.out.print(elements[0]);
			}
			
			// step 4.
			System.out.println();
		}
	}
	
	/**
	 * #4. For a given number n, print the following pattern
		1
	    1 2
	    1 2 3
	    1 2 3 4
	    1 2 3 4 5
	 * @param number
	 */
	static void pattern4(int number) {
		
		// step 1.
		for (int i = 1; i <= number; i++) {
			
			// step 2.
			for (int j = 1; j <= i ; j++) {
				
				// step 3.
				System.out.print(j + " ");
			}
			
			// step 4.
			System.out.println();
		}
	}
	
	/**
	 * #5. For a given number n, print the following pattern
	    *
	    **
	    ***
	    ****
	    *****
	    ****
	    ***
	    **
	    *
	 * @param number
	 */
	static void pattern5(int number) {
		char[] elements = new char[] {'*'};
		// step 1.
		for (int i = 1; i <= (2*number)-1; i++) {
			
			// step 2.
				if(i <= ((2*number)) / 2) {
					for (int j = 1; j <= i ; j++) {
						
						// step 3.
						System.out.print(elements[0]);
					}
				} else {
					for (int j = 1; j <= ((2*number)) - i ; j++) {
						
						// step 3.
						System.out.print(elements[0]);
					}
				}

			
			// step 4.
			System.out.println();
		}
	}

	/**
	 * #6. For a given number n, print the following pattern
	 		 *
	        **
	       ***
	      ****
	     *****
	 * @param number
	 */
	static void pattern6(int n) {
		char[] elements = new char[] {'*'};
		// step 1.
		for (int i = 1; i <= n; i++) {
			
			// step 2.
			// For each row, we have n - i spaces and i stars	
				for (int j = 1; j <= n - i ; j++) {
					
					// step 3.
					System.out.print(" ");
				}
				for(int j = 1; j <= i; j++) {
					System.out.print(elements[0]);
				}
				
			// step 4.
			System.out.println();
		}
	}


	/**
	 * #28. For a given number n, print the following pattern
         *
        * *
       * * *
      * * * *
     * * * * *
      * * * *
       * * *
        * *
         *
	 * @param number
	 */
	static void pattern28(int n) {
//		char[] elements = new char[] {'*', ' '};
		// step 1.
		for (int rowNum = 1; rowNum <= 2*n -1; rowNum++) {
			
			// step 2.
			// for the first n rows, we print an increasing sequence
			/**
			 * For row 1, (n - 1) spaces, 1 start and (n - 1) spaces
			 * For row 2, we have (n-2) spaces, 2 start and (n - 2) spaces
			 * For row 9 - same as row 1
			 * Maybe we can use a modulus operator here
			 * Math.abs(n - rowNum) for spaces
			 * 
			 * 
			 * What do we do for the start
			 * For row 1- 5 we can have stars as == row number
			 * From row 6 - 9, we need to have a decreasing row number
			 * Row 3 = 3 stars ( 5 - 2 ) => 5 - (|5 - 3|)
			 * Row 4 = 4 stars ( 5 -1  )
			 * Row 6 = 4 stars ( 5 - 1 )
			 * Row 7 = 3 stars ( 5 - 2 ) => 5 - |5 - 7|
			 */
			for(int col = 1 ; col <= Math.abs(n - rowNum); col++) {
				System.out.print(" ");
			}
			for(int col = 1; col <= n - Math.abs(n -rowNum); col++) {
				System.out.print("* ");
			}
// Spaces after the stars are not required			
//			for(int col = 1 ; col <= Math.abs(n - rowNum); col++) {
//				System.out.print(" ");
//			}
				
			// step 4.
			System.out.println();
		}
	}

	/**
	 * #30. For a given number n, print the following pattern
		            1
		          2 1 2
		        3 2 1 2 3
		      4 3 2 1 2 3 4
		    5 4 3 2 1 2 3 4 5
	 * @param number
	 */
	static void pattern30(int number) {
		
		// step 1.
		for (int rowNum = 1; rowNum <= number; rowNum++) {
			
			// step 2.
			/**
			 * To find the number of cols for each row
			 * First we need to print spaces
			 * Then we need to print some numbers
			 * Row 1 - 8 spaces
			 * Row 2 - 6 spaces
			 * Row 3 - 4 spaces (5 - rowNum) * 2 spaces
			 * Row 4 - 2 spaces (5 - 4) * 2 spaces
			 * Row 5 - 0 spaces (5 - 5) * 2 spaces 
			 */
			
			/**
			 * Finding number of spaces per row
			 * nSpace = (n - rowNum) * 2 
			 */
			for (int col = 1; col <= (number - rowNum)*2; col++) {
				System.out.print(" ");
			}
			
			/**
			 * For every row, the numbers are printed from row number till 1
			 * Then they start from 2 till the row number
			 */
			for(int col = rowNum; col >= 1; col--) {
				System.out.print(col + " ");
			}
			for(int col = 2; col <= rowNum; col++) {
				System.out.print(col + " ");
			}
			// step 4.
			System.out.println();
		}
	}

	/**
	 * #17. 
	 * 17.      
	 *1    1
      2   212
      3  32123
      4 4321234
      5  32123
      6   212
      7    1
	 */
	static void pattern17(int n) {
		
		// step1. run outer loop 2n -1 times
		for(int row = 1; row <= 2*n -1 ; row ++) {
			
			// Step 2 
			// SPACES
			// we have Math.abs(n-row) space for each row
			for(int s = 1; s <= Math.abs(n-row); s++) {
				System.out.print(' ');
			}
			
			// NUMBERS
			// first half till row == n, we have an increasing sequence
			if(row <= n) {
				// we have numbers from row->1 and 2 -> row
				for(int c = row; c>=1; c--) {
					System.out.print(c);
				}
				
				for(int c = 2; c<=row; c++) {
					System.out.print(c);
				}
				
				
			}
			
			// second half from row = n+1 till 2n-1, we have a decreasing sequence
			else {
				
				// we have numbers from 2n-row -> 1 then 2 till 2n-row
				for(int c = 2*n - row; c>=1; c--) {
					System.out.print(c);
				}
				
				for(int c = 2; c<=2*n -row; c++) {
					System.out.print(c);
				}
			}
			// step 3 - add a line after each row
			System.out.println();
		}
	}
	
	/**
	 * #31 
	 * 31.      
	 * 1   4 4 4 4 4 4 4  
       2   4 3 3 3 3 3 4   
       3   4 3 2 2 2 3 4   
       4   4 3 2 1 2 3 4   
       5   4 3 2 2 2 3 4   
       6   4 3 3 3 3 3 4   
       7   4 4 4 4 4 4 4 
	 */
	static void pattern31(int n) {
		
		// outer loop runs 2n-1 times
		
		int rs = 1, re = 2*n -1, cs = 1, ce = 2*n -1;
		
		for(int r = rs; r<= re; r++) {
			
			// in each row, we have different numbers
			// row 1 has one number that is 4
			// row 7 has 1 number that is 4
			
			int num = 0;
			// any given number at a given position is
			// based on how far away it is from the edge
			// the value of the number is dependent upon the 
			// minimum distance from any edge
			
			int dt = r-rs, db = re-r;
			
			for(int c = cs; c <= ce ; c++) {
				
				int dl = c - cs, dr = ce - c;
				num = Math.min(Math.min(dt,  db), Math.min(dr,  dl));
				System.out.print(n -num + " ");
			}
			
			// new line
			System.out.println();
		}
	}
	
}
