package org.example.test_1Z0815.ch12.q35;

public class A {
    private void print() {
        System.out.println("A private");
    }

    public void print2() {
        System.out.println("A public");
    }

    public void a() {
        print();
        print2();
    }
}
