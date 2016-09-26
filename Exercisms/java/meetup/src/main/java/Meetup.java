import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

public class Meetup {
  private int month;
  private int year;

  public Meetup(int month, int year){
    this.month = month;
    this.year = year;
  }

  public DateTime day(int weekday, MeetupSchedule occurance) {
  	DateTime meetingDay;
  	switch(occurance) {
  	  case FIRST:
  	    meetingDay = findDate(weekday, 1, 7, 1);
  	    break;
  	  case SECOND:
  	    meetingDay = findDate(weekday, 8, 14, 1);
  	    break;
  	  case THIRD:
  	    meetingDay = findDate(weekday, 15, 21, 1);
  	    break;
  	  case FOURTH:
  	    meetingDay = findDate(weekday, 22, 28, 1);
  	    break;
  	  case LAST:
  	    int daysInMonth = new DateTime(year, month, 1, 0, 0).dayOfMonth().getMaximumValue();
  	    meetingDay = findDate(weekday, daysInMonth, daysInMonth -7, -1);
  	    break;
  	  case TEENTH:
  	    meetingDay = findDate(weekday, 13, 19, 1);
  	    break;
  	  default:
  	    throw new IllegalArgumentException("Not a valid selection");
  	}
  	return meetingDay;
  }

  private DateTime findDate(int weekday, int start, int stop, int step) {
  	DateTime meetingDay = new DateTime(year, month, start, 0, 0);
  	for(; meetingDay.getDayOfMonth() != stop + step; meetingDay = meetingDay.plusDays(step)) {
  	  if(meetingDay.getDayOfWeek() == weekday)
  	  	break;
  	}
  	return meetingDay;
  }
}