package xp.workshop.order;

import org.springframework.stereotype.Repository;
import xp.workshop.order.domain.Order;

import java.util.Arrays;
import java.util.List;

@Repository
public class InMemoryOrderStore implements OrderRepository {

    @Override
    public List<Order> findAll() {
        // 하드 코딩
        return Arrays.asList(
                new Order("1", 1000),
                new Order("2", 2000),
                new Order("3", 3000)
        );
    }
}
