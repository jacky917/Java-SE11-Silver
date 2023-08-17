package org.example.test_1Z0816.ch01.q13;

public abstract class B {
    /**
     * 當實現的接口和繼承的類有相同方法時，權限修飾符必須一樣，否則子類必須重寫方法
     */
    protected void test() {
        System.out.println("B");
    }
}
