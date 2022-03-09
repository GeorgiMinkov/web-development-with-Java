package lecture.week01.oop;

public class Bicycle extends Object {

    private static final int MIN_GEAR = 1;

    private String model;
    private int maxGear;
    private int currentGear;

    public Bicycle() {
        this.model = "default";
        this.maxGear = 0;
        this.currentGear = 0;
    }

    public Bicycle(String model, int maxGear) {
        this.maxGear = maxGear;
        this.model = model;
        this.currentGear = 1;
    }

    public void shiftUp() {
        if (currentGear != maxGear) {
            currentGear++;
        }
    }

    public void shiftDown() {
        if (currentGear != MIN_GEAR) {
            currentGear--;
        }
    }

    public int getCurrentGear() {
        return currentGear;
    }

}
