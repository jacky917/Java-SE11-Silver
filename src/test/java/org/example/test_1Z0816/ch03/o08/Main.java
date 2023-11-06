package org.example.test_1Z0816.ch03.o08;

/**
 * ThreadLocal 實驗
 */
public class Main {

    /**
     * 試驗1:ThreadLocal在各自線程都有一份副本
     */
    public static void test1() {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "ThreadLocal");

        Runnable runnable = () -> {
            threadLocal.set(Thread.currentThread().getName() + " " + threadLocal.get());
            System.out.println(threadLocal.get());
        };

        for(int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }

    private static class TestClass2 {

        public TestClass2(int n) {
            test = n;
        }
        private int test;

        public int getTest() {
            return test;
        }

        public void setTest(int test) {
            this.test = test;
        }
    }

    static TestClass2 xxx = new TestClass2(0);

    private static class TestClass {
        private int count;
        private String name;

        private TestClass2 testClass2;
        public TestClass(int c,String name) {
//            testClass2 = new TestClass2(0);
            testClass2 = xxx;
            this.count = c;
            this.name = name;
        }

        @Override
        public String toString() {
            return super.toString() + " TestClass{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    ", TestClass2='" + getTestClass2().getTest() + '\'' +
                    '}';
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TestClass2 getTestClass2() {
            return testClass2;
        }

        public void setTestClass2(TestClass2 testClass2) {
            this.testClass2 = testClass2;
        }
    }

    /**
     * 試驗2:ThreadLocal並沒有深拷貝的效果(static TestClass2)
     */
    public static void test2() {
        ThreadLocal<TestClass> testClassThreadLocal = ThreadLocal.withInitial(() -> new TestClass(0,"init"));

        Runnable runnable = () -> {
            TestClass testClass = testClassThreadLocal.get();
            TestClass2 testClass2 = testClass.getTestClass2();
            System.out.println(testClass2);
            testClass2.setTest(testClass2.getTest() + 1);
            testClass.setName("changed");
            testClass.setCount(testClass.getCount() + 1);
            System.out.println(testClass);
        };

        for(int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }
    }

    public static void main(String[] args) {
        test2();
    }
}
