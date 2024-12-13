package salva_cao.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import salva_cao.api.model.Animal;
import salva_cao.api.model.OrderItem;

import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
}
