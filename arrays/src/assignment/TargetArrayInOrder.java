package assignment;

import java.util.Arrays;

public class TargetArrayInOrder {

	public static void main(String[] args) {
		
		int []nums = {0,1,2,3,4}; 
		int []index = {0,1,2,2,1};
		
		System.out.println(Arrays.toString(createTargetArray(nums, index)));


	}
	
	static int[] createTargetArray(int[] nums, int[] index) {
        
        /*
        In this problem we have 2 arrays, 
        one with values that have to be inserted
        another with which index the values have to be inserted
        
        This operation involves, shifting elements in various positions
        based on the values in the index array
        
        We would be creating multiple array copy operations if we do it in the brute force approach
        
        Is there a simpler way to do this ?
        
        We can use a linked list approach to achieve this
        Using a linked list, we can break links and reattach them
        but the problem here is finding which link to break and attach, because it is not indexed
        */
        
        /*
        Constrints, 
        - minimunm 1 number in the first array
        - maximu 100 elements in the index array
        - the numbers range from 0 to + 100
        - the index array has same length at input numbers array
        - the index ,values at a given index in the index array is <= the index
        => (0 <= index[i] <= i)
        
        This means, the index value is also capped at last inex of the numbers array
        - we will not face index out of bounds exception here
        
        */
        
        /*
        going ahead with the array copy method would make it n^2 if every iteration requires
        shifting the elements
        
        but that is a brute force approach
        */
        
        
        // nums array - is the array with numbers
        // index array - is the array which tells the positions
        
        int[] output = new int[nums.length]; // same length as we are only going to move around numbers
        
        int rightMostPlaced = -1;
        
        for (int i = 0; i < index.length; i ++){
            
            // make a clear spot for adding a number at the given index
            // shift the remaining values to the right
            // we also keep track of the last placed index which is 0 initially
            
            // for clearing the spot, 
            // we take all the elements and shift it to the right
            
            if(index[i] > rightMostPlaced){
                
                // we can place it directly
                output[index[i]] = nums[i];
                rightMostPlaced = i;
            }
            else {
                // we have to shift
                // we can do an inplace shift 
                
                int temp = 0;
                int numberToPlace = nums[i];
                
                // we have to shift all the elements from the current position to the right most position
                for(int position = index[i]; position <= rightMostPlaced + 1 ; position ++){
                    // first store the number that we have
                    
                    temp = output[position];
                    output[position] = numberToPlace;
                    numberToPlace = temp;
                    
                }
                rightMostPlaced++;
            }
            
        }
        
        return output;
        
    }	

}
