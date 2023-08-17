package org.example.test_1Z0816.ch01.q03;

public class Outer {
    class Inner1 {
        Inner1 inner1 = new Inner1();
    }
    static class Inner2 {
        Inner2 inner2 = new Inner2();
    }

    public static void main(String[] args) {
        Inner2 inner1 = new Inner2();
        Inner2 inner2 = new Outer.Inner2();
    }
}