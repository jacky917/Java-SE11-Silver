package org.example.test_1Z0815.ch12.q24;

public interface IB extends IA{
    @Override
    default void sample(){
        System.out.println("IB");
    }

    static void test(){
        System.out.println("test");
    }
}
