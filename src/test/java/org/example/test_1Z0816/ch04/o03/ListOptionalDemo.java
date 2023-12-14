package org.example.test_1Z0816.ch04.o03;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream 搭配 Optional
 */
public class ListOptionalDemo {

    public static <T> void printStream(Stream<T> stream) {
        stream.forEach((x) -> System.out.print(x + ","));
    }

    /**
     * @param args 入口參數
     *  1.Optional 沒有直接提供一個創建扁平化流的方法，所以需要使用 flatMap 轉換。
     *  2.Optional 可以重複使用，但他不直接提供列表的過濾（filter），需要轉換成 Stream，Optional 主要用於處理單一可能為空的值。
     */
    public static void main(String[] args) {

//        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list1 = null;

        // 1.創建 Optional 數組流
        // Optional 沒有直接提供一個創建扁平化流的方法，所以需要轉換
        Optional<List<Integer>> optionalList = Optional.ofNullable(list1);

        // flatMap：Stream<List<Integer>> 轉換為 Stream<Integer>
//        Stream<Integer> flatStream = optionalList.stream().flatMap(new Function<List<Integer>, Stream<? extends Integer>>() {
//            @Override
//            public Stream<? extends Integer> apply(List<Integer> integers) {
//                return integers.stream();
//            }
//        });
        Stream<Integer> flatStream = optionalList.stream().flatMap(List::stream);
        printStream(flatStream.filter((x) -> x % 2 != 0));

        System.out.println("\n==============");

        // 直接使用流，不使用 Optional，當 list = null 時報了空指針異常
        try {
            printStream(list1.stream().filter((x) -> x % 2 != 0));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> integerStream1 = list2.stream().filter(x -> x != 5); // 過濾掉 5
        Stream<Integer> integerStream2 = list2.stream().filter(x -> x != 6); // 過濾掉 6

        printStream(integerStream1);
        System.out.println("\n==============");
        printStream(integerStream2);

        System.out.println("\n==============");

        // 流不可以重用
        try {
            Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream();
            Stream<Integer> integerStream3 = stream.filter(x -> x != 5); // 過濾掉 5
            Stream<Integer> integerStream4 = stream.filter(x -> x != 6); // 過濾掉 6

            printStream(integerStream3);
            System.out.println("\n==============");
//        printStream(integerStream4);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        Optional<String> s0 = Optional.ofNullable("abc");
        Optional<String> s1 = s0.map(String::toUpperCase);

        System.out.println(s0.get());
        System.out.println(s1.get());
    }
}