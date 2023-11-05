package org.example.test_1Z0816.ch01.q09;

public interface A {
    static void test() {
        System.out.println("A1");
    }

    default void test2() {
        System.out.println("A2");
    }
}
