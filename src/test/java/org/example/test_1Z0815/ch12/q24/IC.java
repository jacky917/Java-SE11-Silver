package org.example.test_1Z0815.ch12.q24;

public interface IC extends IA{
    @Override
    default void sample(){
        System.out.println("IC");
    }
}