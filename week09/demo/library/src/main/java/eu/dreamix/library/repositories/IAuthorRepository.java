package eu.dreamix.library.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import eu.dreamix.library.models.Author;

public interface IAuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByFirstNameAndLastName(String first, String last);
}
