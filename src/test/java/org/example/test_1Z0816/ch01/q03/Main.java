package org.example.test_1Z0816.ch01.q03;

public class Main {
    public static void main(String[] args) {
        // 非靜態要先實例外部類，才能創建內部類
        Outer.Inner1 inner1 = new Outer().new Inner1();
        // 靜態只需要一個 new
        Outer.Inner2 inner2 = new Outer.Inner2();
    }
}
