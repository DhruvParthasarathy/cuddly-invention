package assignment;

public class Pangram {

	public static void main(String[] args) {
		
		String sentence = "";
		
		System.out.println(isPangram(sentence));

	}

	static boolean isPangram(String sentence) {

		
		int[] freqArray = new int[(int)'z' + 1]; 
		
		for(int i = 0; i < sentence.length(); i ++ ) {
			
			freqArray[(int)sentence.charAt(i)] ++;
			
		}
		
		for(int i = 97; i < freqArray.length; i++) {
			if(freqArray[i] == 0) {
				return false;
			}
		}

		return true;
	}

}
