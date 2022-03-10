package xp.workshop.order.domain;

import lombok.Getter;

@Getter
public class Order {

    private String id;
    private int totalPrice;
    // private String note;

    public Order(String id, int totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }
}
