package numberSystem;

import java.util.HashMap;
import java.util.Map;

public class NumberProblemsUsingBitOps {

	public static void main(String[] args) {
		
//		findIfEven(2290);
//		
//		int[] nums = {3,4,7,5,7,4,17,5,17};
//		
//		System.out.println(findNumberAppearingOnce3(nums));
		
//		System.out.println(5^15);
		
//		findIthBit(8, 1);
		
//		setTheIthBit(8, 1);
		
//		resetIthBit(8, 4);
		
//		positionOfRightMostSetBit(1024);
		
//		findNegativeOfNum(5000);
//		
//		int[] nums = {1,1,1,2,2,2,3,3,3,4,5,5,5};
		
//		findNumberAppearingOnce4(nums, 3);
		
//		findSumOfnThRowPascal(0);
		
//		findIfPowerOfTwoOrNot(1024);
		
//		findIfPowerOfTwoOrNot2(2);
		
//		findNthPowerOfNum(2, 3);
		
//		findNumSetBits(1024);
		
		findXorFrom0ToA(1000035);
		
		findXorFromAtoB(3, 7);

	}
	
	

	private static void findXorFromAtoB(int a, int b) {

		/*
		 * In another question we were asked to find the XOR from 0 till A
		 * 
		 * We noticed that we were able to find certain conditions if satisfied, 
		 * we could directly get the result
		 * 
		 * Here we need not find from 0, but from a till b
		 */
		
		/*
		 * The suggested way is to find the XOR from 0 till B, and then XOR 
		 * it with the XOR from 0 till B
		 * 
		 * Because x XOR x is 0. 
		 * 
		 * Since XOR from 0 till B also contains the XOR frmo 0 till A
		 * 
		 * if we XOR the result of XOR from 0 till B with the result of XOR from 0 till A, 
		 * we will get the value of XOR from A till B
		 * 
		 * XOR(A till B) = [XOR(0 till A)]XOR[XOR(0 till B)]
		 */
		
		/**
		 * While implementing once we have XOR from 0 till B, XOR it with
		 * 0 till a - 1, since we need the value of XOR from A till B
		 * We must not exclude the A from the final result
		 */
	}



	private static void findXorFrom0ToA(int a) {
		
		/**
		 * In this function, given a number we need to find the 
		 * XOR of all numbers from 0 till the given number
		 * 
		 * Number   XOR from 0 till N
		 * 0        0
		 * 1        1
		 * 2        3
		 * 3        0
		 * 4		4
		 * 5		1
		 * 6		7
		 * 7		0
		 * 8		8
		 * 9		1
		 * 10		11
		 * 11		0
		 * 12		12
		 * 13		1
		 * 14		15
		 * 15		0
		 * 16		16		
		 */
		
		/**
		 * We see that the series tends to have a pattern
		 * If a number is a multiple of 4, it retains the same value
		 * If it is 1 less than a multiple of 4, it is == 0
		 * Of it is 1 greater than a multiple of 4, it is 1, else 
		 * it is the number + 1
		 */
		
		/**
		 * How do we check if a number is a multiple of 4
		 * Use a mod operator
		 */
		
		if(a%4 == 0 ) {
			System.out.println(a);
		}
		else if ((a+1)%4 == 0) {
			System.out.println(0);
		}
		else if ((a-1)%4 == 0 ) {
			System.out.println(1);
		}
		else {
			System.out.println(a+1);
		}
		
	}



	private static void findNumSetBits(int n) {
		

		/**
		 * Given a number n how do we find the number of
		 * set bits in this number
		 * 
		 * By brute force approach, we can iterate through the bits
		 * and if we encounter a set bit we can increment the counter
		 * 
		 * One another way is to perform n = n&(n-1) till n > 0 
		 * 
		 * This way we will not have to iterate through all the bits
		 * but rather only till this number becomes 0
		 * 
		 * Eg: 7 in binary is 0111, 6 is 0110
		 * 
		 * If we do 7 & 6, we will get 0110 -> 0110 & 0101 -> 0100 & 0011 -> 0
		 * 
		 * We notice that we have reached 0 in 3 steps, hence there were 3 set bits in 7
		 */
		int count = 0;
		while(n >0) {
			n &= (n-1);
			count ++;
		}
		
		System.out.println(count);
		
		
	}

