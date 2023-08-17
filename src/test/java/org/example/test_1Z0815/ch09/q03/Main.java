package org.example.test_1Z0815.ch09.q03;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sample[] samples = {
                new Sample(2,"B"),
                new Sample(3,"C"),
                new Sample(1,"A")
        };
        ArrayList<Sample> list = new ArrayList<>(Arrays.asList(samples));
        System.out.println(list);
        list.sort(new SampleComparator());
        System.out.println(list);

        Sample s1 = new Sample(4,"D");
        Sample s2 = new Sample(5,"E");
        System.out.println(s1.compareTo(s2));
    }
}
