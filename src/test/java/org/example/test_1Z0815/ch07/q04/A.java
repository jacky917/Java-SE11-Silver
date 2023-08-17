package org.example.test_1Z0815.ch07.q04;

public interface A {
    default void sample1() {
        System.out.println("sample1");
    }

    static void sample2() {
        System.out.println("sample2");
    }
}
