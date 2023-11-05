package org.example.test_1Z0816.ch02;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Supplier、Consumer、Predicate、Function　1Z0815 ch12#q4　復習
     * -----------------------
     * 在java.util.function包中，接口名的命名有其一定的規律：
     * 前缀“Bi”:
     * 這個前缀表示接口接受兩個參數。例如：
     * BiFunction<T, U, R>：接受兩個參數（一個是T型，另一個是U型）並返回一個R型結果。
     * BiPredicate<T, U>：接受兩個參數（一個是T型，另一個是U型）並返回一個boolean型結果。
     * BiConsumer<T, U>：接受兩個參數但不返回任何結果。
     * -----------------------
     * “Operator”結尾:
     * 這表示該接口的輸入和輸出類型是一致的（泛型相同）。例如：
     * UnaryOperator<T>：接受一個T型參數並返回一個T型結果。
     * BinaryOperator<T>：接受兩個T型參數並返回一個T型結果。
     * 對於原始數據類型（例如int、long和double），相應的有IntUnaryOperator, IntBinaryOperator等。
     *
     */
    public void testApp() {
        assertTrue(true);
    }


    /**
     * BiFunction<T,U,R>:
     * 代表接受兩個輸入參數的函數，返回一個結果。
     * 方法：R appl y(T t, U u);
     */
    public void test_BiFunction() {
        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result: " + (num1 + num2);
        System.out.println(biFunction.apply(5, 3));  // Output: Result: 8
    }

    /**F
     * UnaryOperator<T>:
     * 代表接受一個參數並返回一個相同類型結果的函數。
     * Function<T,T>的特化。
     * 方法：T apply(T t);
     */
    public void test_UnaryOperator() {
        UnaryOperator<String> upperCase = (str) -> str.toUpperCase();
        System.out.println(upperCase.apply("hello"));  // Output: HELLO
    }

    /**
     * BinaryOperator<T>:
     * 代表接受兩個同類型的參數，返回一個同類型結果的函數。
     * BiFunction<T,T,T>的特化。
     * 方法：T apply(T t1, T t2);
     */
    public void test_BinaryOperator() {
        BinaryOperator<Integer> multiply = (num1, num2) -> num1 * num2;
        System.out.println(multiply.apply(5, 3));  // Output: 15
    }

    /**
     * Predicate(斷言) 接口代表一個輸入參數為 T 的函數。這個接口包含一個 test(T t) 方法，返回一個布爾值。
     * Predicate 可以串接多個
     */
    public void test_Predicate() {
        Predicate<String> lengthIsBiggerThan5 = (s3) -> s3.length() > 5;
        Predicate<String> lengthIsSmallerThan10 = (s3) -> s3.length() < 10;

        boolean result = lengthIsBiggerThan5.and(lengthIsSmallerThan10).test("Hello!"); // result = true
        System.out.println(result);

    }

    /**
     * Function(函數) 接口代表一個接收一個輸入參數並返回結果的函數。這個接口包含一個 apply(T t) 方法。
     */
    public void test_Function() {
        Function<Integer, Integer> add5 = (Integer in) -> in + 5;
        Function<Integer, Integer> mul4 = (Integer in) -> in * 4;
        // 這個方法返回一個先執行before函數，然後執行當前函數的新Function。
        // 用於函數組合，允許你連接兩個函數，使一個函數的輸出成為另一個函數的輸入。
        // compose(Function<? super V, ? extends T> before):
        System.out.println(add5.compose(mul4).apply(10)); // 45
        System.out.println(mul4.compose(add5).apply(10)); // 60

        // 這個方法返回一個先執行當前函數，然後執行after函數的新Function。
        // 也是用於函數組合，但執行順序與compose相反。
        // andThen(Function<? super R, ? extends V> after):
        System.out.println(add5.andThen(mul4).apply(10)); // 60
        System.out.println(mul4.andThen(add5).apply(10)); // 45

        // 這是Function接口的靜態方法。
        // 它返回一個不進行任何操作的函數，直接返回其輸入參數。
        // identity():
        Function<String, String> identityFunction = Function.identity();
        System.out.println(identityFunction.apply("test"));

    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/08/17
     * 最後一次查看：2023/08/17
     * 題目考點：Function
     * 需要補足知識：Function API
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q10() {
        Function<Integer,Integer> a = x -> x + 2;
        Function<Integer,Integer> b = x -> x * 2;

        // 這兩個差別在於執行順序
        System.out.println(a.compose(b).apply(10));
        System.out.println(a.andThen(b).apply(10));

        // Function.identity() 提供了一個恆等函數，這意味著這個函數返回其輸入的值。這在函數式編程中非常有用，特別是在流(Stream)操作、函數組合或高階函數等場景中。
        Function<String, String> id = Function.identity();
        System.out.println(id.apply("Hello"));  // 输出: Hello

        // 使用場景
        // 使用collect方法進行分組
        List<String> items1 = Arrays.asList("apple", "banana", "cherry");
        System.out.println(items1);

        Function<String,String> test = x -> ("apple".equals(x)) ? "XXXXXX" : x;

        Map<String, List<String>> itemMap = items1.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println(itemMap);

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/17
     * 最後一次查看：2023/08/17
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






