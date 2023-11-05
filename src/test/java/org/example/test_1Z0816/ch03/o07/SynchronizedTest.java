package org.example.test_1Z0816.ch03.o07;

public class SynchronizedTest {

    private static int tickets = 100;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {
                synchronized ("lock") {
                    if (tickets <= 0) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " 線程排隊等新票");
                            "lock".wait();
                            continue;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " 線程，賣出一張票，剩餘 " + --tickets + " 張票");
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized ("lock") {
                    System.out.println("======================");
                    tickets = tickets + 100;
                    System.out.println(Thread.currentThread().getName() + " 線程，補充 " + 100 + " 張票，剩餘 " + tickets + " 張票");
                    "lock".notifyAll();
                }
            }
        }).start();
    }
}
