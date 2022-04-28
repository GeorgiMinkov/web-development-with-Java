package eu.dreamix.library.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.dreamix.library.models.Genre;
import eu.dreamix.library.repositories.IGenreRepository;

@Service
public class GenreService {

    @Autowired
    private IGenreRepository genreRepository;

    public Optional<Genre> findByName(String name) {
        return genreRepository.findByName(name);
    }
}
