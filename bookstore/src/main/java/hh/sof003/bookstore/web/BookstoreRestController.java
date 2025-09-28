package hh.sof003.bookstore.web;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import hh.sof003.bookstore.domain.Book;
import hh.sof003.bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class BookstoreRestController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private BookRepository repository;

    @GetMapping("/bookrest")
    public List<Book> getAllBooks() {
        return (List<Book>) repository.findAll();
    }
 
    @GetMapping("/bookrest/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return repository.findById(id);
    }
    }
    