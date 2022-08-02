package patternQuestions;

public class PatternUsingRecursion {

	public static void main(String[] args) {
		
		printInvertedLeftTriangleUsingRecursion(5);
		printNormalLeftTriangleUsingRecursion(5);

	}
	
	static void printNormalLeftTriangleUsingRecursion(int rowsToPrint) {
		
		
		// Recursion exit condition
		if(rowsToPrint == 0) {
			return;
		}
		
		// FUNCTION LOGIC
		
		// Given that we start with the number of rows, but we want to print in the other order
		// we can do the printing when the function exits
		
		// call subsequent recursive calls and keep printing from the last call
		printNormalLeftTriangleUsingRecursion(rowsToPrint-1);
		
		// NON TAIL RECURSION 
		
		// DO THE PRINTING HERE
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < rowsToPrint; i++) {
			sb.append("x ");
		}
		System.out.println(sb.toString());
		sb = null;
	}
	
	static void printInvertedLeftTriangleUsingRecursion(int rows) {
		
		// Breaking condition for recursion =============
		if(rows == 0 ) {
			return;
		}
		
		// LOGIC for Every Recursive call ==============
		// first we print how many ever stars that need to be printed for this row
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < rows; i++) {
			sb.append("x ");
		}
		System.out.println(sb.toString());
		
		sb = null;
		
		// now we have printed a given row
		// we can proceed to call subsequent rows
		
		// Tail recursion ==============================
		
		printInvertedLeftTriangleUsingRecursion(rows-1);
	}

}
