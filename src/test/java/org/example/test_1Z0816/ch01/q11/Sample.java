package org.example.test_1Z0816.ch01.q11;

public class Sample implements A, D{
    @Override
    public void test() {
        A.super.test();
        // 'org.example.test_1Z0816.ch01.q11.B' is not an enclosing class
//        B.super.test();
        // 'org.example.test_1Z0816.ch01.q11.C' is not an enclosing class
//        C.super.test();
        D.super.test();
        D.super.test2();
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.test();
    }
}
