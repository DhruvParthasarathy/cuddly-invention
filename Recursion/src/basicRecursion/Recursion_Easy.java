package basicRecursion;

public class Recursion_Easy {

	public static void main(String[] args) {
//		print_n_nos(21);
//		System.out.println(factorial(5));
//		System.out.println(sum_to_n(20));
//		System.out.println(sum_digits(1342));

//		System.out.println(product_digits(1222));
//		System.out.println(reverse_num(4321));
//		System.out.println(count_digits(1));
//		System.out.println(checkIfPalindrome(8765678));
//		System.out.println(count_zeros(601111100));
		System.out.println(count_zeros_recur(1020304050, 0));
	}
	
	static void print_n_nos(int n) {
		System.out.println(n);
		if(n == 1) {
			System.out.println(n);
			return;
		}
		else {
			print_n_nos(n-1);
		}
		System.out.println(n);
	}


	// for finding a factorial of a number0
	// we need to start from 1 and continue multiplying till the given number
	static int factorial(int number){
		
		if(number == 1) {
			return number;
		}
		else {
			return number * factorial(number-1);
		}
		
		

	}

	static int sum_to_n(int num) {
		
		if(num == 1) {
			return 1;
		} else {
			return num + sum_to_n(num-1);
		}
		

	}

	static int sum_digits(int num) {
		
		if(num%10 == num) {
			return num;
		} else {
			// assume we have 123
			
			// how do we start summing this
			
			// we first take the units digit, 
			// then we ask the sum of remaining digits
			int units = num%10;
			return units + sum_digits(num/10);
		}

		
	}

	static int product_digits(int num) {
		
		if(num%10 == num) return num;
		else return (num%10)*product_digits(num/10);
	}
	
	static int count_digits(int num) {
		
		// works for all positive integers
		int count = 0;
		while(num > 0) {
			count++;
			num/=10;
		}
		return count;
		
// works for all positive integers apart from , Math.log10(0) gives a large negative value
//		return (int)Math.log10(num) + 1;
	}
	
	static int reverse_num(int num) {
		// given a number, we need to reverse the digits of that number
		
		// we keep taking out the units digits as we go in and add them by increasing them one position by a power of ten as we move out
		// Example stack trace
		// 1234         // 4321
		// 123 (4)   4*1000 + return (321)
		// 12 (3) 3*100 + return (21)
		// 1 (2) 2*10 + return (1)
		// (1) return 1
		
		if(num%10 == num) {
			return num;
		} else {
			
			int numDig = count_digits(num);
			int unit = num%10;
			
			return unit*((int)Math.pow(10, numDig-1)) + reverse_num(num/10);
			
			
		}
	}

	static boolean checkIfPalindrome(int num) {
		return num == reverse_num(num);
	}

	static int count_zeros(int num) {
		
		int count = 0;
		if(num == 0) {
			return 1;
		}
		while(num > 0) {
			if(num%10 == 0) {
				count++;
			}
			num/=10;
		}
		
		return count;
	}

	static int count_zeros_recur(int num, int count) {
		
		// if the number is 0 we directly increment the count and return the count
		if(num == 0) {
			count++;
			return count;
		}
		else {
			// the number is not 0; eg 102034, 007
			
			// if the unit's digit is 0, we increment the count
			// 43520
			if(num%10 == 0) {
				count++;
			}
			
			// if this is a single digit number
			// we know the number is not 0, it counld be 1,2,3,4,5,6,7,8,9
			// so we just return current value of count
			if(num < 10) {
				return count;
			} else {
				// there is more than 1 digit, we continue checking for remaining digits
				// 12025
				return count_zeros_recur(num/10, count);
			}
			
		}
		
		
		
		
		
	}
}
