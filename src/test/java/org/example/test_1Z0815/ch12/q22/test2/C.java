package org.example.test_1Z0815.ch12.q22.test2;

public class C implements B{
    @Override
    public void sample() {
        B.super.sample();
        System.out.println("C");
    }
}
