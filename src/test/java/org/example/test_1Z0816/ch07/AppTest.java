package org.example.test_1Z0816.ch07;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

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
     * 最後一次查看：2023/12/16
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
        // クラス宣言　沒有推論類型
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
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/16
     * 最後一次查看：2023/12/16
     * 題目考點：<?>
     * 需要補足知識：日文
     * 複習：查看以下代碼
     * 總結：
     * 1.メソッドの戻り値はObject型になる。
     * 2.メソッドの引数には null リテラルしか渡せない。
     */
    public void test_q07() {
        List<?> list = new ArrayList<>();
        // 2.メソッドの引数には null リテラルしか渡せない。
//        list.add("");
//        list.add(0);
        list.add(null);
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/17
     * 最後一次查看：2023/12/17
     * 題目考點：<?>
     * 需要補足知識：上限境界ワイルドカード（extends）　下限境界ワイルドカード（super）
     * 複習：查看以下代碼
     * 總結：<? extends Number> 意味著列表可以持有任何是 Number 類或其子類（如 Integer、Double 等）的對象。
     *      這種方式的限制是，除了 null 之外，不能向這樣的列表中添加任何元素。原因是Java編譯器無法確定具體的列表類型。
     *      當你聲明一個 List<? extends Number>，你實際上是在說：“這是一個持有某種未知 Number 子類型的列表。
     *      ” 由於具體的子類型不確定，因此無法保證任何特定類型對象的添加操作在類型安全上是有效的，除了完全類型無關的 null 值。
     *  ->  <? extends Number> 代表此泛型最大範圍是 Number，但並沒有指定最小範圍，所以除了 null，什麼都 add 不了。
     */
    public void test_q08() {
        List<? extends Number> list1 = new ArrayList<>();
        // list1.add(10); 錯誤
        List<? super Number> list2 = new ArrayList<>();
        list2.add(10);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/17
     * 最後一次查看：2023/12/17
     * 題目考點：<?>
     * 需要補足知識：-
     * 複習：查看q09
     * 總結：
     * 1.定義泛型集合和給泛型添加內容是兩回事。
     * 2.定義泛型集合對類的是要一模一樣的（不允許子類）。
     * 3.添加內容時可以允許子類。#q08
     */
    public void test_q09() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/12/17
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
     * 創建日期：2023/12/17
     * 最後一次查看：2023/12/17
     * 題目考點：Set
     * 需要補足知識：Set
     * 複習：查看以下總結
     * 總結：
     * HashSet：
     *    基於哈希表的實現（實際上是基於 HashMap）。
     *    它不保證集合的迭代順序；特別是它不保證該順序恆久不變。
     *    允許包含 null 元素。
     *    提供恆定時間的性能，對基本操作（添加、刪除、包含和大小）。
     * LinkedHashSet：
     *    哈希表和鏈表實現的結合體，具有可預見的迭代順序。
     *    保留了元素插入的順序。
     *    比 HashSet 略微慢，但在迭代訪問時有更好的性能。
     *    LinkedHashSet 是有序的，但这里的“有序”指的是按照插入顺序排列，而不是自然排序或其他排序方式。
     * TreeSet：
     *    基於紅黑樹（Red-Black tree）的實現。
     *    元素按照其自然順序進行排序，或根據創建時提供的 Comparator 進行排序。
     *    提供了一個有序的 Set 集合。
     *    對基本操作如添加、刪除和查找元素提供保證的 log(n) 時間成本。
     * EnumSet：
     *    專為枚舉類（enum type）設計的高效 Set 實現。
     *    內部使用位向量表示，非常高效。
     *    只能包含單個枚舉類型的值。
     * CopyOnWriteArraySet：
     *    基於 CopyOnWriteArrayList 的 Set 實現。
     *    每次修改時，都會復制底層的數組，適用於讀多寫少的並發場景。
     *    迭代器不支持修改操作並且會反映創建迭代器時的狀態。
     * ConcurrentSkipListSet：
     *    線程安全的有序集合，實現了 NavigableSet 接口。
     *    基於跳表（Skip List）實現。
     *    提供了一個可擴展且高效的同步 NavigableSet 實現。
     */
    public void test_q13() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/12/17
     * 題目考點：Map
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：
     * 一意なキーとひも付かられた値のペア要素を扱う（這是Map的描述）
     *   處理具有唯一鍵和綁定值的配對元素。
     * インデックスによって順序付かられた要素を扱う（這是List的描述）
     * 重複を許さない集合を扱う（這是Set的描述）
     */
    public void test_q14() {
        // Stack 繼承自 Vector（List）
        Stack<Integer> objects = new Stack<>();
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/27
     * 最後一次查看：2023/12/17
     * 題目考點：Map API
     * 需要補足知識：Map.entry()、Map.ofEntries()、map.enterSet()
     * 複習：查看總結
     * 總結：
     * Map.Entry 是與 Map 介面密切相關的一個內部介面。 它表示 Map 中的一個鍵值對。
     * 每個 Map.Entry 物件都包含一個鍵和一個與之對應的值。 Map.Entry 介面通常用於遍歷 Map 物件。
     * -------------------
     * Map.Entry 和 HashMap 的關係
     * HashMap 是 Map 介面的一個具體實作。 它使用哈希表來儲存鍵值對。
     * 當使用 HashMap 或任何其他 Map 實作時，Map.Entry 用來表示該映射中的單一元素。
     * 在遍歷 HashMap 或執行與單一鍵值對相關的操作時，會使用到 Map.Entry。
     * 例如，使用 HashMap 的 entrySet() 方法可以取得一個包含了該 HashMap 中所有鍵值對的 Set<Map.Entry<K,V>>。
     * -------------------
     * 1.Map.entry()、Map.ofEntries() 創建不可變的 map。
     * 2.Map.Entry 是表示單一鍵值對的內部接口。
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
     * 創建日期：2023/12/17
     * 最後一次查看：2023/12/17
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






