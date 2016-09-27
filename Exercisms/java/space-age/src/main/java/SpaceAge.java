public class SpaceAge {
  private double age;
  private final double EARTHSECONDS = 31557600;

  public SpaceAge(double age){
    this.age = age;
  }

  public double getSeconds(){
  	return age;
  }

  public double onEarth(){
  	return age/EARTHSECONDS;
  }

  public double onMercury(){
  	return age/(EARTHSECONDS*.2408467);
  }

  public double onVenus(){
  	return age/(EARTHSECONDS*.61519726);
  }

  public double onMars(){
  	return age/(EARTHSECONDS*1.8808158);
  }

  public double onJupiter(){
  	return age/(EARTHSECONDS*11.862615);
  }

  public double onSaturn(){
  	return age/(EARTHSECONDS*29.447498);
  }

  public double onUranus(){
  	return age/(EARTHSECONDS*84.016846);
  }

  public double onNeptune(){
  	return age/(EARTHSECONDS*164.79132);
  }
}