package org.example.ch12.q22.test2;

public interface B extends A{
    default void sample() {
        System.out.println("B");
    }
}
