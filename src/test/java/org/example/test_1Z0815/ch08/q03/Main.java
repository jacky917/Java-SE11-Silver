package org.example.test_1Z0815.ch08.q03;

public class Main {
    public static void main(String[] args) {
        String val = "val";

        // 題目
        // Variable 'val' is already defined in the scope
//         Consumer c1 = (val) -> {
//             System.out.println(val);
//         };

        // 補充
        // 可以直接使用val，查看 ch12#q04
        Consumer c2 = (a) -> {
            System.out.println(a);
            System.out.println(val);
        };

        c2.test("x");
    }
}
