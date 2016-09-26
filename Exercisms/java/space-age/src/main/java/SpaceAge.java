public class SpaceAge {
  private double age;
  private final double earthSeconds = 31557600;

  public SpaceAge(double age){
    this.age = age;
  }

  public double getSeconds(){
  	return age;
  }

  public double onEarth(){
  	return age/earthSeconds;
  }

  public double onMercury(){
  	return age/(earthSeconds*.2408467);
  }

  public double onVenus(){
  	return age/(earthSeconds*.61519726);
  }

  public double onMars(){
  	return age/(earthSeconds*1.8808158);
  }

  public double onJupiter(){
  	return age/(earthSeconds*11.862615);
  }

  public double onSaturn(){
  	return age/(earthSeconds*29.447498);
  }

  public double onUranus(){
  	return age/(earthSeconds*84.016846);
  }

  public double onNeptune(){
  	return age/(earthSeconds*164.79132);
  }
}