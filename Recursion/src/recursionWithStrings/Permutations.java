package recursionWithStrings;

public class Permutations {

	public static void main(String[] args) {
		
		/**
		 * Permutation refers to using the same number of characters and 
		 * coming up with different ordering of the characters
		 * 
		 * While in the subset method we either selected or dropped the characters, here
		 * we do not drop any character
		 */
		
		printPermutations("","1000");

	}
	
	static void printPermutations(String output, String input) {
		
		/**
		 * In every permutation call, we keep picking the first letter
		 * from the part that is yet to be processed and call subsequent function calls
		 * recursively by positioning this letter in all available positions
		 */
		
		/**
		 * We end the call when we no longer have letters to process
		 */
		if(input.length()==0) {
			System.out.println("Output: "+output);
			return;
		}
		
		/**
		 * When we have letters remaining to be processed,
		 * we run a for loop to place it in the different available positions in the 
		 * processed part
		 */
		// we pick the first character that is yet to be processed
		Character ch = input.charAt(0);
					
		for(int i = 0; i <= output.length(); i++) {
			
			// substring method start index is inclusive
			// end index is exclusive
			
			// here at every iteration, we leave a gap at the ith index and
			// we fill it in with the character
			String first = output.substring(0, i);  // start inclusive, end exclusive
			String second = output.substring(i);
			
			// now that we have split the string into 2 parts that split at the index
			// we insert the char at that index
			
			String combined = first + ch + second;
			
			// now we proceed by calling the subsequent recursive calls to process the 
			// other remaining characters, we omit the current processed character
			// in subsequent recursive calls
			
			printPermutations(combined, input.substring(1));
			
		}
	}

}
