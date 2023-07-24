package org.example.ch12.q33;

import java.util.*;

public class Main {
    static Map<String,String> map = new HashMap<>();
    // static List<String> keys = List.of("A","B","C");
    // static List<String> keys = Arrays.asList("A","B","C");
    static List<String> keys = new ArrayList<>(Arrays.asList("A","B","C"));

    static String[] values = {"1","2","3"};
    static {
        for (var i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values[i]);
        }
    }

    public static void main(String[] args) {
        // UnsupportedOperationException
        keys.clear();
        values = new String[0];
        System.out.println(map.size() + "," + keys.size() + "," + values.length);
    }
}
