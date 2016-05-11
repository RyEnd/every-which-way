import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class Etl {
   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
   	Map<String, Integer> transformed = new HashMap<>();
      for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
 			Integer key = entry.getKey();
 			for (String value : entry.getValue()) {
 				transformed.put(value.toLowerCase(), key);
 			}
         }
     	return transformed;
     }
}
