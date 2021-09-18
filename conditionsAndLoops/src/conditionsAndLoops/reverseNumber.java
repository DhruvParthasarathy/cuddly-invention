package conditionsAndLoops;

import java.util.Scanner;

public class reverseNumber {

	/**
	 * This function takes in a number and prints the reverse of the number
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Logic
		/**
		 * we take in a number n
		 * Eg: 12345
		 * start
		 * input number
		 * initialize count = 0
		 * initialize new number
		 * Repetition
		 * [
		 * number % 10 gives the last digit
		 * 12345 % 10 = 5
		 * we reduce the number to number / 10
		 * ] 
		 * eg 0
		 * 0 % 10 = 0
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int newNumber = 0;
		
		do {
			newNumber = newNumber*10 + number%10 ;
			number /= 10;
			
		} while ( number != 0);
		
		System.out.println(newNumber);
		sc.close();
	}
}
