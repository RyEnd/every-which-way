public class PhoneNumber {
  private String phoneNumberString;

  public PhoneNumber(String phoneNumberString) {
  	this.phoneNumberString = phoneNumberString;
  }

  public String getNumber() {
  	String trimmedNumber = phoneNumberString.replaceAll("\\D+","");

  	if(trimmedNumber.length() == 11 && trimmedNumber.substring(0,1).equals("1")) {
  	  trimmedNumber = trimmedNumber.substring(1,11);
  	}
  	
  	if(trimmedNumber.length() != 10) {
  	  return "0000000000";
  	}

  	return trimmedNumber;
  }

  public String getAreaCode() {
  	return getNumber().substring(0,3);
  }

  public String pretty() {
  	String trimmedNumber = getNumber();
  	
  	return "("+trimmedNumber.substring(0,3)+") "+
  			   trimmedNumber.substring(3,6)+"-"+
  			   trimmedNumber.substring(6,10);
  }
}