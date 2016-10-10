import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Scrabble {
	private String input;
	private int output = 0;

	private static HashMap<Character[], Integer> scores;

	static {
		scores = new HashMap<Character[], Integer>();
		scores.put(new Character[] {'A','E','I','O','U','L','N','R','S','T'}, 1);
		scores.put(new Character[] {'D','G'}, 2);
		scores.put(new Character[] {'B','C','M','P'}, 3);
		scores.put(new Character[] {'F','H','V','W','Y'}, 4);
		scores.put(new Character[] {'K'}, 5);
		scores.put(new Character[] {'J','X'}, 8);
		scores.put(new Character[] {'Q','Z'}, 10);
	}

	public Scrabble(String input) {
		this.input = input;
	}

	public int getScore(){
		if (input == null){
			return output;
		}
		for(int i = 0; i < input.length(); i++){
			Character c = input.charAt(i);
			for (Map.Entry<Character[], Integer> entry : scores.entrySet()){
				if(Arrays.asList(entry.getKey()).contains(Character.toUpperCase(c))){
					output += entry.getValue();
				}
			} 
		}
		return output;
	}
}