package org.example.ch13.q32;

public class SubClass extends  MyClass{

    static void staticMethod() {
        System.out.println("SubClass staticMethod");
    }

    @Override
    public Integer getNum() {
        return 5;
    }
}
