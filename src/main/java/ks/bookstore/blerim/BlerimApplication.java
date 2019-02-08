package ks.bookstore.blerim;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ks.bookstore.blerim.domain.Book;
import ks.bookstore.blerim.domain.BookRepository;
import ks.bookstore.blerim.domain.Category;

@SpringBootApplication
public class BlerimApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlerimApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoBooStoreData(BookRepository repository) {
		return(args) -> {
			
			Book b1 = new Book("Java How to Program (11th Edition)", "Paul J. Deitel", "978-0134743356", 2016, new Category("Programming"));
			Book b2 = new Book("Full Stack Development with spring boot and react", "Juha Hinkula", "078-1-78913-808-5", 2018, new Category("Programming"));
			Book b3 = new Book("Ernest Hemingway", "A farwell to Arms", "1232323-21", 1929,new Category("Online book"));
			Book b4 = new Book("George Orwell", "Animal Farm", "2212343-5", 1945, new Category("Online book"));
			Book b5= new Book("Blerim", "AI Impact", "2344556767", 2019, new Category("IT"));
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
			repository.save(b4);
			repository.save(b5);
		};
	}

}

