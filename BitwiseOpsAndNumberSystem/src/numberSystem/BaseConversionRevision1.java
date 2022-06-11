package numberSystem;

public class BaseConversionRevision1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p("We are going to revise concepts related to converting numbers to different bases");
		p("Decimal number to base x :");
		p("We keep dividing the decimal number by the base and we finally create a string using the remainders in reverse order - last remainder first");
		int num = 17;
		int base = 8;
		p();
		System.out.printf("We are going to convert the integer %d to base %d", num, base);
		p();
		p("The converted number is ");
		p(convert_to_base(num, base));
		p();
		p("Now we are going to convert a number in any given base back to decimal base");
		String baseNum = "21";
		int originalBase = 8;
		System.out.printf("Converting %s from base %d to decimal base", baseNum, originalBase );
		p();
		p(convert_to_decimal_from_base(baseNum, originalBase));
		

	}
	
	
	
	public static void p() {
		System.out.println();
	}

	public static void p(String input) {
		System.out.println(input);
	}
	
	public static void p(int input) {
		System.out.println(input);
	}
	
	
	static String convert_to_base(int decimalNum, int base) {
		
		// we keep dividing the number by the base
		// append the remainders in reverse order
		// does not work for converting to hexadecimal base - works for all bases from 2 till 8
		StringBuilder sb = new StringBuilder();
		
		while(decimalNum > 0) {
			sb.insert(0, decimalNum%base);
			decimalNum/=base;
		}
		return sb.toString();
		
	}
	
	static int convert_to_decimal_from_base(String number, int base) {
		
		// given any number in any base from 2 - 9, we convert it back to decimal
		
		// here we take the number at the given position and we multiply it with (base ^ position)\
		
		// Eg: if we have 100 in binary, and we need to convert it to decimal
		// we do 1*2^2 + 0 * 2 ^ 1 + 0 * 2 ^ 0  .. this gives 4 + 0 + 0 .. that is 4.
		
		int decimalNum = 0;
		
		for(int position = 0; position < number.length(); position++) {
			
			// we take the digit at given position adn multiple it with base^position and add it to the decimalNumber
			
			decimalNum += Integer.parseInt(number.charAt(position)+"") * Math.pow(base, number.length() -1 -position);
			
		}
		
		
		return decimalNum;
	}
}
