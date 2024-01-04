package org.example.test_1Z0816.ch13.q53;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Order> list = List.of(new Order("apple", 100), new Order("banana", 80));
        BinaryOperator<Integer> op = (a,b) -> a+b;

        Stream<Integer> integerStream = list.stream().map(o -> o.getPrice() * 10);
        Integer total1 = integerStream.reduce(0, op);

        IntStream intStream = list.stream().mapToInt(o -> o.getPrice() * 10);
        // Required : IntBinaryOperator
        // Provided : BinaryOperator<java.lang.Integer>
        //int total2 = intStream.reduce(0, op);

    }
}
