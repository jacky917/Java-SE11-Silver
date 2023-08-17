package org.example.test_1Z0816.ch01.q04;

public class Main {
    public static void main(String[] args) {
        // 外部類不需要執行構造函數，即內部類可以實例化
        Outer.Inner inner = new Outer.Inner();
    }
}
