package org.example.test_1Z0816.ch01.q04;

public class Outer {
    public Outer() {
        System.out.println("Outer Constructor");
    }
    private int num = 2;
    public void hoge() {
        Inner test = new Inner();
        test.data = 100;
        test.execute();
    }
    public static class Inner {

        public Inner() {
            System.out.println("Inner Constructor");
        }
        private int data;
        void execute() {
            System.out.println("data = " + data);
            // 靜態內部類，只能獲取外部類的靜態成員變量
            // System.out.println(num * data);
        }
    }

    public static class Inner2 {

        public Inner2() {
            System.out.println("Inner2 Constructor");
        }
        private int data;
        void execute() {
            Inner test = new Inner();
            test.data = 100;
            test.execute();
        }
    }
}
