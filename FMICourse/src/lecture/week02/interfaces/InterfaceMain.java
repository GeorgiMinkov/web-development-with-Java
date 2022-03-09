package lecture.week02.interfaces;

public class InterfaceMain {

  public static void main(String... args) {
    Radio r = new Smartphone();
    r.startRadio();

    Smartphone smartphone = new Smartphone();
    smartphone.getCoordinates();
  }

}
