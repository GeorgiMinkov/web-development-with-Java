package lecture.week01.array;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        int[] arrayByExample = { 1, 2, 3 };

        addElements(arrayByExample);

        printElements(arrayByExample);
        System.out.println("-------------------------");

        Random random = new Random();

        final int SIZE = 10;
        int[] arrayWithNew = new int[SIZE];
        for (int index = 0; index < SIZE; ++index) {
            arrayWithNew[index] = random.nextInt();
        }
        printElements(arrayWithNew);
        System.out.println("-------------------------");
        // ----------------------------
        Integer[] arrayWithNewInteger = new Integer[SIZE];
        for (int index = 0; index < SIZE; ++index) {
            arrayWithNewInteger[index] = random.nextInt();
        }

        printElements(arrayWithNewInteger);
        System.out.println("-------------------------");
    }

    private static void printElements(int[] elements) {
        for (int index = 0; index < elements.length; ++index) {
            System.out.println(elements[index]);
        }
    }

    private static void printElements(Integer[] elements) {
        for (int index = 0; index < elements.length; ++index) {
            System.out.println(elements[index]);
        }

        for (var element : elements) {
            System.out.println(element);
        }
    }

    private static void addElements(int[] elements) {
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < elements.length; ++index) {
            elements[index] = scanner.nextInt();
        }

        scanner.close();
    }
}
