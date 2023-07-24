package org.example.ch08.q02;

public class Main {
    public static void main(String[] args) {
        Function f1 = (name) -> {
            return "hello, " + name;
        };

        // 有括號，必須有 return
        // Function f2 = (name) -> {
        //     "hello, " + name;
        // };

        // 沒括號不能有 return
        // Function f3 = (name) -> return "hello, " + name;

        Function f4 = (name) -> "hello, " + name;

        Function f5 = name -> {
            return "hello, " + name;
        };

        Consumer c1 = (name) -> {
            System.out.println("hello, " + name);
        };

        // 如果沒有返回值不能用此語法
        // Consumer c2 = (name) -> "hello, " + name;

        Consumer c3 = (name) -> System.out.println("hello, " + name);

        System.out.println(f1.test("f1 Lambda"));
        System.out.println(f4.test("f4 Lambda"));
        System.out.println(f5.test("f5 Lambda"));

        c1.test("c1 Lambda");
        c3.test("c3 Lambda");
    }
}
