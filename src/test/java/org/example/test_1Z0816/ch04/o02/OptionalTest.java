package org.example.test_1Z0816.ch04.o02;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Supplier;

public class OptionalTest {
    public static void main(String[] args) {

        // 不推薦，會報空指針 java.lang.NullPointerException
        // Optional<String> s = Optional.of(null);

        Optional<String> s1 = Optional.ofNullable(null);
        System.out.println(s1.isPresent());
        s1.ifPresent(System.out::print);

        Optional<String> s2 = Optional.ofNullable("Test");
        System.out.println(s2.isPresent());
        s2.ifPresent(System.out::println);

        System.out.println("===========");

        // 當 null 時，給一個默認值
        System.out.println(s2.orElse("default"));
        System.out.println(s2.orElseGet(() -> {
            // 只有當 null 時才會執行
            System.out.println("orElseGet");
            return "default";
        }));

        try {
            // 當 null 時，拋出自定義異常
            System.out.println(s1.orElseThrow(() -> new RuntimeException("自定義錯誤")));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        // 當 null 時，拋出 NoSuchElementException 異常
        // Exception in thread "main" java.util.NoSuchElementException: No value present
        try {
            System.out.println(s1.get());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        System.out.println("===========");

        Optional<String> s3 = Optional.ofNullable(null);
        // 一個Consumer，當Optional對象有值時，這個消費者會被值做為參數調用
        // Runnable，當Optional對象為空時，這個運行會被調用
        s3.ifPresentOrElse((x) -> {
            System.out.println("Consumer 被調用，值：" + x);
        },() -> {
            System.out.println("值為空，Runnable 被調用");
        });
    }
}
