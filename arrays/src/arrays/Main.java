package arrays;

public class Main {

	public static void main(String[] args) {
		
		// syntax for creating an array
		// datatype[] variable_name = new datatype[size];
		// datatype[] variableName = {data1, data2, data3, ..., dataN}
		
		// Store 5 roll numbers
		int[] rollNumbers = new int[5]; // creating a new integer object of size 5
//		System.out.println(rollNumbers[0]) // 0 - default value of an element in an int array is 0
		
		
		
		int[] rollNos = {1,2,3,4,5}; // creating a new array object with the numbers
//		System.out.printf("%s \n", rollNos); // [I@2a139a55
		
		int[] arr; // declaration of array (arr is added to stack)
		arr = new int[5]; // object is created in heap memory here

		
		changeArrVal(rollNos);
		
//		System.out.printf("First element of rollNos now is %s", rollNos[0] );
		
		
		// declaring a new array in the stack memory
		String[] newStringArray;
		
		// System.out.println(newStringArray); 
		// Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		// The local variable newStringArray may not have been initialized
		
		newStringArray = new String[5]; // a new object is created in heap
		
//		System.out.println(newStringArray); // [Ljava.lang.String;@2a139a55
		System.out.println(newStringArray[0]); // null - the default value of a string in an array is taken as null
		
		String test = new String("abcd");
		changeArrVal(test);
		System.out.println(test);
	}
	
	
	static void changeArrVal(int[] array) {
//		System.out.println(array); // [I@2a139a55
		array[0] = 100;
	}
	
	static void changeArrVal(String str) {
		System.out.println(str); 
		str = "hahahah";
		System.out.println(str);
	}
}
