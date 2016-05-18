public class Hamming {
    public static int compute(String dna1, String dna2){
        int mutations = 0;
        char[] dna1Char = dna1.toCharArray();
        char[] dna2Char = dna2.toCharArray();
        //throw exception if the dna strands are not idenical in length
        if (dna1.length() != dna2.length()){
            throw new IllegalArgumentException();
        }
        //add to mutation each time an index of each array does not match
        for (int i = 0; i < dna1.length(); i++){
            if (dna1Char[i] != dna2Char[i]){
                mutations++;
            }
        }
        return mutations;
    }
}