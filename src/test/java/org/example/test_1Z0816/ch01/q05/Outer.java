package org.example.test_1Z0816.ch01.q05;

public class Outer {
    void test() {
        Inner.message = "Hello, Java";
    }

    /**
     * 原本的題目使用非靜態內部類，但包含了靜態成員變量，編譯錯誤
     */
    static class Inner {
        private static String message;
        public void test() {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
        Inner inner = new Inner();
        inner.test();
    }
}