	private static void findNthPowerOfNum(int i, int j) {
		
		/**
		 * In this question we need to find the Nth power
		 * of a number without using the existing formula
		 * in the Math library
		 */
		
		/**
		 * One other way to find it is to multiply the number
		 * n times, and that would be an O(n) time complexity
		 * algorithm and if the value of the power keeps increasing, 
		 * the algorithm slows down linearly
		 */
		
		/**
		 * Unable to understand the explanation he is giving
		 * https://youtu.be/fzip9Aml6og?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=6402
		 */
		
		
		
	}

	private static void findIfPowerOfTwoOrNot2(int i) {
		
		/**
		 * In this we are going to use the properties of 
		 * binary numbers to figure out if a given number is
		 * a power of 2 or not
		 * 
		 * We know that all powers of two will have only 
		 * 1 set bit
		 * 
		 * Eg: 10000, 10, 100, 1000...00
		 * 
		 * If this is the case, then this number -1 will be
		 * all 1s
		 * 
		 * Eg: 2 is 1 0 in binary
		 * 2 - 1 = 1 is 1 in binary
		 * 
		 * 
		 * 4 is 100 in binary
		 * 4 -1 = 3 is 1 1 in binary
		 * 
		 * 8 is 1 0 0 0 in binary, 7 is 1 1 1 in binary
		 * 
		 * So if we do n & (n-1) this will result in 0 if 
		 * n is a power of 2
		 */
		
		if(i <= 0 ) {
			System.out.println("0 is not a power of 2");
		}
		else if((i&(i-1)) == 0) {
			System.out.println("Power of two");
		}
		else {
			System.out.println("Not a power of 2");
		}
		
	}

	private static void findIfPowerOfTwoOrNot(int num) {
		
		if(num <= 0 ) {
			System.out.println(false);
		}
		
		int setBitsCount = 0;
		
		while(num > 0) {
			if((num & 1) == 1) {
				// LSB is 1
				setBitsCount ++;
			}
			num >>= 1;
		}
		
		if(setBitsCount == 1) {
			System.out.println("Power of 2");
		}
		else {
			System.out.println("Not a power of 2");
		}
		
	}

	private static void findSumOfnThRowPascal(int n) {
		
		/**
		 * A pascal's triangle is as follows
		 * 1  
		   1 1 
		   1 2 1 
		   1 3 3 1 
		   1 4 6 4 1 
		   1 5 10 10 5 1 
		 */
		
		/**
		 * The numbers in row n start from nC0 and are present till nCn
		 * 
		 * Row index starts from 0
		 * 
		 * Example: 3rd index row ( 4th row from top )
		 * 3C0 = 3! / (3-0)! * (0!) = 3! / 3! = 1
		 * 3C1 = 3! / (3-1)! * (1!) = 3! / (2! * 1!) = 3
		 * 3C2 = 3C(3-2) = 3C1 = 3
		 * 3C0 = 3C(3-0) = 3C3 = 1
		 * 
		 * Therefore the numbers in the 3rd row are 1, 3, 3, 1
		 * Sum of numbers in n'th row is 2^n
		 */
		
		System.out.println(1 << n);
	
		
	}

