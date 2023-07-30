package org.example.ch12.q24;

public interface IC extends IA{
    @Override
    default void sample(){
        System.out.println("IC");
    }
}