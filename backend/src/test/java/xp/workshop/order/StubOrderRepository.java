package xp.workshop.order;

import xp.workshop.order.domain.Order;

import java.util.List;

public class StubOrderRepository implements OrderRepository {
    private List<Order> returnValueForFindAll;

    @Override
    public List<Order> findAll() {
        return returnValueForFindAll;
    }

    public void returnValueForFindAll(List<Order> returnValueForFindAll) {
        this.returnValueForFindAll = returnValueForFindAll;
    }

    public void setReturnValueForFindAll(List<Order> returnValueForFindAll) {
        this.returnValueForFindAll = returnValueForFindAll;
    }
}
