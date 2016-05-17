import java.util.Arrays;

public class Pangrams{
    private Integer pangram = 0;
    public static Boolean isPangram(String s){
        //convert string to lower case for easy idexing
        s = s.toLowerCase();
        //step through each letter of the alphabet to check if our string contains at least 1 of each letter
        for (char c = 'a'; c <= 'z'; c++){
            //if there is not instance of a letter indexed in our string, we return false. the string is not a pangram
            if (s.indexOf(c) < 0){
                return false;
            }
        }
        //when our string passes the 26 letter test, we return true
        return true;
    }
}