package kt.sw20.Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import kt.sw20.Bookstore.domain.Book;
import kt.sw20.Bookstore.domain.Category;
import kt.sw20.Bookstore.repositories.BookRepository;
import kt.sw20.Bookstore.repositories.CategoryRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner booklistDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Knowledge"));
			crepository.save(new Category("Comedy"));
			
			brepository.save(new Book("Kirja", "Matti Mikkonen", "1234", "2019", crepository.findByName("Horror").get(0)));
			brepository.save(new Book("Uusi kirja", "Pertti Pekkonen", "5433", "2019", crepository.findByName("Scifi").get(0)));	
			
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
