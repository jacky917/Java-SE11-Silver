package org.example.ch13.q55;


public class MyClass implements Q55MyInterface, Q55MySubInterface {
    @Override
    public void test() {

    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.test();
        myClass.defaultTest();
        myClass.defaultTest2();
    }
}
