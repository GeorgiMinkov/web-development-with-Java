package lecture.week02.inheritance;

import java.math.BigDecimal;
import java.util.Objects;

public class Cat extends Animal {

  private String name;

  @Override
  public void makeSound() {
    System.out.println("Meow");
  }

  public Cat() {
    this("Tom", new BigDecimal(10));
  }

  public Cat(String name, BigDecimal weight) {
    super(weight);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Cat)) {
      return false;
    }
    Cat cat = (Cat) o;
    return Objects.equals(name, cat.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Cat{" +
        "name='" + name + '\'' +
        ", weight=" + weight +
        '}';
  }
}
