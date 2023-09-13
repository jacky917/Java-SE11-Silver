package org.example.test_1Z0816.ch01.q11;

public interface C extends B{
    default void test2() {
        System.out.println("C test2");
    }
}
