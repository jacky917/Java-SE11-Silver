package org.example.test_1Z0816.ch03.o07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 賣票系統(ReentrantLock)
 */
public class ConditionTest {

    private static int tickets = 100;

    private static final Lock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    private static void SupplementaryTickets(int n) {
        new Thread(() -> {
            lock.lock();
            try {
                tickets = tickets + n;
                System.out.println("=====================");
                System.out.println(Thread.currentThread().getName() + " 線程，補充 " + n + " 張票，剩餘 " + tickets + " 張票");
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }).start();
    }

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        if (tickets <= 0) {
                            System.out.println(Thread.currentThread().getName() + " 線程排隊等新票");
                            condition.await();
                            continue;
                        }
                        System.out.println(Thread.currentThread().getName() + " 線程，賣出一張票，剩餘 " + --tickets + " 張票");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        List<Thread> ticketWindow = new ArrayList<>(5);
        ticketWindow.add(new Thread(runnable));
        ticketWindow.add(new Thread(runnable));
        ticketWindow.add(new Thread(runnable));
        ticketWindow.add(new Thread(runnable));
        ticketWindow.add(new Thread(runnable));

        for(Thread thread: ticketWindow) {
            thread.start();
        }

        while (true) {
            try {
                Thread.sleep(1000);
                if (tickets <= 0) {
                    SupplementaryTickets(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
