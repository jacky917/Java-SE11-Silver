package org.example.test_1Z0816.ch03.o03;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("MyCallable");
        return 0;
    }
}