	private static void findNumberAppearingOnce4(int[] nums, int freq) {
		
		/**
		 * We have an array of numbers, out of which each number,
		 * appears i number of times, 
		 * 
		 * we need to find the number that appears only once
		 */
		
		/**
		 * As a brute force appoach we can use a dictionary
		 * as a frequency counter
		 */
		/**
		 * For numbers that appeared even number of times, we were able to
		 * perform the xor operator and get the number
		 * that appeared only once
		 * but when numbers appear odd number of times, 
		 * XOR will not help us isolate the number appearing only once
		 */
		
		/**
		 * Here we are going to use a different approach
		 * We list out all the numbers and we sort of create another
		 * data structure that stores the frequency of the set bits 
		 * that appear across all numbers
		 * 
		 * Eg: if the numbers are [1 1 , 1 0 , 1 1, 0 1, 1 0] (binary)
		 * This data structure tells us that, 
		 * the 0th bit was set in 3 of the numbers
		 * the 1st bit was set in the 4 of the numbers, etc.
		 * 
		 * We know that each number appears twice, so we take the 
		 * modulus of this freuency at each bit by 2
		 * 
		 * Frequency at each bit : 4 , 3
		 * Modulus by 2 gives : 0 and 1
		 * 
		 * Therefore the extra number that did not appear 2 times is
		 * 0 1
		 */
		
		// int[] nums, int freq
		
		// the challenge here is to find an optimal way to 
		// generate that array of frequency at each index
		
		
	}

	private static void findNegativeOfNum(int num) {
		
		/**
		 * To find the negative of a number, 
		 * we take the compliment of the number 
		 * and add 1 to it
		 */
		
		System.out.println(~num + 1);
		
	}

	private static void positionOfRightMostSetBit(int num) {
		
		/**
		 * Finding the position of the right most set bit
		 * 
		 * a set bit means 1
		 * 
		 * We can do this by checking the LSB if it is 1
		 * if not right shifting the number
		 */
		
		int position = 0;
		do {
			if((num & 1) == 1) {
				System.out.println(position);
				break;
			}
			else {
				num >>= 1;
				position++;
			}
		} while(num >= 0);
		
		
	}

	private static void resetIthBit(int num, int i) {
		/**
		 * Resetting a bit means, setting the value of the bit to 0
		 * 
		 * We can reset a bit to 0, but 'and'ing it with 0
		 */
		
		int mask = ~(1 << (i-1));
		
		
		int resetValue = num & mask;
		
		System.out.println(resetValue);
	}
	
	private static void setTheIthBit(int num, int i) {
		
		/**
		 * Setting a bit, means setting it's value to 1
		 * 
		 * If it is 1, it remains one, if it is 0, it is set to 1
		 * 
		 * We can use the OR operation in this case, with a mask
		 * 
		 * If we need to set the 3rd bit, we create a mask 
		 * 1 0 0
		 * 
		 * If the number is 1 0 0 0 , and we need to set the 3rd bit here
		 * 
		 * we can do 1 0 0 0 (OR) 0 1 0 0 .
		 * 
		 * Through boolean logic, this will result in 1 1 0 0.
		 * 
		 * If the 3rd bit is already 1, it will still remain as 1
		 */
		
		
		// to get the mask , we shift the value 1 to the left , i -1 times
		int mask = 1 << (i-1);
		
		int setValue = num | mask;
		
		System.out.println(setValue);
		
	}

	private static void findIthBit(int num, int i) {
		
		/**
		 * Given a number, find the ith bit of the number
		 * from the right
		 * 
		 *              i: 7 6 5 4 3 2 1       
		 * binary notation 1 0 0 1 1 1 0
		 * 
		 * If we need to find the 1st but, we can right shift it 
		 * (i -1) times
		 * 
		 * If we need to find the 3rd bit, we right shift it 2 times
		 * 
		 * and we xor it with 1. 
		 * 
		 * If the LSB ^ 1 gives 0, then the LSB is 1, else it is 0.
		 */
		
		int ithBit = num >> (i-1);
		
		if((ithBit ^ 1) == 0) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
		
	}

