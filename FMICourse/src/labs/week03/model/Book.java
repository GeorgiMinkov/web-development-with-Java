package labs.week03.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Book {
  private String ISBN;
  private String title;
  private String author;
  private BigDecimal price;
  private String publisher;
  private LocalDate publishedYear;


  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public LocalDate getPublishedYear() {
    return publishedYear;
  }

  public void setPublishedYear(LocalDate publishedYear) {
    this.publishedYear = publishedYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(ISBN, book.ISBN) &&
        Objects.equals(title, book.title) &&
        Objects.equals(author, book.author) &&
        Objects.equals(price, book.price) &&
        Objects.equals(publisher, book.publisher) &&
        Objects.equals(publishedYear, book.publishedYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ISBN, title, author, price, publisher, publishedYear);
  }
}
