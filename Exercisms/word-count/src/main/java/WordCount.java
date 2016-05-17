import java.util.HashMap;
import java.util.Map;

public class WordCount {
    HashMap<String, Integer> wordCount = new HashMap<>();
        
    public WordCount(){
    }
    
    public HashMap<String, Integer> phrase(String phrase){
    String[] pArray = phrase.split("\\W+");
        for (int i = 0; i < pArray.length; i++){
            String word = pArray[i].toLowerCase();
            Integer occurance = 1;
            for(Map.Entry<String, Integer> entry: wordCount.entrySet()){
                String key = entry.getKey();
                if (key.equals(word)){
                    occurance += entry.getValue();
                    break;
                }
            }
            wordCount.put(word, occurance);
        }
        return wordCount;
    }
}
