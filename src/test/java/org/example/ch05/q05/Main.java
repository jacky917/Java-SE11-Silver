package org.example.ch05.q05;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void myPrint(Object[] objs) {
        System.out.println("\n--------------");
        System.out.print(Arrays.toString(objs));
        for (Object obj : objs) {
            System.out.print(obj);
        }
    }

    public static void myPrint(Object obj) {

    }

    public static void main(String[] args) {
        int[] i = new int[3];
        System.out.println(Arrays.toString(i));
//        for(int item1 : i) {
//            System.out.print(item1);
//        }

        System.out.println("\n--------------");
        String[] s = new String[3];
        System.out.println(Arrays.toString(s));
//        for(String item2 : s) {
//            System.out.print(item2);
//        }
        myPrint(s);
        System.out.println("\n--------------");

        TestClass[] item = new TestClass[3];
        System.out.println(Arrays.toString(s));
        for(TestClass item3 : item) {
            System.out.print(item3);
        }
    }

}
