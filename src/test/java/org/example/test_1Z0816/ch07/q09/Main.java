package org.example.test_1Z0816.ch07.q09;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        List<C> listC = new ArrayList<>();

        List<? super B> list1 = new ArrayList<A>();
        List<? super B> list2 = new ArrayList<B>();
        // List<? super B> list3 = new ArrayList<C>(); 錯誤
        // List<? super B> list4 = new ArrayList<D>(); 錯誤

        list1 = listA;
        list1 = listB;
        // 不允許子類
        //list1 = listC;

    }
}
