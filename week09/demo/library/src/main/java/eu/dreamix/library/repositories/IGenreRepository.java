package eu.dreamix.library.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import eu.dreamix.library.models.Genre;

public interface IGenreRepository extends CrudRepository<Genre, Long> {
    Optional<Genre> findByName(String genre);
}
