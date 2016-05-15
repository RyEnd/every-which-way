import java.util.HashMap;

public class DNA {
    String dnaSequence;
    Integer aCount=0;
    Integer cCount=0;
    Integer gCount=0;
    Integer tCount=0;
    HashMap<Character, Integer> DnaMap = new HashMap<>();
    
    public DNA(){
        
    }
    
    public DNA(String dnaSequence){
        this.dnaSequence = dnaSequence;
        for (int i = 0; i < dnaSequence.length(); i++){
            Character x = dnaSequence.charAt(i);
            switch(x){
                case 'A': aCount++;
                    break;
                case 'C': cCount++;
                    break;
                case 'G': gCount++;
                    break;
                case 'T': tCount++;
                    break;
            }
        }
        DnaMap.put('A', aCount);
        DnaMap.put('C', cCount);
        DnaMap.put('G', gCount);
        DnaMap.put('T', tCount);
    }
    
    public Integer count(Character nucleotide){
        Integer count = 0;
        switch (nucleotide) {
            case 'A': count = aCount;
                break;
            case 'C': count = cCount;
                break;
            case 'G': count = gCount;
                break;
            case 'T': count = tCount;
                break;
            default: throw new IllegalArgumentException ("No");
        }
        return count;
    }
    
    public HashMap<Character, Integer> nucleotideCounts(){
        return DnaMap;
    }
}
