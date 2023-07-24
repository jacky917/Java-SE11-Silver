package org.example.ch10.q06;

public class Main {
    public static void main(String[] args) {
        System.out.println(sample());
    }
    private static int sample() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            return 10;
        } finally {
            return 20;
        }
    }
}
