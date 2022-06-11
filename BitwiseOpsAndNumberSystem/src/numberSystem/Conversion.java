package numberSystem;

public class Conversion {

	public static void main(String[] args) {
		
		/**
		 * 	There are 4 number systems
		 * 1. Decimal that we already know
		 * 2. Binary: consists of 0 and 1
		 * 3. Octal: 0, 1, 2, ... till 7 (8 numbers)
		 * 4. Hexa: 0 1 2 ... 9 , A, B .. , F (16 numbers)
		 */
		
//		convertDecimalToBaseTwo(14);
//		convertDecimalToBaseEight(10);
//		
//		converToDecimal(10001, 2);
//		
//		converToDecimal(21, 8);
		
//		System.out.println(1<<10);
		
//		numberOfDigitsInBase(12345, 1);
		

		int num = 964176192;
		
		System.out.println(Integer.toBinaryString((num & 0xffff0000)) + " " + Integer.toBinaryString((num&0x0000ffff)));

		num = (num&0xffff0000) >> 16 | (num&0x0000ffff) << 16;
		
		System.out.println(Integer.toBinaryString((num & 0xffff0000)));
		
		// swap the 8 characters, not the 16
		
		num = (num & 0xff00ff00) >> 8 | (num&0x00ff00ff) << 8;
		
		System.out.println(Integer.toBinaryString((num & 0xffff0000)));
		
		// swap 4 characters 
		
		num = (num & 0xf0f0f0f0 ) >> 4 | (num&0x0f0f0f0f) <<4;
		
		System.out.println(Integer.toBinaryString((num & 0xffff0000)));
	}
	
	
	
	
	private static void numberOfDigitsInBase(int num, int base) {
		
		/**
		 * To find the number of digits of a decimal number
		 * in a given base we can use the following logic
		 * 
		 * Say we need to find the number of digits for 10 in base 2
		 * 
		 * 10 in binary is 1 0 1 0
		 * 
		 * Need to figure out how this logic works
		 * 		 
		 */
		
		// formula
		
		int numDigits = (int)(Math.log(num) / Math.log(base)) + 1;
		
		System.out.println(numDigits);
		
	}




	static void convertDecimalToBaseTwo(int num) {
		/**
		 * Keep dividing by target base 
		 * take reminders and write in reverse order
		 */
		
		StringBuffer sb = new StringBuffer();
		
		int temp = num;
		
		while(num > 1) {
			
			num/= 2;
						
			/**
			 * we perform insert rather than 
			 * the append so that the numbers 
			 * get added in reverse order
			 */
			sb.insert(0, temp %2); 
			
			temp = num;
		}
		
		sb.insert(0, num);
		
		System.out.println(sb.toString());
		
		sb = null;
	}

	static void convertDecimalToBaseEight(int num) {
		/**
		 * Keep dividing by target base 
		 * take reminders and write in reverse order
		 */
		
		StringBuffer sb = new StringBuffer();
		
		int temp = num;
		
		while(num > 1) {
			
			num/= 8;
						
			/**
			 * we perform insert rather than 
			 * the append so that the numbers 
			 * get added in reverse order
			 */
			sb.insert(0, temp %8); 
			
			temp = num;
		}
		
		sb.insert(0, num);
		
		System.out.println(sb.toString());
		
		sb = null;
	}

	static void converToDecimal(int numInBaseX, int x) {
		
		/**
		 * We are given a number in base x, 
		 * we have to convert it to decimal
		 * Multiple and add the power of the base
		 * with the digits
		 */
		
		/**
		 * Example 10 in base 2 is 
		 * 2^1 * 1 + 2^0 * 0 = 2
		 */
		
		int decNum = 0;
		
		StringBuilder sb = new StringBuilder( Integer.toString(numInBaseX));
		
		System.out.println();
		
		/**
		 * We get the value of the number in decimal
		 * by the folowing step 
		 */
		int len = sb.length();
		
		for(int i = len - 1  ; i >= 0; i --) {
			decNum += Math.pow(x, len - 1 -i) * Integer.parseInt(sb.charAt(i)+"");
		}
		
		System.out.println(decNum);
	}


}
