package org.example.ch13.q55;

public interface Q55MyInterface {
    void test();

    default void defaultTest() {
        System.out.println("Q55MyInterface defaultTest");
    }

    default void defaultTest2() {
        System.out.println("Q55MyInterface defaultTest2");
    }
}
