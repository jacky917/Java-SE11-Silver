package org.example.test_1Z0815.ch12.o1.test1;

public class Parent {
    static {
        System.out.println("Parent 靜態代碼塊1");
    }
    {
        System.out.println("Parent 代碼塊1");
    }
    public Parent() {
        System.out.println("Parent 構造器");
    }
    static {
        System.out.println("Parent 靜態代碼塊2");
    }
    {
        System.out.println("Parent 代碼塊2");
    }
}
