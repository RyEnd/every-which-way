public class Acronym {
	public Acronym(){

	}

	public static String generate(String input){
		String output = ""; 
		String[] words = input.split("\\W+");
		for (String word : words){
			output += Character.toUpperCase(word.charAt(0));
			String noHead = word.substring(1, word.length());
			String noHeadNoLowercase = noHead.replaceAll("[^A-Z]", "");
			if (noHeadNoLowercase != "" && noHeadNoLowercase != noHead){
				output += noHeadNoLowercase;
			}
		}
		return output;
	}
}