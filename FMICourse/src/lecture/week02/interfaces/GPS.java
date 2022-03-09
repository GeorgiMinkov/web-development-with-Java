package lecture.week02.interfaces;

public interface GPS {
  void getCoordinates();

  default void getRoughCoordinates(){
    System.out.println("Fetching rough coordinates...");
  }

}
