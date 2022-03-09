import org.junit.Test;

public class FMICourse {
    public FMICourse() {
    }

    @Test
    public void test() {

    }

    public static void main(String[] args) {
        int i = 1;
        int j = 10;

        do {
            if (i++ > j--) {
            }
        } while(i < 5);

        System.out.println("i = " + i + " j = " + j);


        int number = 156;
        if (number % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }

        switch (number) {
            case 156:
                System.out.println("156");
                break;
            default:
                System.out.println("default");
        }

        final int NUMBER_OF_LIFE = 42;
        for (int index = 0; index < NUMBER_OF_LIFE; ++index) {
            System.out.println("operation number -> " + index);
        }

        int index = 0;
        while (index < NUMBER_OF_LIFE) {
            System.out.println("operation number -> " + index++);
        }

        index = 0;
        do {
            System.out.println("operation number -> " + index);
        } while (++index < NUMBER_OF_LIFE);
    }
}
