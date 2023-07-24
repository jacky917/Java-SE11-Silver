package org.example.ch09.q11;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("A", 100));
        list.add(new Item("B", 200));
        list.add(new Item("C", 300));
        list.add(new Item("A", 100));
        // 移除第一個符合條件的元素
        list.remove(new Item("A", 500));
        // 移除所有符合條件的元素

        // list.removeIf(new Predicate<Item>() {
        //     @Override
        //     public boolean test(Item item) {
        //         return Objects.equals("A", item.getName());
        //     }
        // });

        // lambda 表達式
        list.removeIf((item) -> Objects.equals("A", item.getName()));

        for (Item i : list) {
            System.out.println(i.getName() + "," + i.getPrice());
        }
    }
}
