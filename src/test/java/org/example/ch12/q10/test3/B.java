package org.example.ch12.q10.test3;

public interface B {
    default void x() {
        System.out.println("Interface B calls function x");
    }
}
