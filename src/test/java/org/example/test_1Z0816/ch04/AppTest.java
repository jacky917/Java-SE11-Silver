package org.example.test_1Z0816.ch04;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/12
     * 最後一次查看：2023/12/13
     * 題目考點：Optional
     * 需要補足知識：flatMap
     * 複習：查看q08
     * 總結：
     * 1.Optional 處理中不應該有 null 出現，哪怕代碼不會報錯，應當使用 Optional.empty() 替代。
     * 2.如果有 null 的情況推薦使用 flatMap，並返回一個 Optional，它會自動扁平化處理，也不會導致嵌套 Optional。
     * 3.泛型為 Optional<Integer> 使用 map 的話不應該返回 Optional 對象，正確的應該是返回 Integer。
     */
    public void test_q08() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/12
     * 最後一次查看：2023/12/13
     * 題目考點：Stream
     * 需要補足知識：Collectors.groupingBy
     * 複習：查看q10
     * 總結：
     * 1.Stream 可以做到分組。
     * 2.Stream 不是用來取代 for 的，因為Stream不可修改局部變量。
     */
    public void test_q10() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/12
     * 最後一次查看：2023/11/12
     * 題目考點：Stream
     * 需要補足知識：執行順序
     * 複習：查看總結
     * 總結：
     * 1.Stream 的執行順序由集合所管理，比如HashSet就無法保證和添加的順序一致。
     * 2.Stream 提供並行流（parallel），無法保證順序。
     */
    public void test_q12() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/12
     * 最後一次查看：2023/12/13
     * 題目考點：創建並行流
     * 需要補足知識：語法
     * 複習：查看以下代碼
     * 總結：普通流和並行流返回的對象都是 Stream<String>
     */
    public void test_q13() {
        List<String> myList = Arrays.asList("a", "b", "c", "d");
        Stream<String> stringStream1 = myList.stream().parallel();
        Stream<String> stringStream2 = myList.parallelStream();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/12
     * 最後一次查看：2023/12/14
     * 題目考點：findAny,findFirst
     * 需要補足知識：API使用
     * 複習：查看以下代碼
     * 總結：
     * 1.findAny返回流中隨機的一個值
     * 2.findFirst返回流中第一個值（不是第一個處理的值）
     * 3.以上規則適用於順序流和並行流
     */
    public void test_q16() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/12
     * 最後一次查看：2023/11/12
     * 題目考點：Stream API
     * 需要補足知識：sorted
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q17() {
        Arrays.asList(1, 2, 3).stream().sorted();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/14
     * 最後一次查看：2023/12/14
     * 題目考點：Stream Map
     * 需要補足知識：
     * 複習：查看以下代碼
     * 總結：map 接收一個 Function，一般用於轉換數據類型
     */
    public void test_q18() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        integerStream.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer + "";
            }
        }).forEach(System.out::println);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/12
     * 最後一次查看：2023/11/12
     * 題目考點：API
     * 需要補足知識：reduce 和 基本類型流，對象流的創建與轉換
     * 複習：查看以下代碼
     * 總結：
     * 1.創建基本類型流：
     *   Arrays.stream(new int[]{1, 2, 3})
     * 2.創建對象流：
     *   Arrays.asList(1, 2, 3).stream()
     *   -> Arrays.asList創建了List<Integer>對象
     * 3.轉換使用 boxed mapToInt
     */
    public void test_q19() {

        // 基本類型流
        IntStream stream = Arrays.stream(new int[]{1, 2, 3});
        int reduce0 = Arrays.stream(new int[]{1, 2, 3}).reduce(0, (a, b) -> a + b);

        // 轉換
        Stream<Integer> boxed = Arrays.stream(new int[]{1, 2, 3}).boxed();
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3}).boxed().mapToInt(x -> x);

        // 對象流
        Integer reduce1 = Arrays.asList(1, 2, 3).stream().reduce(0, (a, b) -> a + b);
        // 自動拆箱
        int reduce2 = Arrays.asList(1, 2, 3).stream().reduce(0, (a, b) -> a + b);
        String reduce3 = Arrays.asList("1", "2", "3").stream().reduce("", (a, b) -> a + b);

        System.out.println(reduce0);
        System.out.println(reduce1);
        System.out.println(reduce2);
        System.out.println(reduce3);
    }

    /**
     * 🌟
     * 創建日期：2023/11/12
     * 最後一次查看：2023/11/12
     * 題目考點：ifPresent
     * 需要補足知識：ifPresent
     * 複習：max 獲取最大值
     * 總結：-
     */
    public void test_q20() {
        List<String> strings1 = Arrays.asList("B", "A", "D", "C");
        Optional<String> result1 = strings1.stream().max(String::compareTo);
        result1.ifPresent(System.out::println);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/13
     * 最後一次查看：2023/12/14
     * 題目考點：Collector 是流的終端操作
     * 需要補足知識：Collector
     * 複習：詳細查看 q22
     * 總結：Collector 接口：java.util.stream.Collector用於合併流元素並建立最終結果。可以建立自訂的Collector來獲得最終結果。
     */
    public void test_q21() {

//        java.util.stream.Collector
        Stream<String> stream = Stream.of("apple", "banana", "cherry", "date");
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);
//        java.util.stream.Stream
//        java.util.stream.StreamSupport
//        java.util.stream.Stream.Builer

    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/13
     * 最後一次查看：2023/12/14
     * 題目考點：自定義 Collector
     * 需要補足知識：Collector.of的使用
     * 複習：查看以下代碼
     * 總結：
     * Collector接口主要由四個方法組成：
     *    supplier()    提供者 Supplier<A>      ：提供一個新的可變結果容器。
     *    accumulator() 累加器 BiConsumer<A, T> ：將新的資料元素加入到結果容器中。
     *    combiner()    組合器 BinaryOperator<A>：合併兩個結果容器，用於並行執行。
     *    finisher()    終結者 Function<A, R>   ：在整個收集過程結束時，對結果容器套用最終轉換。
     */
    public void test_q22() {

        // StringJoiner 的使用
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Java");
        joiner1.add("Python");
        joiner1.add("C++");
        System.out.println(joiner1); // Java, Python, C++

        StringJoiner joiner2 = new StringJoiner("= ");
        joiner2.add("Java");
        joiner2.add("Python");
        joiner2.add("C++");
        System.out.println(joiner2); // Java= Python= C++
        System.out.println(joiner1.merge(joiner2));

        Stream<String> stream = Stream.of("apple", "banana", "cherry", "date");

        Collector<String, StringJoiner, String> myCollector =
                Collector.of(
                        () -> new StringJoiner(", "),  // supplier
                        StringJoiner::add,                     // accumulator
                        StringJoiner::merge,                   // combiner
                        StringJoiner::toString                 // finisher
                        //Collector.Characteristics.IDENTITY_FINISH
                );

        String result = stream.collect(myCollector);
        System.out.println(result);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/13
     * 最後一次查看：2023/12/14
     * 題目考點：groupingBy、summarizingInt
     * 需要補足知識：API的使用
     * 複習：查看以下代碼
     * 總結：
     * 1.groupingBy 用於根據某個屬性或條件將流中的元素分組。它位於 java.util.stream.Collectors 類別中，是處理流程時進行分組運算的標準方式。
     *   重載方法 1:接收一個 Function。
     *   重載方法 2:接收一個 Function 和 Collector。
     *   重載方法 3:接收一個 Function,Supplier 和 Collector。
     * mapFactory 允許使用者提供一個自訂的 Map 實作來儲存分組結果。
     * 這種方式特別適用於需要特定 Map 實作的情況，如排序的 Map。
     * 2.summarizingInt 是 Java 中 Collectors 類別的方法，它提供了一種統計整數資料的簡單方式。
     *   這個方法是 Java 8 引入的，主要用於對 Stream 中的整數資料進行匯總統計，包括計算總數、總和、最小值、最大值以及平均值。
     */
    public void test_q25() {

        List<String> items = Arrays.asList("apple", "banana", "cherry", "apple", "banana");

        // 將字串根據長度進行分組。
        Map<Integer, List<String>> groupedByLength = items.stream().collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);
        System.out.println("==========================");

        // 將字串根據長度進行分組，並計算每組的元素個數。
        Map<Integer, Long> groupedByLengthAndCount1 = items.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        // 將字串根據長度進行分組，使用TreeMap來收集數據，並計算每組的元素個數。
        Map<Integer, Long> groupedByLengthAndCount2 = items.stream().collect(
                Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.counting()
                )
        );
        System.out.println(groupedByLengthAndCount1);
        System.out.println("==========================");
        System.out.println(groupedByLengthAndCount2);
        System.out.println("==========================");

        // 多級分組
        Stream<String> names = Stream.of("John", "Sarah", "Mark", "Tanya", "Elena", "Steve");

        Map<Integer, Map<Character, List<String>>> groupedByNameLengthThenFirstLetter =
                names.collect(Collectors.groupingBy(
                        String::length,
                        Collectors.groupingBy(name -> name.charAt(0))
                ));

        System.out.println(groupedByNameLengthThenFirstLetter);

        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");

        IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(Integer::parseInt));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("==========================");
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/13
     * 最後一次查看：2023/12/14
     * 題目考點：Collectors API
     * 需要補足知識：partitioningBy
     * 複習：查看以下代碼
     * 總結：partitioningBy 用來將流中的元素根據一個布林表達式（謂詞）分成兩部分，通常被稱為分區（partitioning）。
     *      分區是一種特殊的分組，其中每個元素按照 boolean 為 true 還是 false 分到兩個不同的列表。
     */
    public void test_q26() {

        Map<Boolean, List<Integer>> result = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}).
                boxed().collect(Collectors.partitioningBy(x -> x % 2 == 0));

        System.out.println("Even numbers: " + result.get(true));
        System.out.println("Odd numbers: " + result.get(false));
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/13
     * 最後一次查看：2023/11/13
     * 題目考點：流
     * 需要補足知識：流的執行順序
     * 複習：查看以下代碼
     * 總結：流的鍊式調用是從第一個元素開始，逐個元素地通過一系列操作，直到結束，然後處理下一個元素，直到所有元素都被處理。
     *      如果流是並行的，不同的元素可以同時在不同執行緒上經過這個管道，但每個元素的處理順序仍然是按照順序來的。
     *      流操作是惰性的，意味著它們不會立即執行，而是在需要結果時才執行。 這通常是在觸發終端操作時發生的。
     */
    public void test_q27() {
        List<String> list = Arrays.asList("banana","apple","orange");
        Stream<String> stream = list.stream();
        stream.filter(str -> str.length() > 5)
                .peek(str -> System.out.println("1 " + str + " "))
                .map(String::toUpperCase)
                .peek(str -> System.out.println("2 " + str + " "))
                .forEach(System.out::println);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/13
     * 最後一次查看：2023/12/14
     * 題目考點：流的終止操作
     * 需要補足知識：重複調用終止操作
     * 複習：查看以下代碼
     * 總結：
     * 1.重複調用終止操作會拋出運行時異常
     * 2.流是不可重用的
     */
    public void test_q28() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long count = stream.count();
        System.out.println(count);
        try {
            stream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/14
     * 最後一次查看：2023/12/14
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






