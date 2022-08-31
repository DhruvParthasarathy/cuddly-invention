package recursionWithStrings;

import java.util.ArrayList;
import java.util.List;

public class SubSetQuestions {

	public static void main(String[] args) {
		
		
		/**
		 * SUBSET PATTERN Very important concept
		 * When we work with subsets, we will either be adding elements or
		 * removing elements that are in the same order as present in the original list
		 */

//		printSubSets("","12345");
		
		printSubSetsIteration("1223");
	}
	
	/**
	 * Given a string print all the possible subsets for this string while maintaining the 
	 * relative order of the characters in it
	 */
	static void printSubSets(String subsetString, String input) {
		
		if(input.isEmpty()) {
			System.out.println("Out: "+ subsetString);
			return;
		}
		
		// to print the subsets, we run a recursive call, and we use the Subset pattern
		// this pattern says that in every combination either take the character or reject the 
		// character. Each of this combination will lead to another branch in the recursion tree
		
		// we do one call for taking the character and another call for ignoring the character
		
		// taking the character
		printSubSets(subsetString+input.charAt(0), input.substring(1));
		
		// not taking the character
		printSubSets(subsetString, input.substring(1));
		
		
		
		
	}

	static void printSubSetsIteration(String input) {
		
		// given an input string print out all the subsets it can have iteratively
		List<String> outPutList = new ArrayList<String>(); // in every iteration we will refer to the elements in this list
		
		// only for the first element, we have a case where we either accept or reject the element
		// the other elements we have to just create combinations by accepting the current element
		
		outPutList.add("");
		// only add if element already not present
		if(!outPutList.contains(input.charAt(0)+"")) {
			outPutList.add(input.charAt(0)+"");
		}
		

		
		for(int i = 1; i < input.length(); i ++) { // O(n)
			// setting up an iterative loop, where we manipulate the output array using the current element
			int len = outPutList.size();
			for(int j = 0; j < len; j++) { // O(2^n)
				// for every char in the input string we can either include it or reject it
				// eg: "123" , the first sub set can be "", the second subset can be "1"
				// here we make 2 elements by inluding 1 or excluding one
				
				// adding an element by including the current element
				// add only if list does not already contain the same element
				if(!outPutList.contains(outPutList.get(j)+input.charAt(i))) {
					outPutList.add( outPutList.get(j)+input.charAt(i));
				}
				
			}
		}
		System.out.println(outPutList.toString());
		
		// O(n * 2^n)
	}
	

}
