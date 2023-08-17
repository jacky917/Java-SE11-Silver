package org.example.test_1Z0815.ch13.q55;


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
