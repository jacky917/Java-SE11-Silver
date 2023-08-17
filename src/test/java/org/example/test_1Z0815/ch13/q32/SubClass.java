package org.example.test_1Z0815.ch13.q32;

public class SubClass extends  MyClass{

    static void staticMethod() {
        System.out.println("SubClass staticMethod");
    }

    @Override
    public Integer getNum() {
        return 5;
    }
}
