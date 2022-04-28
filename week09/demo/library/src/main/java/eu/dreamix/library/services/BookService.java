package eu.dreamix.library.services;

import java.util.*;

import eu.dreamix.library.dtos.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.dreamix.library.dtos.BookDTO;
import eu.dreamix.library.models.Author;
import eu.dreamix.library.models.Book;
import eu.dreamix.library.models.Employee;
import eu.dreamix.library.models.Genre;
import eu.dreamix.library.models.enums.Position;
import eu.dreamix.library.repositories.IBookRepository;

@Service
public class BookService {

    private static final String NOT_FOUND_MESSAGE = "Book is not found.";

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private GenreService genreService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AuthorService authorService;

    public List<Book> getAllBooks() {
        LinkedList<Book> allBooks = new LinkedList<>();
        bookRepository.findAll().forEach(allBooks::add);
        return allBooks;
    }

    public Book getBook(String isbn) {
        return bookRepository.findById(isbn).orElseThrow(() ->
                new NoSuchElementException (NOT_FOUND_MESSAGE));
    }

    public void addBook(Book book) {
        if (bookRepository.existsById(book.getIsbn())) {
            throw new IllegalArgumentException (
                    String.format("%s already exists.", book.getTitle())
            );
        }

        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        if (!bookRepository.existsById(book.getIsbn())) {
            throw new NoSuchElementException (NOT_FOUND_MESSAGE);
        }

        bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        if (!bookRepository.existsById(isbn)) {
            throw new NoSuchElementException (NOT_FOUND_MESSAGE);
        }

        bookRepository.deleteById(isbn);
    }

    public Book toBook(BookDTO dto) {
        Employee addedBy = employeeService.findByFirstNameAndLastName(dto.addedByFirstName, dto.addedByLastName).orElseGet(() -> {
            Employee employee = new Employee();
            employee.setPosition(Position.valueOf(dto.addedByPosition));
            employee.setFirstName(dto.addedByFirstName);
            employee.setLastName(dto.addedByLastName);
            return employee;
        });

        Set<Author> authors = new HashSet<>();
        for (AuthorDTO author: dto.authors) {
            Author newAuthor = authorService.findByFirstNameAndLastName(author.firstName, author.lastName).orElseGet(() -> {
                Author tmpAuthor = new Author();
                tmpAuthor.setFirstName(author.firstName);
                tmpAuthor.setLastName(author.lastName);
                return tmpAuthor;
            });
            authors.add(newAuthor);
        }

        Genre genre = genreService.findByName(dto.genre).orElseGet(() -> {
            Genre tempGenre = new Genre();
            tempGenre.setName(dto.genre);
            return tempGenre;
        });

        Book tempBook = new Book();

        tempBook.setNumOfPages(dto.numOfPages);
        tempBook.setReleaseYear(dto.releaseYear);
        tempBook.setAddedBy(addedBy);
        tempBook.setTitle(dto.title);
        tempBook.setAuthors(authors);
        tempBook.setIsbn(dto.isbn);
        tempBook.setGenre(genre);

        return tempBook;
    }
}
