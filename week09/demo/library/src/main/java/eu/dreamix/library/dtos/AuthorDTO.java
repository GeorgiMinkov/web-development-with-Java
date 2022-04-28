package eu.dreamix.library.dtos;

import eu.dreamix.library.models.Author;

import javax.validation.constraints.NotEmpty;

public class AuthorDTO {

    public Long id;

    @NotEmpty(message = "First name must not be empty!")
    public String firstName;

    @NotEmpty(message = "Last name must not be empty!")
    public String lastName;

    public AuthorDTO() {}

    public AuthorDTO(Author author) {
        firstName = author.getFirstName();
        lastName = author.getLastName();
    }
}
