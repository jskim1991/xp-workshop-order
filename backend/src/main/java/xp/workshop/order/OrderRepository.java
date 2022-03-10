package xp.workshop.order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();

    Order findOrder(String orderId);
}
