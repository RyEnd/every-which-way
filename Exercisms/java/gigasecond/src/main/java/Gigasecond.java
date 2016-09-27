import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigInteger;

public class Gigasecond {
  public LocalDateTime birthDate;
  public final long GIGASECOND = BigInteger.valueOf(10)
  										   .pow(9)
  										   .longValue();

  public Gigasecond(LocalDate birthDateLD){
    this.birthDate = birthDateLD.atStartOfDay();
  }

  public Gigasecond(LocalDateTime birthDateLDT){
  	this.birthDate = birthDateLDT;
  }

  public LocalDateTime getDate(){
  	return birthDate.plusSeconds(GIGASECOND);
  }
}