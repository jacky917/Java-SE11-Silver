package org.example.test_1Z0816.ch04.o01;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.*;

/**
 * 創建流
 */
public class Main {
    public static void main(String[] args) {


        // 創建基本數據流
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);

        int[] numbers = {1, 2, 3, 4, 5};
        IntStream intStream2 = Arrays.stream(numbers);

        // 生成一個從1到4的序列 [1, 2, 3, 4]
        IntStream intStream3 = IntStream.range(1, 5);

        // 生成一個從1到5的序列 [1, 2, 3, 4, 5]
        IntStream intStream4 = IntStream.rangeClosed(1, 5);

        System.out.println("==============intStream5==============");

        // 產生一個無限流，並通過limit()設置大小 [1, 1, 1, 1, 1]
        IntStream intStream5 = IntStream.generate(() -> 1).limit(5);

        intStream5.forEach((x) -> System.out.print(x + ","));
        System.out.println();

        System.out.println("==============intStream5==============");

        System.out.println("==============intStream6==============");

        // 產生一個無限序列，並通過limit()設置大小 [0, 1, 2, 3, 4]
        IntStream intStream6 = IntStream.iterate(0, n -> n + 1).limit(5);

        intStream6.forEach((x) -> System.out.print(x + ","));
        System.out.println();

        System.out.println("==============intStream6==============");

        // 產生對象流
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5);

        Integer[] integers = {1, 2, 3, 4, 5};
        Stream<Integer> integerStream2 = Arrays.stream(integers);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> integerStream3 = integerList.stream();

        IntStream intStream7 = IntStream.rangeClosed(1, 5);  // 產生1到5的原始類型int流
        Stream<Integer> integerStream4 = intStream7.boxed(); // 裝箱成Stream<Integer>

        Stream<Integer> integerStream5 = Stream.generate(() -> 1)
                .limit(5); // 產生一個全都是1的無限流，並通過limit()設置大小

        Stream<Integer> integerStream6 = Stream.iterate(0, n -> n + 1)
                .limit(5); // 產生一個無限序列，並通過limit()設置大小


        System.out.println("===============まとめ===============");
        // Stream.of 只能創建對象流，如果需要基本數據流需要轉換
        // Arrays.stream 則可以無需轉換直接獲取基本數據流


        // 使用 Arrays.stream 創建流
        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream00 = Arrays.stream(intArray); // 創建 IntStream

        long[] longArray = {1L, 2L, 3L, 4L, 5L};
        LongStream longStream00 = Arrays.stream(longArray); // 創建 LongStream

        double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        DoubleStream doubleStream00 = Arrays.stream(doubleArray); // 創建 DoubleStream

        Integer[] integerArray = {1, 2, 3, 4, 5};
        Stream<Integer> integerStream00 = Arrays.stream(integerArray); // 創建 Stream<Integer>

        String[] stringArray = {"a", "b", "c", "d", "e"};
        Stream<String> stringStream00 = Arrays.stream(stringArray); // 創建 Stream<String>

        // 使用 Stream.of 創建流

        IntStream intStream11 = Stream.of(1, 2, 3, 4, 5).mapToInt(i -> i); // 創建 IntStream

        Stream<Integer> integerStream11 = Stream.of(1, 2, 3, 4, 5); // 創建 Stream<Integer>

        Stream<String> stringStream11 = Stream.of("a", "b", "c", "d", "e"); // 創建 Stream<String>
        Stream<String> stringStream12 = Stream.of(stringArray); // 創建 Stream<String>

        System.out.println("==============================");

        System.out.println("使用 ArrayList<Integer> 創建流");

        ArrayList<Integer> ArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // 創建基本數據類型流
        IntStream intStream = ArrayList.stream().mapToInt(Integer::intValue);

        // 創建對象流
        Stream<Integer> objectStream = ArrayList.stream();


        Arrays.stream(new int[]{1, 2, 3, 4, 5}).distinct().filter(x -> (x % 2) == 0).forEach(System.out::println);
//        Arrays.asList(1,2,3,4,5).stream().filter(x -> (x % 2) == 0).forEach(System.out::println);
        Stream.of(1, 2, 3, 4, 5).filter(x -> (x % 2) == 0).forEach(System.out::println);

        System.out.println("==============================");

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"v1");
        map.put(2,"v2");
        map.put(3,"v3");
        map.put(4,"v4");
        map.put(5,"v5");
        map.put(6,"v6");

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(Stream.of(1, 2, 3, 4, 5).filter(x -> (x % 2) == 0).collect(Collectors.toList()));

        map.entrySet().stream().filter(new Predicate<Map.Entry<Integer, String>>() {
            @Override
            public boolean test(Map.Entry<Integer, String> integerStringEntry) {
                return integerStringEntry.getKey() != 2;
            }
        }).forEach(new Stream.Builder<Map.Entry<Integer, String>>() {
            @Override
            public void accept(Map.Entry<Integer, String> integerStringEntry) {
                System.out.println(integerStringEntry.getKey() + " " + integerStringEntry.getValue());
            }

            @Override
            public Stream<Map.Entry<Integer, String>> build() {
                return null;
            }
        });

        System.out.println("==============================");
        // parallel() 多線程
        // peek() 測試用
        map.entrySet().stream().parallel().peek((x) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(x);
        }).filter(x -> x.getKey() != 2).forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
        Optional<Map.Entry<Integer, String>> entry = map.entrySet().stream().filter(x -> x.getKey() != 2).findFirst();
        // entry存在元素
        System.out.println(entry.isPresent());
        entry.ifPresent(System.out::println);
    }
}
