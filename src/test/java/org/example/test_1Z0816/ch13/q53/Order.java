package org.example.test_1Z0816.ch13.q53;

public class Order {
    private String item;
    private int price;
    public Order(String item, int price) {
        super();
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }
}
