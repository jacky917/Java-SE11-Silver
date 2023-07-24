package org.example.ch12.q10.test3;

public interface A {
    default void x() {
        System.out.println("Interface A calls function x");
    }
}
