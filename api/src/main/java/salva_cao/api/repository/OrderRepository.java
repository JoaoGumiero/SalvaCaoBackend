package salva_cao.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import salva_cao.api.model.Animal;
import salva_cao.api.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
