package conditionsAndLoops;

import java.util.Scanner;


// Given a integer, find the nuber of times a particular digit occurs in that number
public class findOccurance {
	
	public static void main(String[] args) {
		

		// loigc 
		/**
		 * When we divide any number by 10, the reminder is the last digit of that number
		 * 
		 * Eg: 12234 // here we see that the number 2 occurs twice
		 * 
		 * start
		 * 
		 * Repetitive step till the number is 0
		 * [
		 * divide num by 10 // 12234 % 10 ( 1223 , 4 )
		 * get modulo
		 * if modulo == target => increment counter
		 * ]
		 * 
		 * reduce the number
		 * integer division by 10
		 * 
		 * edge cases : 
		 * 	find number of 0 in 0
		 * 	
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// number input by the user
		int number = sc.nextInt();
		int checkFor = sc.nextInt();
		int count = 0;
		
		int temp = number;
		
		do {
			int num = temp / 10;
			int rem = temp % 10;
			
			if(rem == checkFor) {
				count ++;
			}
			
			temp = num;
		} 
		while(temp != 0);
		
		System.out.printf("%s has appeared %s times in the number %s", checkFor, count, number);
		
		sc.close();
		
	}

}
