package org.example.ch13.q33;


public class Sample {
    public void test(Object[] val) {
        System.out.println("Object[]");
    }
    public void test(long[] val) {
        System.out.println("long[]");
    }

    public void test(int[] val) {
        System.out.println("int[]");
    }
    public void test(Object val) {
        System.out.println("Object");
    }

    public void test2(Object val) {
        System.out.println("Object");
    }

    public void test2(double val) {
        System.out.println("double");
    }

    public void test3(Number[] val) {
        System.out.println("Number[]");
    }

    public void test3(Object val) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        new Sample().test(new int[2]);
        new Sample().test2(10);
        new Sample().test3(new Integer[2]);
    }
}
