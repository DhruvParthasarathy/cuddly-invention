package functions;

import java.util.Arrays;

public class varArgs {

	public static void main(String[] args) {
//		varArgsFn(1,2,3,5,6,7,8); // this varArgs function can take in any number or arguments as input
		
		multiple(1,2, "Dhruv", "Froov");
	}
	
	static void varArgsFn(int ...i) {
		System.out.println(Arrays.toString(i)); // Prints: [1, 2, 3, 5, 6, 7, 8]
	}
	
	/**
	 * Variable length arguments should always come at the end
	 * @param a
	 * @param b
	 * @param strs
	 */
	static void multiple(int a, int b , String ...strs) {
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(Arrays.toString(strs));
		
		
		
	}
}
