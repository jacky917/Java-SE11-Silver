package org.example.ch10.q07.test2;

public class Main {
    public static void main(String[] args) {
        System.out.println(sample().getI());
    }
    private static q07Test sample() {
        q07Test test = new q07Test();
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            test.setI(10);
            return test;
        } finally {
            test.setI(30);
        }
    }
}
