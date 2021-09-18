package arrays;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		
		/**
		 * ArrayList 
		 * 
		 * Syntax
		 * ArrayList<*dataType> variableName = new ArrayList<dataType*>(initialCapacity*);
		 * 
		 * *Not mandatory to add the data type 
		 * 
		 * For the data type we cannot pass in primitives, we need to pass the wrapper class of that primitive
		 * Eg: Integer for in, String 
		 * 
		 * *Not mandatory to pass in initial capacity as well
		 */
		
		 //ArrayList<int> arrList1 = new ArrayList<>(5); //using ArrayList<int> throws an error why ? 
		
		ArrayList<int[]> arrList1 = new ArrayList<int[]>();
		
		ArrayList<Integer> arrList2 = new ArrayList<>(5); // Using the wrapper class of the 'int' primitive
		
		ArrayList arrList3 = new ArrayList();
		
		ArrayList<String> arrList4 = new ArrayList(); 
		
		ArrayList<char[]> arrList5 = new ArrayList();
		
		ArrayList<Character> arrList6 = new ArrayList<>(); // using the wrapper class of the 'char' primitive
		
		/**
		 * 
		 */
		int[] testArr = {1,2};
		
		arrList1.add(testArr); // we are adding an array as an element of this array list
		arrList1.add(testArr);

		
		// Printing a ArrayList internally calls it's toString method and prints it out for us
//		System.out.println(arrList1); // this prints : [[I@2a139a55, [I@2a139a55]
		
		/**
		 * 
		 */
		
		arrList2.add(234);
		arrList2.add(224);
		arrList2.add(214);
		arrList2.add(254);
		arrList2.add(26234);
		
		
//		System.out.println(arrList2); //  This prints : [234, 224, 214, 254, 26234]
		
		// empty array list , we have just declared an arrayList variable in the 
		// stack which is pointing to an empty ArrayList object in the heap
		ArrayList<ArrayList<Integer>> arrList7 = new ArrayList<>(); 
		
		// we cannot use this sort of iteration as we don't have any object inside the array list
		// so the control will not enter the array list
		for(ArrayList<Integer> list : arrList7) {  
			list.add(5);
		}
		
		
		// We need to manually iterate using a counter
		// to get the dimension of the array list we use the .size() method
		// The size of the ArrayList (the number of elements it contains).
		for(int i = 0 ; i < 3; i++) {
			
			// we place a new array list at each index of arrayList7
			arrList7.add(new ArrayList<>());
		}
		
		System.out.println(arrList7); // [[], [], []]
		
		// Now that we have initialized the array list to contain 3 empty array lists
		// we can iterate over the arrList7
		for(ArrayList<Integer> list : arrList7) {
			
			// for each list in arrList7, we place 3 elements within it
			for(int j = 0 ; j < 3; j++) {
				list.add(j);
			}
		}
		
		System.out.println(arrList7); // [[0, 1, 2], [0, 1, 2], [0, 1, 2]]

	}
}


