package org.example.test_1Z0816.ch07;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
     * 🌟🌟🌟
     * 創建日期：2023/11/21
     * 最後一次查看：2023/11/27
     * 題目考點：包裝類
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：
     * プリミティブ　　基本數據類型
     * ラッパークラス　包裝類
     * ジェネリクス(Generics・総称型) 泛型
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/11/27
     * 題目考點：泛型
     * 需要補足知識：-
     * 複習：查看總結
     * 總結：如果沒有指定泛型，則為Object
     */
    public void test_q02() {

    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/11/27
     * 題目考點：泛型可以簡寫成 <> 的位置
     * 需要補足知識：日文
     * 複習：查看以下代碼
     * 總結：
     * ジェネリクスで型推論をするダイヤモンド演算子を使用する箇所として、誤っているものを選びなさい。
     * ダイヤモンド　<>
     */
    public ArrayList<String> test_q03(ArrayList<String> a) {
        // 変数の代入
        List<String> arr = new ArrayList<>();
        // メソッドの値
        test_q03(new ArrayList<>());
        // メソッド呼び出しの引数
        return new ArrayList<>();
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/11/27
     * 題目考點：範圍性的泛型
     * 需要補足知識：泛型
     * 複習：查看以下代碼
     * 總結：
     * 1.泛型不能同時設置上限和下限
     * 2.泛型範圍使用extends時，除了null以外無法添加元素
     */
    public void test_q05() {
        List<?> a = new ArrayList<>();
        List<? extends Number> b = new ArrayList<>();
        List<? super Number> c = new ArrayList<>();
        List<Number> d = new ArrayList<>();
        List<Object> e = new ArrayList<>();


        // b.add(new Integer(1)); // 因為b的範圍性最小是<?>（無限小）所以無法放入 Integer
        b.add(null);
        c.add(new Integer(1)); // 最小範圍是Number，可以放入Integer

        a = b;
        a = c;
        // ------
        b = d;
        c = d;
        // ------
        // b = e; // 報錯，因為 <? extends Number> 的意思是上限為Number，Object超出了範圍
        c = e;
        // ------

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/11/27
     * 題目考點：Queue（隊列）、Deque（雙端隊列）
     * 需要補足知識：集合特性、日文
     * 複習：查看總結
     * 總結：
     * Queue（隊列）
     * Queue 接口代表了一種先進先出（FIFO）的數據結構。隊列主要用於在數據結構的尾部進行插入操作，在頭部進行刪除操作。隊列通常用於任務排程和異步數據傳輸。
     * Queue 接口提供了以下幾個主要方法：
     * add(e)：向隊列添加一個元素，若隊列無法容納則拋出 IllegalStateException。
     * offer(e)：向隊列添加一個元素，若隊列無法容納則返回 false。
     * remove()：移除並返回隊列頭部的元素，若隊列為空則拋出 NoSuchElementException。
     * poll()：移除並返回隊列頭部的元素，若隊列為空則返回 null。
     * element()：返回隊列頭部的元素但不移除，若隊列為空則拋出 NoSuchElementException。
     * peek()：返回隊列頭部的元素但不移除，若隊列為空則返回 null。
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Deque（雙端隊列）
     * Deque 接口擴展了 Queue 接口，代表雙端隊列（Double-Ended Queue）。雙端隊列支持在兩端進行插入和刪除操作，因此它既可以作為 FIFO 隊列也可以作為後進先出（LIFO）的堆疊使用。
     * Deque 接口除了包含 Queue 接口的所有方法外，還添加了一些方法以支持雙端操作：
     * addFirst(e)：在隊列前端添加一個元素。
     * offerFirst(e)：在隊列前端添加一個元素，若隊列無法容納則返回 false。
     * addLast(e)：在隊列尾端添加一個元素。
     * offerLast(e)：在隊列尾端添加一個元素，若隊列無法容納則返回 false。
     * removeFirst()：移除並返回隊列前端的元素。
     * pollFirst()：移除並返回隊列前端的元素，若隊列為空則返回 null。
     * removeLast()：移除並返回隊列尾端的元素。
     * pollLast()：移除並返回隊列尾端的元素，若隊列為空則返回 null。
     * getFirst()：返回隊列前端的元素但不移除。
     * getLast()：返回隊列尾端的元素但不移除。
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 要素を管理するオプジェットを数珠つなぎにして管理（串成一串，即最前面的元素和最後串接在一起）
     */
    public void test_q12() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/11/27
     * 題目考點：Map
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：
     * 一意なキーとひも付かられた値のペア要素を扱う（處理具有唯一鍵和綁定值的配對元素。）
     * 重複を許さない集合を扱う（這是Set的描述）
     */
    public void test_q14() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/11/27
     * 題目考點：Map API
     * 需要補足知識：Map.entry()、Map.ofEntries()、map.enterSet()
     * 複習：查看總結
     * 總結：
     * 1.Map.entry()、Map.ofEntries() 創建不可變的 map
     * 2.Map.Entry 是表示單一鍵值對的接口
     */
    public void test_q15() {
        Map.Entry<Integer, String> a = Map.entry(1, "A");
        Map.Entry<Integer, String> b = Map.entry(2, "B");
        Map.Entry<Integer, String> c = Map.entry(3, "C");
        Map<Integer, String> map = Map.ofEntries(a, b, c);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ",");
            System.out.println(entry.getValue());
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/11/27
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






