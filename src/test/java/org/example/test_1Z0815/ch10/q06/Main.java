package org.example.test_1Z0815.ch10.q06;

public class Main {
    public static void main(String[] args) {
        System.out.println(sample());
    }
    private static int sample() {
        try {
//            return 5;
            throw new RuntimeException();
        } catch (RuntimeException e) {
            return 10;
        } finally {
            return 20;
        }
    }
}
