package org.example.ch13.q42;

public class Sample implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("AutoCloseable");
    }
}
