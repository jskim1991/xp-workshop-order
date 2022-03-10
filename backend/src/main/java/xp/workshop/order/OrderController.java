package xp.workshop.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xp.workshop.order.domain.Order;

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
}