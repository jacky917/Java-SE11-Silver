package org.example.test_1Z0816.ch09.q06;

public class Sample implements AutoCloseable{

    private boolean isClosed = false;
    @Override
    public void close() throws Exception {
        isClosed = true;
        System.out.println("AutoCloseable");
    }

    public boolean isClosed() {
        return isClosed;
    }
}
