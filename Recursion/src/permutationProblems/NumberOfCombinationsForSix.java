package permutationProblems;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCombinationsForSix {

	public static void main(String[] args) {
		
    // Given a 6 faced dice, return the various combinations in which you can achieve the target value
		ArrayList<List<Integer>> outPut = new ArrayList<List<Integer>>();
    int targetValue = 4;
    int achieved = 0;
    ArrayList<Integer> existingCombo = new ArrayList<Integer>();
    int[] options = new int[] {1,2,3,4,5,6};
		numberCombinations(achieved, targetValue, existingCombo, options, outPut);
		System.out.println(outPut);
	}

	
	static void numberCombinations
			(
			int achieved, 
			int target,
			List<Integer> existingCombo,
			int[] availableChoices,
			ArrayList<List<Integer>> outputList
			) 
	{
		// given a standard dice, how many possible combinations exists to get a given number
		
		// we have a target value and an achiever value at hand
		
		// once we have exhausted the target, we can return the existing combo
		if(achieved - target==0) {
			outputList.add(existingCombo);
			return;
		}
		
		// Now we have entered into the recursion loop
		// and we have a target to be exhausted and we already have an achieved number,
		// so we can try finding combinations that can help exhaust the target
		
		// we run a for loop and if the number we add keeps the 'achieved' below the target, we can take it
		
		
		for(int i = 0; i < availableChoices.length; i++) {
			
			// check if this choice keeps the achieved value <= the target
			if(achieved + availableChoices[i] <= target) {
				
				List<Integer> newCombo = new ArrayList<Integer>();
				
				newCombo.addAll(existingCombo);
				newCombo.add(availableChoices[i]);
				
				int newAchieved = achieved + availableChoices[i];
				
				// now we send this into another recursion call
				
				numberCombinations(newAchieved, target, newCombo, availableChoices, outputList);
				
				
				
			}
		}
		
		
	}
}
