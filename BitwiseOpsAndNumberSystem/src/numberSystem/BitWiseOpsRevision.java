package numberSystem;

public class BitWiseOpsRevision {

	public static void main(String[] args) {
		
		observations();
		// TODO Auto-generated method stub
		findIfEven(13);

	}
	
	private static void findIfEven(int number) {
		// Check if the given number is an even number
		
		// We know that for any even number the unit's bit is always 0
		
		// If the number & 1 is 1 then he number is odd else it is even
		
		System.out.println((number & 1) == 0 ? "Even" : "Odd");

	}
	
	private static void p(String input) {
		System.out.println(input);
	}
	
	private static void p() {
		System.out.println();
	}
	
	
	public static void observations() {
		p("AND OPERATOR ===============");
		p("- When we & any binary number with all 1s it results in the same number");
		p("- Example: when we and 10110011 (8bits) with 11111111 (8bits), we get back the initial number");
		p();
		p("XOR ^ OPERATOR =============");
		p("- Any bit when XORed with 1, will result in the opposite bit");
		p("- Example: 0^1 => 1  and   1 ^ 1 => 0");
		p("- a^1 = a's compliment");
		p("- Any number XORed with 0 gives the number itself");
		p("- a^0 = a");
		p("- a^a = 0");
		p();
		p("- If a = 10101, then a^1 gives 01010");
		p();
		p("==== Number systems =============");
		p("Number systems available are decimal (10), binary (2), octal (8), hexadecimal (16)");
		p("Characters present in decimal system: 0,1,2,3,4,5,6,7,8,9");
		p("Characters present in binary system: 0,1");
		p("Characters present in octal system: 0,1,2,3,4,5,6,7,10, 11, 12,13,14,15,16,17, 20,21,22,23,24,25,26,27, 31,32, ..");
		p("Characters present in hexaDecimal system ( 16 characters ): 0,1,2,3,4,5,6,7,8,9[10], A, B, C, D, E, F[6] ");
	
		p("CONVERTING WITHIN BASES => check Conversion.java file");
	}

}
