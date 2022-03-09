package lecture.week02.interfaces;

public class Smartphone implements GPS, Radio{

  @Override
  public void getCoordinates() {
    System.out.println("Sofia, Bulgaria");
  }

  @Override
  public void startRadio() {
    System.out.println("Radio is started");
  }

  @Override
  public void stopRadio() {
    System.out.println("Radio is stopped");
  }
}
