package com.fmi.web.bookstoreproject.repository;

import com.fmi.web.bookstoreproject.model.Book;
import java.util.List;

public interface CRUD {

  void add(Book book);

  Book update(Book book);

  void remove(String isbn);

  Book getByKey(String isbn);

  List<Book> getAll();

  void clear();
}
