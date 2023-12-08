package org.example.test_1Z0816.ch01.q04;

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        Outer.Inner2 inner2 = new Outer.Inner2();
        inner.execute();
        inner2.execute();
    }
}
