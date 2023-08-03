package org.example.ch13.q32;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.test();
        MyClass.staticMethod();
        SubClass.staticMethod();
        MyInterface.test3();
        SubInterface.test3();
        // 'Number' is abstract; cannot be instantiated
        // sNumber number = new Number();
    }
}
