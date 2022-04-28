package eu.dreamix.library.controllers;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eu.dreamix.library.dtos.BookDTO;
import eu.dreamix.library.services.BookService;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return  bookService.getAllBooks()
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{isbn}")
    public BookDTO getBook(@PathVariable("isbn") String isbn) {
        return new BookDTO(bookService.getBook(isbn));
    }

    @PostMapping
    public void addBook (@Valid @RequestBody BookDTO bookDTO) {
        bookService.addBook(bookService.toBook(bookDTO));
    }

    @PutMapping
    public void updateBook(@Valid @RequestBody BookDTO bookDTO) {
        bookService.updateBook(bookService.toBook(bookDTO));
    }

    @DeleteMapping(path = "{isbn}")
    public void deleteBook(@PathVariable("isbn") String isbn) {
        bookService.deleteBook(isbn);
    }
}
