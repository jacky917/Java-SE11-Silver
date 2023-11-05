package org.example.test_1Z0816.ch03.o06;

/**
 * 線程的六種狀態
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        Thread thread1 = new Thread(() -> {
            try {
                for(int i = 0 ; i < 2 ; i ++) {
                    Thread.sleep(100);
                    synchronized ("lock") {
                        Thread.sleep(100);
                        if (i == 0)
                            System.out.println("main    State : " + main.getState());
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized ("lock") {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread1 State : " + thread1.getState());
            }
        });
        System.out.println("thread1 State : " + thread1.getState());
        thread1.start();
        System.out.println("thread1 State : " + thread1.getState());
        Thread.sleep(10);
        System.out.println("thread1 State : " + thread1.getState());
        thread2.start();
        thread1.join();
        System.out.println("thread1 State : " + thread1.getState());


        System.out.println("=============================");

        Main test = new Main();

        Thread thread3 = new Thread(() -> {
            new Main().synchronizedTest();
//            test.synchronizedTest();
        });

        Thread thread4 = new Thread(() -> {
            new Main().synchronizedTest();
//            test.synchronizedTest();
        });
        thread3.start();
        thread4.start();
    }

    // 同步方法，鎖是 this
    synchronized void synchronizedTest() {
        System.out.println("synchronizedTest");
        System.out.println(this);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
