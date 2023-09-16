package org.example.test_1Z0815.ch12.o1.test1;

public class Children extends Parent{

    static {
        System.out.println("Children 靜態代碼塊1");
    }
    {
        System.out.println("Children 代碼塊1");
    }
    public Children() {
        System.out.println("Children 構造器");
    }
    static {
        System.out.println("Children 靜態代碼塊2");
    }
    {
        System.out.println("Children 代碼塊2");
    }
}
