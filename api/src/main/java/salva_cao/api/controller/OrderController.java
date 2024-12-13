package salva_cao.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salva_cao.api.model.Order;
import salva_cao.api.model.OrderItem;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    // Retrieve an order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Retrieve all orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

    // Delete an order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // Create a new order item
    @PostMapping("/{orderId}/items")
    public ResponseEntity<OrderItem> createOrderItem(@PathVariable Long orderId, @RequestBody OrderItem orderItem) {
        orderItem.setOrder(new Order(orderId)); // Ensure the item is linked to the order
        return ResponseEntity.ok(orderService.createOrderItem(orderItem));
    }

    // Retrieve all items for a specific order
    @GetMapping("/{orderId}/items")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderItemsByOrderId(orderId));
    }
}
