public class Bob {
    public String hey(String message){
        //trimmed of extra spaces so that empty+ tests will pass
        message = message.trim();
        if (message.isEmpty()){
            return "Fine. Be that way!";
            //uses method to determine if message is shouty or not
        } else if (Bob.shouting(message)){
            return "Whoa, chill out!";
            //checks last char for the question mark
        } else if (message.charAt(message.length()-1) == '?') {
            return "Sure.";
            //meeting none of the above conditions, return "whatever"
        } else {
            return "Whatever.";
        }
    }
    
    private static boolean shouting(String message) {
        //shouting assumed to be false
        boolean shouting = false;
        int uppercase = 0;
        for (char c : message.toCharArray()){
            //if we find any lowercase letters, we aren't shouty enough
            if (Character.isLowerCase(c)){
                return false;
                //when we find an uppercase letter, we increment uppercase. this is to avoid strings of numbers passing the shout test
            } else if (Character.isUpperCase(c)){
                uppercase++;
            }
        }
        //if we made it to this point and there are any letters at all in the message and they are capitalize, we are shouty
        if (uppercase > 0){
            shouting = true;
        }
        return shouting;
    }
}