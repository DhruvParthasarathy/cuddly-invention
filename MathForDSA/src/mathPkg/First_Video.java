package mathPkg;

public class First_Video {

	public static void main(String[] args) {
		
//		print_primes();
//		square_root_precision();
		square_root_newton_raphson_method();

	}
	
	static void print_primes() {
		for(int i = -10; i <= 50; i++) {
			check_prime(i);
		}
	}
	
	static void check_prime( int num ) {
		
		// we write the logic here to check if any given number is primer or not
		
		/**
		 * For example if we start with 36, we can see that the following are the factors are 36
		 * 
		 * 1 * 36
		 * 2 * 18
		 * 3 * 12
		 * 4 * 9    
		 * 6 * 6  <---------- Square root of 36, any multiplication below this point is a repitition of one of the multiplications above
		 * 9 * 4
		 * 12 * 3
		 * 18 * 2
		 * 36 * 1
		 * 
		 */
		
		/**
		 * Hence while checking if a given number is prime or not, we need to only check if any of the number that is <= square root of the given number, divides the number
		 * We should not check from 1, because even for a prime number, 1 is a factor, we check from 2
		 */
		
		/**
		 * Edge cases, numbers <= 1 are not prime
		 * Even numbers > 2 are not prime
		 */
	
		
		if(num <= 1) {
			System.out.println(num + " is not prime");
		} else  if (num > 2 && (num&1) == 0) {
			System.out.println(num + " is not prime");
		}
		else {
			
			int c = 2;
			
			// check for numbers starting from 2 till the square root of the given number
			while(c*c <= num) {
				
				// if the number divides the number it is not a prime number
				if(num % c == 0) {
					System.out.println(num + " is not prime");
					return;
				}
				
				c++;
			}
			
			System.out.println(num + " is prime");
		}
	}

	static void square_root_precision() {
		
		// in this question we need to find he square root of a given number with upto 3 decimal places
		
		// For example, we have a number 40, 
		
		// as we keep iterating through the integers, we arrive at the number 6, that is greatest number whose square is less tha n40
		
		// Next we need to start adding the tenth digit starting from 1 to find the largest 10th digit for which the square root is <= 40
		
		// Likewise, we continue till the 1000th digit
		
		int num = 40;
		
		float root = 0;
		
		int precision = 3;
		
		// we need to run the process till we reach the 3rd decimal
		

		// FInding the unit's place
		
		int start = 0; int end = 40/2;
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if((long)mid*mid == num) {
				root = mid;
			} else if ((long)mid*mid > num) {
				end = mid -1; // because mid cannot be the root, so we ignore it in the search
			} else {
				// (long) mid*mid < num
				// this could be the decimal value
				root = mid;
				// we still try checking for much closer roots
				start = mid + 1;
			}
				
		}
		
		// the while loop has terminated, now we will have a value of root at the unit's place
		System.out.println(root);

		// finding for the decimal places
		
		float dec = 0.1f;
		
		int count = 1;
		
		while(count <= precision) {
			
			// here we use a simple incrementing loop
			
			while(root*root <= num) {
				root += dec;
			}
			 
			// the loop breaks when value of root*root > num
			root -= dec; // we subtract the value of the decimal value once to make it satisfy the condution once again
			
			dec/=10; // we reduce the decimal value to the next decimal place Eg: from 0.1 to 0.01
			count ++; // we increment the counter to keep track of the precision, the loop runs till the count value is <= the precision required
		}
		
		System.out.println(root);
		

	}

	static void square_root_newton_raphson_method() {
		// in this method we use the newton raphson's formula to find the square root of a given number
		
		// we start by assuming a value for the root and we check the error and try to minimize the error to less that 1
		
		int num = 51515151;
		
		// Newton raphson's formula
		
		 // root = (assumed root + (N / asssumed root) ) / 2;  
		
		// If the assumed value is the exact root then, the value of 'root' and 'assumed root' will be the same
		
		// hence we try to keep recalculating the value of root using the above formula and keep checking the error between the output of the equation and the assumed root
		
		// we return the value that gives an error < 1.
		
		double assumed_root = num;
		
		double root = 0;
		
		// we need to run a loop and calculate value of root for given assumed root
		int count = 0;
		while(true) {
			count ++;
			root = (assumed_root + (num/assumed_root)) / 2;
			
			// now we check 
			
			if(Math.abs(root - assumed_root) < 0.0000000001) {
//				System.out.println(root);
				break;
			}
			
			else {
				assumed_root = root;
			}
			System.out.println("Step "+ count);
			System.out.println("Root: " + root);
		}

		System.out.println(root);
		
		// 
	}
}
