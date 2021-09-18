package functions;

public class shadow {
	
	static int x = 100;

	public static void main(String[] args) {
		System.out.println(x); // this will print the value 100
		test();
	}
	
	static void test() {
		int x = 20; // this integer x will shadow the class variable x
		
		System.out.println(x); // this will print the value 20
	}
}
