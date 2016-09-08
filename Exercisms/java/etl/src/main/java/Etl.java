import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;


public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> oldMap) {
        Map<String, Integer> transformedMap = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : oldMap.entrySet()) {
            Integer key = entry.getKey();
            for (String value : entry.getValue()) {
                transformedMap.put(value.toLowerCase(), key);
 	        }
        }
        return transformedMap;
    }

//while attempting to decipher a more efficient solution, I utilized Java 8's 
//stream to complete the same function as above, efficiency unchanged.
    public Map<String, Integer> transformStream(Map<Integer, List<String>> oldMapStream) {
        Map<String, Integer> transformedMapStream = new HashMap<>();
        oldMapStream.entrySet().stream()
            .forEach(e -> e.getValue().stream()
                .forEach(v -> transformedMapStream.put(v.toLowerCase(), e.getKey()))
            );
        return transformedMapStream;
    }
}