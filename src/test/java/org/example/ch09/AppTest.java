package org.example.ch09;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ObjectStreamException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

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
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：Comparable 和 Comparator
     * 需要補足知識：比較對象大小的方法
     * 複習：查看 q03
     * 總結：
     * 比較對象有兩種方式：
     * 1.類別實現了 Comparable 接口就意味著它的對象之間有一種自然順序。
     *   -> 類別直接調用 compareTo 方法
     * 2.Comparator 接口主要用於實現"自定義順序"比較。如果我們需要根據不同的條件對對象進行排序，就可以使用Comparator接口。
     *   我們可以創建多個不同的 Comparator 類別來實現不同的排序。
     *   -> 使用如 list.sort 時，作為參數傳入
     * 3.Comparator 使用自定義排序時：
     *   返回正數（1）代表第一個參數排後面
     *   返回負數（-1）代表第一個參數排前面
     */
    public void test_q03() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：localDate
     * 需要補足知識：localDate with
     * 複習：查看以下代碼
     * 總結：
     * 1.with 方法不是變更 LocalDate 對象，而是返回一個新的 LocalDate
     * 2.LocalDate.of 參數不合法是運行時錯誤
     */
    public void test_q06() {
        LocalDate a = LocalDate.of(2019,8,19);
        LocalDate b = LocalDate.of(2019,8,20);
        b.with(DayOfWeek.MONDAY);
        System.out.println(a.equals(b) + "," + a.isBefore(b));
        // java.time.DateTimeException: Invalid value for MonthOfYear
        LocalDate e = LocalDate.of(2019,0,20);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：ArrayList
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：
     * 1.ArrayList 可以包含 null
     *   null は扱える
     * 2.ArrayList 長度是可變的
     *   動的な配列として動作する
     * 3.值可以重複
     *   重複した値は扱える
     * 4.可以在任意位置插入值
     * 　　値を追加する箇所を制御できる
     * －－－－－－－－－－－－－－－－
     * 補充
     * 5.add index 下標是從 0 開始，0 代表插入到最前面
     *   超出索引則拋出錯誤 java.lang.IndexOutOfBoundsException: Index: 1, Size: 0
     */
    public void test_q07() {
        ArrayList<String> list = new ArrayList<>();
        // １
        list.add(null);
        // ２，３
        list.add("2");
        list.add("2");
        System.out.println(list);
        // ４
        list.add(0,"add");
        System.out.println(list);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：ArrayList
     * 需要補足知識：ArrayList 泛型
     * 複習：查看以下代碼
     * 總結：不指定泛型的話視為 Object 類型
     */
    public void test_q08() {
        ArrayList list = new ArrayList<>();
        list.add("A");
        list.add(10);
        list.add('B');
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：ArrayList remove
     * 需要補足知識：ArrayList remove
     * 複習：查看以下代碼
     * 總結：
     */
    public void test_q09() {
        ArrayList<String> list = new ArrayList<>();
    }

    private ArrayList<String> getList(){
        System.out.println("－－－－－－－－－－－－－－－－");
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        return list;
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：ArrayList remove
     * 需要補足知識：ArrayList remove
     * 複習：查看總結
     * 總結：
     * 1.不應該在迭代過程中修改 List
     * 2.增強 for 等同於迭代器模式
     * 3.報錯是發生在 i.next() 時
     * 4.ArrayList 中有個 checkForComodification 方法，用來檢查 List 是否被修改，
     *   如果被修改則拋出 java.util.ConcurrentModificationException
     * 5.當刪除的元素位於倒數第二個時不會拋出異常，原因是刪除元素後 List 長度 -1，
     *   正好讓最後一次調用判斷完 i.hasNext 結束（沒有調用到 i.next）
     *   public boolean hasNext() {
     *     return cursor != size;
     *   }
     *   hasNext 是判斷長度和當前下標是否相等，所以如果移除最後一個元素依舊會報錯（依舊會調用 i.next）
     * 6.迭代器模式刪除（版本要求Java 1.2）
     * 7.Collection.removeIf()（版本要求Java 1.8）
     */
    public void test_q12() {
        ArrayList<String> list = getList();
        for(String str : list) {
            if("B".equals(str)) {
                list.remove("B");
            } else {
                System.out.println(str);
            }
        }
        list = getList();
        // 增強 for 等效於迭代器模式
        for (Iterator<String> i = list.iterator(); i.hasNext();) {
            String element = i.next();
            if("B".equals(element)) {
                list.remove("B");
            } else {
                System.out.println(element);
            }
        }
        list = getList();
        // 迭代器模式刪除元素，正確寫法
        for (Iterator<String> i = list.iterator(); i.hasNext();) {
            String element = i.next();
            if("C".equals(element)) {
                // 移除當前元素
                i.remove();
            } else {
                System.out.println(element);
            }
        }
        list = getList();
        // Collection.removeIf() 方法 移除C + 打印
        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if("C".equals(s)) {
                    // 移除當前元素
                    return true;
                } else {
                    System.out.println(s);
                }
                return false;
            }
        });
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/28
     * 最後一次查看：2023/07/28
     * 題目考點：長度不可變的 List
     * 需要補足知識：List.of Arrays.asList 差別
     * 複習：查看總結
     * 總結：
     * List.of Arrays.asList 差別
     * 1.長度都不可變
     * 2.List.of Java 9 才被引入
     * 3.List.of 不僅長度不可變，值也不可變
     * 4.Arrays.asList可變更值
     */
    public void test_q14() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = Arrays.asList(new Integer[] {1,2,3});
        List<Integer> list3 = Arrays.asList(1,2,3);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println("------------------");
        // java.lang.UnsupportedOperationException
        // list1.set(0,99);
        list2.set(0,99);
        list3.set(0,99);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println("------------------");
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：Arrays 常用 API
     * 需要補足知識：mismatch
     * 複習：Notion
     * 總結：-
     */
    public void test_q15() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






