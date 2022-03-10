package xp.workshop.order;

import lombok.Getter;

@Getter
public class Order {

    private String id;
    private int totalPrice;

    public Order(String id, int totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }
}
