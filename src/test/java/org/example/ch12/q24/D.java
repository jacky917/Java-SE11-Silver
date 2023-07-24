package org.example.ch12.q24;

public class D implements IB,IC{
    @Override
    public void sample() {
        // Cannot resolve method 'sample' in 'Object'
        IB.super.sample();
    }

    public static void main(String[] args) {
        D d = new D();
        d.sample();
    }
}
