package org.example.test_1Z0816.ch03.o04;

import java.util.concurrent.*;

public class CustomThreadPoolDemo {
    public static void main(String[] args) {
        int corePoolSize = 2;  // 核心線程數
        int maxPoolSize = 4;   // 最大線程數
        long keepAliveTime = 10; // 非核心線程空閒時的存活時間
        TimeUnit unit = TimeUnit.SECONDS; // keepAliveTime 的時間單位
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(10); // 工作隊列容量

        // 創建線程工廠
        ThreadFactory threadFactory = new ThreadFactory() {
            private int count = 1;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("CustomThread-" + count++);
                return thread;
            }
        };

        // 創建拒絕策略
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();

        // 創建線程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                rejectedExecutionHandler
        );

        // 提交任務到線程池
        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " executing task " + taskNo);
                try {
                    Thread.sleep(2000); // 模擬任務執行時間
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 關閉線程池
        executor.shutdown();
    }
}