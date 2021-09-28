package linearSearch;

public class SearchInStrings {

	public static void main(String[] args) {
		String name = "Dhruv";
		char target = 'd';
		System.out.println(search(name, target));

	}
	
	static boolean search(String str, char target) {
		
		if(str.contentEquals("") || str == null) return false;
		
		for(int i = 0; i < str.length(); i ++) {
			
			if(str.charAt(i) == target) return true;
			
		}
		
		return false;
	}

	static boolean searchInRange(String str) {return false;}
}
