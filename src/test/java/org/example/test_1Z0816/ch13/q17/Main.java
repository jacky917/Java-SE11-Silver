package org.example.test_1Z0816.ch13.q17;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Item> items = List.of(new Item("A", 100), new Item("B", 200), new Item("C", 300));

        // 題目給的正確方法1
        Stream<Item> stream1 = items.stream();
        stream1.filter(item -> item.getPrice() > 200).forEach(System.out::println);

        // 題目給的正確方法2
        Stream stream2 = items.stream();
        stream2.filter(item -> ((Item)item).getPrice() > 200).forEach(System.out::println);
    }
}
