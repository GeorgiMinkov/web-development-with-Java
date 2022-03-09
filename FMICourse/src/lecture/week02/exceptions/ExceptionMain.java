package lecture.week02.exceptions;

import java.io.IOException;

public class ExceptionMain {

  public static void main(String... args) throws Exception {
//    iterateArray();
    // NullPointerException
//    Animal cat = null;
//    cat.makeSound();
    try {
      test(false);
      System.out.println("After test method");
    } catch (IOException | NullPointerException e) {
      System.out.println("catch IOException");
    } catch (Exception e) {
      System.out.println("catch Exception");
    } finally {
      System.out.println("Finally ");
    }

  }

  public static void iterateArray() {
    int array[] = {1, 2, 3, 4};

    for (int i = 0; i < 10; i++) {
      System.out.println(array[i]);
    }
  }
  public static void testMyexception()  {
    throw new MyCustomException();
  }

  public static void test(boolean flag) throws Exception {
    if (flag) {
      throw new Exception();
    } else {
      throw new IOException();
    }
  }
}
