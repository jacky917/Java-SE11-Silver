package org.example.test_1Z0815.ch09.q11;

import java.util.Objects;

public class Item {
    private String name;
    private int price;
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