	private static int findNumberAppearingOnce3(int[] nums) {
		
		/**
		 * Here we are going to use an interesting property of 
		 * bitwise operators
		 * 
		 * num ^ num gives 0 
		 * num ^ 0 gives the number back
		 * 
		 * Also while using a string of bitwise operators,
		 * the order does not matter
		 * 
		 * a^b^c^d == d^b^c^a == any order of these 4 numbers
		 * 
		 * So in our situation, since we have pairs of numbers, 
		 * when we xor them with each other, we will be getting 0
		 * 
		 * but since there is one number that does not have a pair
		 * and xor of all the other number gives 0, 
		 * 
		 * when we xor this number with the resulting 0, we get 
		 * back this number
		 */
		
		int extraNum = 0;
		for(int i = 0; i < nums.length; i ++) {
			
			extraNum ^= nums[i];
		}
		
		
		return extraNum;
		
		/**
		 * Time complexity O(n)
		 * Space complexity O(1)
		 */
		
		/**
		 * Explanation:  https://www.javatpoint.com/xor-gate-in-digital-electronics
		 * If we look at the truth table of the XOR gate, 
		 * we see that XOR basically is a strict OR condition. 
		 * 
		 * Only one of the values, can be true.
		 * 
		 * Extrapolating that logic here, when we have 2 number, and both are 
		 * the same value, they will be reduced to 0
		 * 
		 * How does xor operation on different numbers work
		 */
		
		
	}

	private static int findNumberAppearingOnce2(int[] nums) {
		
		/**
		 * Here we are going to try doing it using sorting methods
		 * and once sorted, we can iterate through the array and if 
		 * neither the prevous not the next number of a number
		 * at a given index is the same number, then that is the answer
		 * 
		 * [1,1,2,2,3,3,4,5,5,6,6]
		 * 
		 * Here when we iterate, we see that when we are at index of number 4
		 * neither, the number at previous index (3) nor the number at its 
		 * next index (5) is == 4. Hence 4 is our answer
		 */
		
		return -1;
	}

	private static Integer findNumberAppearingOnce1(int[] nums) {
		
		/**
		 * We are given an array and in this array, every number appears
		 * twice, except one number that appears once, find that number
		 */
		
		/**
		 * Trying to see if we can divide the sum by 2 and get the reminder
		 * 
		 * If every number appears twice then the sum of those 2 numbers
		 * will be even
		 * 
		 * And if all the numbers appear twice, then the sum of all elements
		 * in the array will be even,
		 * 
		 * If the number that is repeated is also even, then we cannot extract it
		 * 
		 * 
		 */
		
		/**
		 * ANother way would be to iterate through the array and make a dictionary, 
		 * where we store the frequency of occurence of each number
		 * 
		 * It could be an array or a dictionary. dictionary could be easier, 
		 * as rather than indices, we can use the keys as the numbers
		 */
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// we populate the hash map first
		for(int i = 0 ; i < nums.length; i ++) {
			
			if(map.containsKey(nums[i])) {
				map.replace(nums[i], map.get(nums[i]) +1 );
			}
			else {
				map.put(nums[i], 1);
			}
		}
		
		// we iterate through the keys of the hash map
		for(Map.Entry<Integer, Integer> entry  : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		// if we don't find any number repeating once, we return -1;
		return -1;
		
	}

	private static void findIfEven(int num) {
		
		/**
		 * We know that any number is internally processed as a boolean number
		 * And whenever we '&' a bit by 1, we get the same number back
		 * 
		 * 1 & 1 == 1 // true
		 * 1 & 0 == 0 // true
		 * 
		 * In binary representation, we know that all the bits except
		 * the right most bit is a power of 2. Only the right most bit
		 * (the least significant bit LSB) is not a power of 2
		 * 
		 * Hence excluding the LSB all the other bits, would account to 
		 * an even value
		 * 
		 * Hence to check if a number is even or not, it is sufficient
		 * if we check if the LSB is == 1
		 * 
		 * We know that any number is internally processed as a boolean number
		 * And whenever we '&' a bit by 1, we get the same number back
		 * 
		 * 1 & 1 == 1 // true
		 * 1 & 0 == 0 // true
		 * 
		 */
		
		if((num & 1) == 1) System.out.println("Number is odd");
		else System.out.println("Number is even");
	}

}
