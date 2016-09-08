import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {
    private String myWord;
    public Anagram(){
    }
    public Anagram(String s){
        //take in a string on construction and store in in the object
        this.myWord = s;
    }
    public List<String> match(List<String> sList){
        // initiate an empty list of matches
        List<String> matches = new ArrayList<>();
        //conver our word  to something to check against
        String wLower = this.myWord.toLowerCase();
        char[] myCharsToCompare = wLower.toCharArray();
        Arrays.sort(myCharsToCompare);
        //step through each word converting it to a standard to check against our word, added to a list if it passes the criteria
        for (String s: sList){
            String sLower = s.toLowerCase();
            char[] charsToCompare = sLower.toCharArray();
            Arrays.sort(charsToCompare);
            //if the sorted array matches and the original word is not the same as our word, it is added to a list to be returned
            if ((Arrays.equals(myCharsToCompare, charsToCompare)) && (!(wLower.equals(sLower)))){
                matches.add(s); 
            }
        }
        return matches;
    }
}
