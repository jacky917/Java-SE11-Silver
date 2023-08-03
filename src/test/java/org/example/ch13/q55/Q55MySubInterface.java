package org.example.ch13.q55;


public interface Q55MySubInterface extends Q55MyInterface {
    void test();

    @Override
    default void defaultTest() {
        System.out.println("Q55MySubInterface defaultTest");
    }
}
