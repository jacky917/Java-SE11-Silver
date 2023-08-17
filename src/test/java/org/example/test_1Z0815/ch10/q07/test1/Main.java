package org.example.test_1Z0815.ch10.q07.test1;

public class Main {
    public static void main(String[] args) {
        System.out.println(sample());
    }
    private static int sample() {
        int val = 0;
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            val = 10;
            return val;
        } finally {
            val += 10;
        }
    }
}
