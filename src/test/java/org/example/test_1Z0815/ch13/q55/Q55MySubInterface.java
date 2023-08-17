package org.example.test_1Z0815.ch13.q55;


public interface Q55MySubInterface extends Q55MyInterface {
    void test();

    @Override
    default void defaultTest() {
        System.out.println("Q55MySubInterface defaultTest");
    }
}
