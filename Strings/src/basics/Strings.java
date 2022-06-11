package basics;

import java.util.ArrayList;

public class Strings {
	

	public static void main(String[] args) {
		
		
		String a = "abc".concat("def");
		
		String b = "abcdef";
		
		String c = "abcdef";
		
		System.out.println(c==b);
		
		System.out.println(a.contentEquals(b));
	}
}
