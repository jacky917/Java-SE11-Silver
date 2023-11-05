package org.example.test_1Z0816.ch01.q09;

public class D implements A{

    public void xxx() {
        A.super.test2();
    }
    public static void main(String[] args) {
        A.test();
        // B並沒有繼承到方法，靜態方法是跟著類或是接口的
        // B.test();
        // C並沒有繼承到方法，靜態方法是跟著類或是接口的
        // C.test();
        // 調用實現類接口需要指名，因爲Java可以多實現，必須顯式的寫出來
        // test();
        new D().xxx();
        B b = new B(){};
        b.test2();

        C c = new C();
        c.test2();
    }
}
