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
import hh.sof003.bookstore.domain.User;


@SuppressWarnings("unused")
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner addData(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			Category category1 = new Category("Science fiction");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Horror");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			repository.save(new Book("Mistborn: The Final Empire", "Brandon Sanderson", "9780765311788", 9.99, 2006, category2));
			repository.save(new Book("Night Lords: The Omnibus", "Aaron Dembski-Bowden", "9780441569595", 21.99, 2014, category1));
			repository.save(new Book("Isles of the Emberdark", "Brandon Sanderson", "9780547928227", 15.99, 2025, category2));
			
			System.out.println("fetch all books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner addUsers(hh.sof003.bookstore.domain.UserRepository userRepository) {
		return (args) -> {
			User user1 = new User("user", "$2a$10$7eqJtq98hPqEX7fNZaFWoOa8d0N9vDU7Y6Nvm1y.6", "user@email.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@email.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};
	}
}