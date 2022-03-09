package lecture.week02.inheritance;

import java.math.BigDecimal;

public class Dog extends Animal {

  @Override
  public void makeSound() {
    System.out.println("bau");
  }

  public Dog(BigDecimal weight ){
    super(weight);
  }
}
