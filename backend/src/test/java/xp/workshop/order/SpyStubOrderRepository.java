package xp.workshop.order;

import java.util.List;

public class SpyStubOrderRepository implements OrderRepository {
    private List<Order> findAll_returnValue;
    private Order findOrder_returnValue;
    private String findOrder_parameter;
    private int findOrder_calledTimes;

    @Override
    public List<Order> findAll() {
        return findAll_returnValue;
    }

    @Override
    public Order findOrder(String orderId) {
        findOrder_calledTimes++;
        findOrder_parameter = orderId;
        return findOrder_returnValue;
    }

    public void setFindAll_returnValue(List<Order> findAll_returnValue) {
        this.findAll_returnValue = findAll_returnValue;
    }

    public void setFindOrder_returnValue(Order findOrder_returnValue) {
        this.findOrder_returnValue = findOrder_returnValue;
    }

    public String getFindOrder_parameter() {
        return findOrder_parameter;
    }

    public int getFindOrder_calledTimes() {
        return findOrder_calledTimes;
    }
}
