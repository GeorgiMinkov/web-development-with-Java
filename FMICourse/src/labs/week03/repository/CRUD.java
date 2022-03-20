package labs.week03.repository;

import java.util.List;
import labs.week03.model.Book;

public interface CRUD {

  void add(Book book);

  Book update(Book book);

  void remove(String isbn);

  Book getByKey(String isbn);

  List<Book> getAll();

  void clear();
}
