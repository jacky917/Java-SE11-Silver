package org.example.ch12.q35;

public class B extends A{

    private void print() {
        System.out.println("B private");
    }
    @Override
    public void print2() {
        System.out.println("B public");
    }

    public void b() {
        print();
        print2();
    }
    public static void main(String[] args) {
        B b = new B();
        b.a();
        System.out.println("---------");
        b.b();
    }
}
