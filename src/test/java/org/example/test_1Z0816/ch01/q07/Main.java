package org.example.test_1Z0816.ch01.q07;

public class Main {
    public static void main(String[] args) {
        var sample = new Sample(10) {
            void modify(int num) {
                setNUm(num);
            }
        };
        sample.modify(100);
        System.out.println(sample.getNum());
        // 匿名類的 getSimpleName 是空的。
        System.out.println(sample.getClass().getSimpleName());
    }
}
