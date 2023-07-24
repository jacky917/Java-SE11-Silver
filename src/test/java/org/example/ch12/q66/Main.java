package org.example.ch12.q66;


import java.util.List;



public class Main {
    private static class Sample {
        public static void print(Integer num) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3);
        list.forEach(Sample::print);
        /* 等價代碼
        for(Integer num : list) {
            Sample.print(num);
        }
        */
    }
}
