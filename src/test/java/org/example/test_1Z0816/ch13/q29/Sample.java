package org.example.test_1Z0816.ch13.q29;

public class Sample {

    private static void test() throws TestException {
        try {
            throw new TestException("A");
        } catch (SampleException | RuntimeException e) {
            throw new RuntimeException("B");
        }
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
