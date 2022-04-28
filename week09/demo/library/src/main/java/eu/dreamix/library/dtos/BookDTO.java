package eu.dreamix.library.dtos;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import eu.dreamix.library.models.Book;

public class BookDTO {

    @Positive
    public int numOfPages;

    @Min(1900)
    public int releaseYear;

    @NotEmpty(message = "Title must not be empty!")
    public String title;

    @NotEmpty(message = "Authors must not be empty!")
    public Set<AuthorDTO> authors;

    @Size(min = 10, max = 13)
    public String isbn;

    @NotEmpty(message = "Genre must not be empty!")
    public String genre;

    @NotEmpty(message = "First name must not be empty!")
    public String addedByFirstName;

    @NotEmpty(message = "Last name must not be empty!")
    public String addedByLastName;

    @NotEmpty(message = "Position must not be empty!")
    public String addedByPosition;

    public BookDTO(){}

    public BookDTO(Book book) {
        numOfPages = book.getNumOfPages();
        releaseYear = book.getReleaseYear();
        title = book.getTitle();
        authors = book.getAuthors().stream().map(AuthorDTO::new).collect(Collectors.toSet());
        isbn = book.getIsbn();
        genre = book.getGenre().getName();
        addedByFirstName = book.getAddedBy().getFirstName();
        addedByLastName = book.getAddedBy().getLastName();
        addedByPosition = book.getAddedBy().getPosition().toString();
    }
}
