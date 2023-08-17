package org.example.test_1Z0815.ch13.q30;

public class Main {
    public static void process(MyInterface i) {
        i.method();
    }
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        MySubClass mySubClass = new MySubClass();
        process(myClass);
        process(mySubClass);
    }
}
