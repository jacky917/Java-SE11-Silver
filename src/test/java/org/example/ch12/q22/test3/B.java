package org.example.ch12.q22.test3;

public class B extends A implements I{
    @Override
    public void test() {
        super.test();
        System.out.println("B");
        I.super.test();
    }
}
