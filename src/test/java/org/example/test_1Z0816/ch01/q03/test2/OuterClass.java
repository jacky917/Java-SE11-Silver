package org.example.test_1Z0816.ch01.q03.test2;

public class OuterClass {
    static {
        System.out.println("Static block of OuterClass executed.");
    }

    {
        System.out.println("block of OuterClass executed.");
    }

    public OuterClass() {
        System.out.println("OuterClass constructor called.");
    }

    public static class StaticInnerClass {
        public StaticInnerClass() {
            System.out.println("StaticInnerClass constructor called.");
        }
    }

    public static void main(String[] args) {
        OuterClass.StaticInnerClass innerInstance = new OuterClass.StaticInnerClass();
    }
}