package xp.workshop.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return repository.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return repository.findOrder(id);
    }
}