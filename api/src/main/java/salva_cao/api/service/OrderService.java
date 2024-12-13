package salva_cao.api.service;

import org.springframework.stereotype.Service;
import salva_cao.api.model.Order;
import salva_cao.api.model.OrderItem;
import salva_cao.api.repository.OrderItemRepository;
import salva_cao.api.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    // Create a new order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Retrieve an order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        Iterable<Order> orders = orderRepository.findAll();
        return new ArrayList<>((Collection<? extends Order>) orders);
    }

    // Update an existing order
    public Order updateOrder(Long id, Order order) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Order with id: " + id + " does not exist");
        }
        order.setId(id);
        return orderRepository.save(order);
    }

    // Delete an order by ID
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Order with id: " + id + " does not exist");
        }
        orderRepository.deleteById(id);
    }

    // Create a new order item
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Retrieve all items for a specific order
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
}
