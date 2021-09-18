package conditionsAndLoops;

public class caseStatements {

	public static void main(String args[]) {
		
		
		/*
		 * Testing swtich case statements
		 * 
		 * test: if break statement not given what happens
		 */
		
		int a = 5;
		
		switch(a) {
			// it enters this block and all subsequent blocks as well because we have not added a break statement
			case 5:{
				System.out.println("five");
			}
			default: {
				System.out.println("default");
			}
			case 2:
			{
				System.out.println("two"); 
			}
			
		}
		
		switch(a) { 
			// Break needs to be added to the default case if it is not added at the end
			default: {
				System.out.println("Default case");
				break;
			}
			case 5 : {
				System.out.println("hello World");
				break;
			}
			
		}
		
		// new java syntax compatibale with later versions of java. 
//		switch( a ) { 
//			case 1 -> System.out.println("1");
//			case 2 -> System.out.println("2");
//			case 5 -> System.out.println("5");
//			default -> System.out.println("def");
//			
//		}
		
		
		// grouping switch case statements
		int day = 6;
		
		switch (day) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				
			{
				System.out.println("Weekday");
				break;
			}
			case 6:
			case 7:
			{
				System.out.println("Weekend!");
			}
				
		}
	}
}
