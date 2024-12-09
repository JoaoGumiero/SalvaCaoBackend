package salva_cao.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import salva_cao.api.model.Person;
import salva_cao.api.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
