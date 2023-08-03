package org.example.ch13.q32;

public class MyClass implements SubInterface{
    @Override
    public void test2() {

    }

    static void staticMethod() {
        System.out.println("MyClass staticMethod");
    }

    public Number getNum(){
        return 10;
    }
}
