package eu.dreamix.library.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.dreamix.library.repositories.IAuthorRepository;
import eu.dreamix.library.models.Author;


@Service
public class AuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    public Optional<Author> findByFirstNameAndLastName(String firstName, String lastName) {
        return  authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
