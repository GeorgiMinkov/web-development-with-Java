package lecture.week01.oop;

public class SimpleExample {

    public static void main(String[] args) {

        Bicycle bicycle = new Bicycle("balkanche", 10);

        System.out.println(bicycle.getCurrentGear());

        bicycle.shiftDown();
        System.out.println(bicycle.getCurrentGear());

        bicycle.shiftUp();
        bicycle.shiftUp();

        System.out.println(bicycle.getCurrentGear());
    }
}
