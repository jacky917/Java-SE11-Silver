package org.example.test_1Z0816.ch09.q09;

import java.io.IOException;

public class Sample implements AutoCloseable{
    @Override
    public void close() throws IOException {
        System.out.println("AutoCloseable");
        throw new IOException("close method throw AutoCloseable IOException");
    }
}
