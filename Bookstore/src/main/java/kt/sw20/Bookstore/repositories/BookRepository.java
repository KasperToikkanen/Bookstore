package kt.sw20.Bookstore.repositories;

import java.util.List;

import kt.sw20.Bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByTitleOrderByTitleAsc(String title);
	
	

}
