package salva_cao.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import salva_cao.api.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
