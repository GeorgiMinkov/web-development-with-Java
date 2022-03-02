package week02.interfaces;

public interface GPS {
  void getCoordinates();

  default public void getRoughCoordinates(){
    System.out.println("Fetching rough coordinates...");
  }

}
