package org.example.ch12.q22.test2;

public class C implements B{
    @Override
    public void sample() {
        B.super.sample();
        System.out.println("C");
    }
}
