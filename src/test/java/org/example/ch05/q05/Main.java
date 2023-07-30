package org.example.ch05.q05;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void myPrint(Object[] objs) {
        System.out.println("\n--------------");
        for (Object obj : objs) {
            System.out.print(obj + ",");
        }
    }

    public static void myPrint(int[] arr) {
        System.out.println("\n--------------");
        System.out.print(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] i = new int[3];
        myPrint(i);
        String[] s = new String[3];
        myPrint(s);
        TestClass[] item = new TestClass[3];
        myPrint(item);
        System.out.println("\n======================");
        TestClass test = new TestClass();
        System.out.println(test);
    }
}
