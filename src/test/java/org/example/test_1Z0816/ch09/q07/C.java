package org.example.test_1Z0816.ch09.q07;

public class C implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("C");
    }
}
