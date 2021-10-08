
public class NextGreatestCharacter {

	
	public static void main(String[] args) {
		char[] letters = {'n','e','e','e','e','e','e','e','e','e'};
		
		System.out.println(nextGreatestLetter(letters, 'e'));

	}
	
	/**
	 * Constraints:
	 * 2 <= letters.length <= 104  // Array length would be at least 2 elements
	 * letters[i] is a lowercase English letter.
	 * letters is sorted in non-decreasing order.  // IMPORTANT - non-decreasing does not mean strictly ascending, there could be duplicates
	 * letters contains at least two different characters. // IMPORTANT - another clue that there could be duplicate values !!
	 * target is a lowercase English letter.
	 * 
	 * We should not return the element which is equal to the target
	 * 
	 * @param letters
	 * @param target
	 * @return the smallest character in the array that is larger than target
	 */
    static char nextGreatestLetter(char[] letters, char target) {
        
        
        // IMPORTANT NOTE:
        // READ THE CONDITIONS GIVEN IN THE QUESTION THORROUGHLY
        
        // checking for edge cases
        
        // If target lies outside the range of the characters in the array
        if (target >= letters[letters.length-1] || target < letters[0]){
            return letters[0];            
        }
        

        
        // if target lies in between the start and end character
        
        int start = 0, end = letters.length-1;
        
        while(start <= end){
            
            int middle = start + (end - start)/2;
            
            // if the target value is towards the left, search the left array
            if(target < letters[middle]){
                
                end = middle - 1;
            }
            
            // if target is greater than or equal to the middle, search the right array
            else {
                
                start = middle + 1;
            }   
     
        }
        

        // start % letters.length would return the value of index if the start index is within the range, or return 0 if the index
        // goes out of bounds
        return letters[start % letters.length];
        
    }
}
