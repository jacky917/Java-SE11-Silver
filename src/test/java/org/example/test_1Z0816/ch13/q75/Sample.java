package org.example.test_1Z0816.ch13.q75;

import java.util.List;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {

        final List<String> list1 = List.of("A", "B", "C", "D");
        final List<String> list2 = List.of("D", "E", "F", "G");

        // 0,1,2,3
        IntStream.range(0, Math.min(list1.size(),list2.size())).peek(System.out::println)
                .mapToObj((i) -> list1.get(i) + " " + list2.get(i)).forEach(System.out::println);

    }
}
