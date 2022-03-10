package xp.workshop.order;

import xp.workshop.order.domain.Order;

import java.util.List;

public class StubOrderRepository implements OrderRepository {
    private List<Order> findAll_returnValue;

    @Override
    public List<Order> findAll() {
        return findAll_returnValue;
    }

    public void setFindAll_returnValue(List<Order> findAll_returnValue) {
        this.findAll_returnValue = findAll_returnValue;
    }
}
