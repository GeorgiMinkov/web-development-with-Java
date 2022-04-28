package eu.dreamix.library.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends Paper {

    @Column
    private int numOfPages;

    @Column
    private int releaseYear;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = { @JoinColumn(name = "books_id") },
            inverseJoinColumns = { @JoinColumn(name = "authors_id") })
    private Set<Author> authors;

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
