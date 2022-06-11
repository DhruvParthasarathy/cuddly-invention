package stringPatterns;

public class RemoveSplChars {

	public static void main(String[] args) {
		String str= "shriya.verma_samplemodelprocess123_1648121564620_shriya.verma@gapac.com_1648121583766";   
		str = str.replaceAll("[^a-zA-Z0-9-.]", "_");  
		System.out.println(str);  

	}

}
