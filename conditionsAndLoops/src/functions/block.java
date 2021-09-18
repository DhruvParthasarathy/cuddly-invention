package functions;

public class block {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 10;
		
		System.out.println(b);
		
		{

			// int a = 50; variable 'a' cannot be re initialized as it has been already initialized above this block 
			int d = 40;
			System.out.println("Inside the block");
			System.out.printf("Value of d %s", d);  // this printed 40
			
		}
		
		int d = 20; // d can be re initialized as it was first initialized within the block, it's scope ends within that block
		
		System.out.printf("Value of d %s", d); // this printed 20
		
		
		
	}
}
