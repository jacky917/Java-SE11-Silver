package org.example.test_1Z0815.ch12.o1.test1;

public class Main {

    static {
        s1 = "111";
        // System.out.println(s1);
    }
    private static String s1 = "";

    private String s2 = "";
    {
        s2 = "111";
    }

    public static void main(String[] args) {
//        new Children();
        System.out.println(s1);
        System.out.println(new Main().s2);
    }
}
