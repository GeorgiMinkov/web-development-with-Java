package eu.dreamix.library.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import eu.dreamix.library.models.Magazine;

public class MagazineDTO {

    @NotNull
    public LocalDate dateOfIssue;

    @NotEmpty(message = "Title must not be empty!")
    public String title;

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

    MagazineDTO() {}

    public MagazineDTO(Magazine magazine) {
        dateOfIssue = magazine.getDateOfIssue();
        title = magazine.getTitle();
        isbn = magazine.getIsbn();
        genre = magazine.getGenre().getName();
        addedByFirstName = magazine.getAddedBy().getFirstName();
        addedByLastName = magazine.getAddedBy().getLastName();
        addedByPosition = magazine.getAddedBy().getPosition().toString();
    }
}
