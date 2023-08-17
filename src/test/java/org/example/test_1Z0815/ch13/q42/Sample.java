package org.example.test_1Z0815.ch13.q42;

public class Sample implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("AutoCloseable");
    }
}
