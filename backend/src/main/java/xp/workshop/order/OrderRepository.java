package xp.workshop.order;

import xp.workshop.order.domain.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
}
