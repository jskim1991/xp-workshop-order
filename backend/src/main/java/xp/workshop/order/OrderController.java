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
        // 비즈니스 로직이 단순해서 사실 리팩토링 할 여지가 보이지 않아요.
        // 하드코딩 - ? 하드 ? 유연하지 못해요 항상 고정된 값이 나
        // 클래스가 하나 더 필요해요
        // 계층을 나누면 좋겠지만, 데이터베이스 조회를 위한 객체를 만들께요.
        return repository.findAll();
    }
}