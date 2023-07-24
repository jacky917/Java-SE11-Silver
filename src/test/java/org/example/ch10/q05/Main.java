package org.example.ch10.q05;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println(test(null));
    }
    private static String test(Objects obj) {
        try {
            System.out.println(obj);
            System.out.println(obj.toString());
        } catch (NullPointerException e) {
            return "A";
        } finally {
            System.out.println("B");
        }
        return "C";
    }
}
