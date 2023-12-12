package org.example.test_1Z0815.ch12.q4;

import junit.framework.TestCase;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 前置知識
 */
public class Q4Test extends TestCase {

    /**
     * Lambda 表達式在 Java 中的實現，可以看作是一種特殊的匿名內部類。
     * Lambda 表達式和匿名內部類在很多方面是相似的。例如：
     * 1.它們都可以訪問其外部作用域的 final 或者事實上的 final 變量，它們也都可以被傳遞並且可以作為一個參數
     *   事實上的 final 變量 : 即沒有聲明 final ，但實際上沒有變更的變量
     */
    public void test_Lambda(){
        // 在 Java 8 引入 Lambda 表達式之前，如果我們需要創建一個只有一個方法的類（比如 Runnable 或者 Comparator），常常會使用匿名內部類。例如：
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello from the anonymous inner class!");
            }
        }).start();
        // 在這個例子中，我們創建了一個新的 Thread，並傳遞了一個 Runnable 的匿名內部類實例給它。我們在 run 方法內定義了我們要 Thread 執行的代碼。
        // 然後，Java 8 引入了 Lambda 表達式，使得這種情況變得更為簡單：
        new Thread(() -> System.out.println("Hello from the lambda!")).start();
    }


    /**
     * Supplier(供應商) 是一個函數式接口，它不接收參數，但返回一個結果。這個接口包含一個 get() 方法，用於獲取結果。Supplier 接口經常用於工廠模式，生成對象實例。
     */
    public void test_Supplier() {
        Supplier<String> stringSupplier = () -> "Hello, world!";
        String s1 = stringSupplier.get(); // s = "Hello, world!"
        System.out.println(s1);
    }

    /**
     * Consumer(消費者) 接口代表一個接收單一輸入參數並且沒有返回值的操作。這個接口包含一個 accept(T t) 方法。
     */
    public void test_Consumer() {
        Consumer<String> stringConsumer1 = x -> System.out.println("stringConsumer1 " + x);
        Consumer<String> stringConsumer2 = x -> System.out.println("stringConsumer2 " + x);
        stringConsumer1.andThen(stringConsumer2).accept("xxx");
        stringConsumer1.accept("Hello, world!"); // 打印 "Hello, world!"
    }

    /**
     * Predicate(斷言) 接口代表一個輸入參數為 T 的函數。這個接口包含一個 test(T t) 方法，返回一個布爾值。
     */
    public void test_Predicate() {
        Predicate<String> lengthIsGreaterThan5 = (s3) -> s3.length() > 5;
        boolean result1 = lengthIsGreaterThan5.test("Hello, world!"); // result1 = true
        System.out.println(result1);
        boolean result2 = lengthIsGreaterThan5.test("test"); // result2 = false
        System.out.println(result2);
    }

    /**
     * Function(函數) 接口代表一個接收一個輸入參數並返回結果的函數。這個接口包含一個 apply(T t) 方法。
     */
    public void test_Function() {
        Function<String, Integer> lengthFunction = String::length;
        int length = lengthFunction.apply("Hello, world!"); // length = 13
        System.out.println(length);
    }
}
