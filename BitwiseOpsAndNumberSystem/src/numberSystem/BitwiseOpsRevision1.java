package numberSystem;

import java.util.BitSet;

public class BitwiseOpsRevision1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		leftShifting();
//		findOdd_Even(16);
//		find_num_appear_once(new int[]{1,2,2,3,1});
//		find_ith_bit(234, 5);
//		set_ith_bit(234, 1);
//		reset_ith_bit(15, 3);
//		compliment(5);
//		right_most_set_bit(3);
//		negativeNumbers();
//		right_shift_test2();
//		negative_of_number();
//		range_of_data_types();
//		number_appear_odd_times_find_single_num();
//		number_of_digits_in_base_representation();
//		pascals_triangle();
//		find_if_power_of_two();
//		find_a_power_b();
		find_number_set_bits();
	}
	
	
	static void p() {
		System.out.println();
	}
	
	static void p(int input) {
		System.out.println(input);
	}
	
	static void p(String input) {
		System.out.println(input);
	}
	
	static void leftShifting() {
		p("LEFT SHIFT ===================");
		p("- left shifting a number x times is basically multiplying the given number by base^x"); 
		
		p("- Example, When we add 2 zeros to a decimal number to it's right, we are basically multiplying that decimal number by 100");
			
		p("- i.e. 321 <<(decimal) 2   => 32100 === 321 * 100 === 321*10(base)^2(times we shifted to left)");
		p();
		p("- Similar to the above example, the binary left shift operator does the same");
		p("- x << y basically  implies x*(2^y)");
		p("- x << 1 means we are doubling x [2^1]");
		p("- x << 2 means we are multiplying x by 4 [2^2]");
		p("- x << 3 means we are multiplying x by 8 [2^3].. so on an so forth");
		p();
		p("RIGHT SHIFT ====================");
		p("- In left shift, we multiple the given number by base^(number of shift), here in right shift, we divide the number by base^(shift)");

	}

	static void findOdd_Even(int num) {
		System.out.printf( "%d is %s", num,  (num & 1) == 1 ? "Odd" : "Even");
	}
	
	static void find_num_appear_once(int[] arr) {
		// we need to return the number that appears only once
		// for this we use the property of XOR operator, we know that a^a will give 0.
		
		// We as we keep XORing all the numbers in the array, the number which does not have a pair will remain.
		int rem = arr[0];
		for(int i = 1; i < arr.length; i++) {
			rem^=arr[i];
		}
		
		System.out.printf("The number apearing once is %d", rem);
	}
	
	static void find_ith_bit(int num, int i) {
		// given a number we need to find the ith bit
		// from the concepts we have learnt so far, we know that we can right shift the number i-1 times and we
		// can and it with 1 to find the ith bit
		
		p(Integer.toBinaryString(num));
		
		System.out.printf("%dth bit of %d is %d", i, num, ((num >> (i)) & 1) == 1 ? 1 : 0);
	}

	static void set_ith_bit(int num, int i) {
		// given a number we have to set the ith bit to 1
		
		// i can start from 1 eg: 1st bit, 2nd bit, 3rd bit... not 0th bit
		// to set the ith bit - we have to swap only the number in the 1th bit to 1, the remaining can be the saem
		// to only set the ith bit, we create a mask by doing 1 << (i-1 times), and we or the number with this mask
		// this way the ith bit will be set if not, and` the remaining bits will remain the same
		
		System.out.println(Integer.toBinaryString(num));
		System.out.printf("Setting the %d bit", i);
		p();
		System.out.println(Integer.toBinaryString((num | 1 << (i - 1))));
	}

	static void reset_ith_bit(int num, int i) {
		
		// CONCEPT USED HERE - taking the complimentary of a number ( ~ operator ) 
		
		// to reset a given bit we need to create a mask and an operation that will only result in the ith bit getting affected
		// by reset, we need to make the ith bit to 0
		// we need an operation like 1 ---> 0, 0  ----> 0
		// only the and operation gives this, any bit be it one or 0 should be set to 0 and the remaining bits need to remain
		
		// so the mask would be made up of 1s, with only the ith bit being 0.
		// so when we and the number with the mask, the ith bit will undergoe bit & 0 -> this will always cause it to be 0
		// the remaining bits will undergo bit & 1 -> this will be 1 if the bit is 1 or 0 if the bit is 0, the bit remains the same
		
		// how to create such a mask
		
		// we can use the xor operator to create a 1 based mask first and then use the xor preperty
		// a^0 = a and a^1 = flip
		
		int mask = 1 << (i - 1);  
		// this will be a 32 bit value with 1 at the ith bit: 00000000000000000000010000000000
			
		// now to get the antimask of this, we can do ~mask
		
		mask= ~mask;    // 11111111111111111111110111111111 (32 bits) with 0 at the ith bit and remaining 1.
		
		// now that we have a 0 in the ith bit, we can use the & binary operator to reset that bit alone
		// the rest of the bits will remain the same
		
		System.out.println(num);
		System.out.println(Integer.toBinaryString(num));
		System.out.printf("Resetting %d bit", i);
		p();
		System.out.println(Integer.toBinaryString(num&mask));

		
		
	}
	
	static void compliment(int num) {
		System.out.printf("the number is %d \n", num);
		System.out.printf("In binary representation %s \n", Integer.toBinaryString(num));
		System.out.printf("When bits are flipped %s \n", Integer.toBinaryString(~num));
		System.out.printf("The actual number (2's compliment) when bits are flipped: %d \n", ~num);
		
	}

	static void right_most_set_bit(int num) {
		// any given binary number we know that has a least significant bit and the most significant bit
		// LSB is the right most set bit
		// to find it, we can keep checking doing a right shift and check if the LSB bit is 1
		
		// there is another concept that can be learnt from here
		
		// it is that the binary number can be written as N = a 1 b, 
		// where b represents all 0s after the 1, and a represents all bits before the 1
		// we have a property that says -N = ~a 1 b
		
		// So when we do N & -N, we will be doing a & -a (0) , then 1 & 1 (1) and b & b (0)
		// so we will get a number with only the LSB set to 1
		
		// To test, let's do 6 & -6. The binary representation of 6 is 110, 
		// so if we do 6 and -6, we have to get 2 that is 010.
		
		System.out.println(6&-6); // we get 2
		
		System.out.println(7&-7); //  we get 1
		
		System.out.println(4&-4); // we ge 4, for all powers of 2, we will get the same number back as they have only one bit
		
		
	}

	static void negativeNumbers() {
		// In java we have 4 primitive data types that store negative numbers, byte, short, int and long
		// byte - 1 byte = 8 bits, -128 -> 0 -> +127
		// sort - 2 bytes = 16 bits , -2^15 to (2^15 -1)
		// int - 4 bytes = 32 bits, -2^31 to (2^31 -1)
		
		
		// we see that there are 2 more data types float and double 
		// that we can use to store smaller and larger decimal numbers as required
		
		
		// long - 4 bytes
		// double - 8 bytes
		
		// the left most bit of a given data type is the most significant bit, this represents the sign of the number
		// if MSB is 1, then the number is negative, if it is 0 then the number is positive
		
		// Likewise the LSB tells whether the number is even or odd, 1 means odd, 0 means even
		
		// floating point numbers are always signed unlike integers that can be unsigned
		
		int x = -6;
		p(Integer.toBinaryString(x));
	}
	
	static void right_shift_test() {
        // Using unsigned right shift with negative number in Java 
        // we can use binary literals from JDK 1.7 to assign 
        // binary values to an integer, 0b is for binary, similar 
        // to 0x of hexadecimal 
        int number = 0b1111_1000_1111_1010_1111_1000_1111_1010;
        int numberB = 0b1111_1000_1111_1010_1111_1000_1111_1010; 
        System.out.println(Integer.toBinaryString(number)); 
        System.out.println("number in decimal format : " + number); 
        number = number >>> 1; 
		numberB = numberB >> 1;
        //shift 1 bit using right shift without sign 
        System.out.println(Integer.toBinaryString(number)); 
        System.out.println("number in decimal format : " + number); 
        
        System.out.println(Integer.toBinaryString(numberB)); 
        System.out.println("number in decimal format : " + numberB); 
        
	}
	
	static void right_shift_test2() {
		// here we take integer numbers in the negative range and we do an unsigned and signed right shift to them and check the values

		System.out.println("number" + " " + "Signed" + " " + "Unsigned");
		
		for(int i = -50 ; i < 0; i++) {
			System.out.println(i + "      " + (i >> 1) + "     " + (i >>> 1));
		}
		
		
	}
	
	static void negative_of_number() {
		
		// it is weird the explanation, but anyways let's see how it works
		
		// suppose we have a binary representation of 10 ( 00001010 ) in a byte, we have 8 bits
		
		// If we have to get the binary representation of -10, we will need to get a binary number that has 1 in the signed bit
		
		// We know that for a 8 bit number adding additional bits to the left of the number does not matter
		
		// Example: 0b1_0000_0000 == 0b0000_0000. Because we cannot store more than 8 bits in a byte
		
		// We also know that 100 = 11 + 1, or 0b1_0000_0000 = 0b1111_1111 + 0b1;
		
		// Now to find -10, we can try doing 0 - 10;
		
		
		// we just saw that 0 can also be represented as 0b1_0000_0000 - 10 = 0b1111_1111 + 0b1 - 10
		
		// if we check 0b1111_1111 + 0b1 - 10, we can re arrange it as 0b1111_1111  - 0b0000_1010  + 0b1
		
		// 0b1111_1111  - 0b0000_1010, this is basically the compliment of 0b0000_1010
		
		// as 0b1111_1111  - 0b0000_1010 = 0b1111_0101 (1's compliment of 10)
		
		// now we have the +0b1 remaining
		
		// hence negative of ten is the 1's compliment of 10 + 1
		
		// 0b1111_0101  + 0b1 = 0b1111_0110  
		// When represented using the int data type ( 8 bytes ) 0b1111_1111_1111_1111_1111_1111_1111_0110
		
		System.out.println(0b1111_1111_1111_1111_1111_1111_1111_0110); // prints -10
		
		
	}

	static void range_of_data_types() {
		// given the size of a data type in bytes we can identify the range
		
		// Eg: integer is 4 bytes - that is 32 bits
		
		// If this is a signed range, then we have the MSB for the sign of the number, hence we only have 31 bits for the number
		
		// and since 0 does not have a negative value, we include 0 in the positive size
		
		// Hence the ranged of as signed integer data type is 
		
		// -2^31 till +2^31 - 1 ( we subtract -1 from the positive side as we have a 0 here )
		
		// -2^31 ..... 0 ....... + (2^31 -1)
		
		
		// If this is an unsigned data type, then we have all 32 bits for number storage, then
		// the range will be 0 ......... (2^32 -1) [again we subtract -1 as 0 is also included in the list
	}

	static void number_appear_odd_times_find_single_num() {
		// we have an input array where each number appears an odd number of times, and only 1 number appears once
		// find that number that appears only once
		
		int[] arr = new int [] {1, 1 , 1, 0, 2,3, 3, 4, 3, 4, 4};
		
		// this has to do something with the number of times a bit get's set,
		// we collect all the set bits that get set x times such that x is not a multiple of 3
		
		// For example in the above example, we have 1-3 times, 2- 3 times and 3 only once
		
		// If we check the bits
		
		// 0b00, for 1 we will see that the 1st bit get's set 3 times, 
		// for 2, the second bit get's set 3 times
		// for 3, the 1st and second bit get set again the 4th time, 
		// this way we know that the number that appears only once is the number that we get by setting the 1st and 2nd bit once
		
		// we need to find a way to store the frequency of set bits
		
		// let's take an array to serve the purpose of the frequency counter
		
		int[] bits_frequency = new int[8];
		
		for(int i = 0 ; i < arr.length ; i++) {
			// for each number, we keep checking the set bit's position and update the frequency in the array
			countSetBits(arr[i], bits_frequency);
		}
		
		// now we have checked all the numbers and have the frequency of bits present
		
		// now lets divide all the values by 3
		
		BitSet bs = new BitSet();
		
		for(int i = 0; i < bits_frequency.length ; i++ ) {
			bits_frequency[i] = bits_frequency[i]%3;
			
			if(bits_frequency[i] != 0) {
				bs.set(i);
			}
		}
		
		getNumFromBitSet(bs);
		
		
		
		
	}
	
	static void getNumFromBitSet(BitSet bs) {
		
		// we have a bit set that we can iterate and create the value
		int num = 0;
		
		for(int i = 0 ; i < bs.length() ; i++) {
			if(bs.get(i) == true) {
				num += Math.pow(2, i);
			}
		}
		
		System.out.println(num);
	}
	
	static void countSetBits(int num, int[] arr) {
		
		// given a number, we keep dividing the number and use a counter to keep track of bit's passed so far
		int count = 0;
		
		while(num > 0) {
			if((num&1) == 1) {
				arr[count] ++;
			}
			num = num >> 1;
			count++;
		}
		
	}

	static void number_of_digits_in_base_representation() {
		
		// given a number and it's base, calculate the number of bits it has
		
		// Let's take a binary represntation of a number,
		
		// 7 base 10 is 111 in base 2,
		
		// we see that to reach the value of 7, we need the following powers of 2 -> 0, 1 and 2, hence 3 bits
		
		// similarly for 8 we need 3 bits, but when we fo for numbers from 9 till 15, we will need the 4th bit.
		
		// This number we can obtain by performing log(number)/ log(base), and rounding it off to the next positive number
		
		int num = -98765; int base = 2;
		
		System.out.println((int)Math.ceil((Math.log(num)/ Math.log(base))));
	}

	static void pascals_triangle(){
		
		// given a value of n, we know that the nth row in a pascal's triangle will have the values
		
		// nC0, nC1, nC2, nC3, nC4, .... nCn-1, nCn
		
		// The sum of the above sequnce is 2^(n-1)
		
		// therefore the sum of the elements in the nth row of a pascal's triangle is 1 << (n-1);
	}

	static void find_if_power_of_two() {
		// if a number is a power of 2, then we know that it will only have one set bit , 
		// what is the easiest way to find if it has only 1 set bit ?
		
		// we know that a number will only have log(n)/log(2) bits, so we can do right shifting to quickly finish it
		
		// ========================= BRUTE FORCE APPRAOCH =====================
		
//		int n = -10;
//		int count = 0;
//		while(n > 0) {
//			System.out.println(Integer.toBinaryString(n));
//			if((n&1) == 1) {
//				count ++;
//				
//				if(count > 1) {
//					System.out.println("not a power of 2");
//					break;
//				}
//			}
//			n = n >> 1;
//			
//		}
//		
//		if(count <= 1) {
//			System.out.println("Power of 2");
//		}
		
		
		// ADVANCED APPROACH ===============================================
		
		// We know that a power of 2 will be written as 0b1_000000000 .. followed by howmany ever zeros
		// We also know that if it is a power of 2 then the number before it ( n -1 ) will have all 1s
//		int power = 10;
//		System.out.println(Integer.toBinaryString((int)Math.pow(2,power)));     // 10000000000
//		System.out.println(Integer.toBinaryString((int)Math.pow(2,power) - 1)); //  1111111111
		
		// we notice that, n & (n-1) will always be 0 if the given number is a power of 2. 
		// we need to note that, no negative number is a power of 2
		
		int n = 0;
		System.out.println(Integer.toBinaryString(n));     
		System.out.println(Integer.toBinaryString(n - 1));
		System.out.println((n&(n-1)) == 0 ? "Power of two" : "Not a power of 2");
		
	}

	static void find_a_power_b() {
		
		// REVISE THIS QUESTION AGAIN
		// https://youtu.be/fzip9Aml6og?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=6372
		
		int base = 3; int power = 17; int ans = 1;
		
		// we know that the given power can be represented in bits Eg: 6 can be represented as 0b 1 1 0.
		
		// this means we have a 2^1 and a 2^2 in the power, but we don;t have a 2*0,
		// hence we are at the 0th index, we need not multiple the answer with the base
		
		// and each time we move a bit towards the left, the base get's squared => 3^2 = 3^1*3^1, 3^4 = 3^2*3^2,
		// hence after every step we multiple the base by itself
		
		// when we check a bit and we have it set, we multiply the answer with the value of the base at that bit
		
		System.out.println((int)Math.pow(base, power));
		
		while(power > 0) {
			
			if((power&1) == 1) {
				ans*=base;
			}
			base*=base;
			power = power >> 1;
		}
		
		System.out.println(ans);
	}

	static void find_number_set_bits() {
		// log of number of bits
		// keep doing right shift and keep adding the frequency of the set bit till value of number becomes 0
		
		// the above mentioned approach is the brute force
		
		// we can use a better approach to solve the given problem. 
		
		// so if we do (N & -N), a and !a will cancel each other, and we will be left with just the 
		// We have a proprety that says if N can be represented as a 1 b, then -N will be !a 1 b. Where 1 represents the RMB.
		
		// Now that we have the binary representation of the right most bit, 
		
		// we can subtract this from the Value of N. This way, we will have a new Number with a different RMB.
		
		// We keep doing this till the value of N reaches 0.
		// The advantage of doing it this way is that ,we will only have to run the loop as many times as there are set bits
		
		// Example walk through 
		
		int n = 127;
		System.out.println(Integer.toBinaryString(n)); // 1000101011  -> Here we notice that there are 5 set bits
		// hence the below loop runs 5 times only
		
		int count = 0;
		while(n > 0) {
			n = n - (n&(-n));
			count ++;
			
		}
		
		// An alternative approach would be to use n&(n-1) instead of doing n - (n&(-n))
		
		System.out.println(count); // 5

	}
}

