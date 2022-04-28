package eu.dreamix.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.dreamix.library.models.Book;

@Repository
public interface IBookRepository extends CrudRepository<Book, String> {}
