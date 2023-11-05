package org.example.test_1Z0816.ch03.o03;

import org.example.test_1Z0816.ch03.o02.MyRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 第三種開啟多線程的方式，實現Callable
 */
public class Main {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
         try {
            System.out.println(futureTask.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        FutureTask<String> futureTaskTest = new FutureTask<>(new MyRunnable(),"test");
        Thread threadTest = new Thread(futureTaskTest);
        threadTest.start();
        try {
            System.out.println(futureTaskTest.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
