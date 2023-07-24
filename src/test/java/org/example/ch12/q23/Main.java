package org.example.ch12.q23;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        A a1 = new A();
        A a2= new B();
        B b1 = new B();

        ArrayList<String> list = new ArrayList<>();

        a1.sample(list);
        a2.sample(list);
        b1.sample(list);

        a2.sample2(list);

        // 補充測試
        a1.sample3(1);
    }
}
