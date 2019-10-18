package kt.sw20.Bookstore.repositories;

import java.util.List;
import kt.sw20.Bookstore.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findByName(String name);
	
	

}
