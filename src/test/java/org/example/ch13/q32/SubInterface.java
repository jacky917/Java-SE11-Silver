package org.example.ch13.q32;

public interface SubInterface extends MyInterface{
    @Override
    default void test() {
        System.out.println("default SubInterface");
    }

    static void test3() {
        System.out.println("SubInterface static method");
    }

    // Static methods cannot be annotated with @Override
    // Static method 'test2()' in 'org.example.ch13.q32.SubInterface' cannot override instance method 'test2()' in 'org.example.ch13.q32.MyInterface'
//    static void test2() {
//        System.out.println("static SubInterface");
//    }
}
