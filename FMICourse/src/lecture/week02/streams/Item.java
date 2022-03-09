package lecture.week02.streams;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
  private String description;
  private BigDecimal price;

  public Item() {
  }

  public Item(String description, BigDecimal price) {
    this.description = description;
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Item{" +
        "description='" + description + '\'' +
        ", price=" + price +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(description, item.description) &&
        Objects.equals(price, item.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, price);
  }
}
