package hh.sof003.bookstore;

import org.h2.command.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof003.bookstore.domain.Book;
import hh.sof003.bookstore.domain.BookRepository;
import hh.sof003.bookstore.domain.Category;
import hh.sof003.bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner addBooks(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Mistborn: The Final Empire", "Brandon Sanderson","9780765311788", 9.99, 2006));
			repository.save(new Book("Soul Hunter", "Aaron Dembski-Bowden","9780001809328", 13.99, 2010));
			repository.save(new Book("Isles of the Emberdark", "Brandon Sanderson","9780000000000", 13.99, 2025));
		};
	}

	@Bean
	public CommandLineRunner addCategories(CategoryRepository repository) {
		return (args) -> {
			repository.save(new Category("Fantasy"));
			repository.save(new Category("Science Fiction"));
			repository.save(new Category("Horror"));
		};
	
	}

}