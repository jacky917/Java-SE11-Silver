package org.example.test_1Z0816.ch04.o02;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Supplier;

/**
 * 結論：
 * Optional.of 不推薦使用，會報空指針異常，建議使用 ofNullable
 * ------ Optional.ofNullable 返回值的操作 ------
 * 1.isPresent() 返回 boolean，僅判斷是否有內容。
 * 2.ifPresent() 是一個消費型方法，它接受一個 Consumer 類型的參數。 如果 Optional 物件包含值，則執行傳遞給 ifPresent() 的 Consumer。
 * 3.orElse 和 orElseGet 都提供了在 Optional 為空時的默認值。不同之處在於 orElse 直接返回一個已經存在的值，
 *   而 orElseGet 則在需要時才調用供應型函數。兩個方法本身都不會拋出異常。
 *   但如果 orElse 方法的參數是一個可能拋出異常的表達式，那麼這個異常可能在呼叫 orElse 時發生。當提供的 Supplier 拋出了異常，
 *   那麼這個異常會被傳播到 orElseGet 方法被呼叫的地方。換句話說，如果 Supplier 實作中有可能拋出異常，需要在呼叫 orElseGet 的地方處理這個異常。
 * 4.異常處理：
 *   1.直接調用 s1.get() 如果為 null 會拋出 NoSuchElementException 異常。
 *   2.使用 orElseThrow 沒有值時拋出自定義異常。
 *   3.ifPresentOrElse 當有值時，會將值交給第一個參數 Consumer 使用，當沒有值則執行第二個參數 Runnable 的內容。
 */
public class OptionalTest {

    public static void printHr(String message) {
        printHr();
        System.out.println("======" + message + "======");
    }

    public static void printHr() {
        System.out.println("\n===================================================================");
    }

    public static String getStr() {
        System.out.println("這段代碼一定會執行");
        return "getStr返回值";
    }

    public static void main(String[] args) {

        printHr("Optional.of");
        // 不推薦，會報空指針 java.lang.NullPointerException
        try {
            Optional<String> s = Optional.of(null);
            System.out.println(s);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("======Optional.of NullPointerException======");
        }
        printHr();

        System.out.println("|||||||||| s1.ifPresent 創建Optional 值 = null ||||||||||");
        Optional<String> s1 = Optional.ofNullable(null);
        System.out.print("s1 isPresent = ");
        System.out.println(s1.isPresent());
        System.out.print("s1 ifPresent = ");
        s1.ifPresent(System.out::print);
        printHr();

        System.out.println("|||||||||| s2.ifPresent 創建Optional 值 = Test ||||||||||");
        Optional<String> s2 = Optional.ofNullable("Test");
        System.out.print("s2 isPresent = ");
        System.out.println(s2.isPresent());
        System.out.print("s2 ifPresent = ");
        s2.ifPresent(System.out::print);

        printHr("default test");
        System.out.println("|||||||||| s1 default test default = default ||||||||||");
        System.out.print("orElse = ");
        System.out.println(s1.orElse("default"));
        System.out.print("orElseGet = ");
        System.out.println(s1.orElseGet(() -> {
            // 只有當 null 時才會執行
            System.out.println("orElseGet 被執行了");
            return "default";
        }));

        printHr();
        System.out.println("|||||||||| s2 default test default = default ||||||||||");
        // 當 null 時，給一個默認值
        System.out.print("orElse = ");
        System.out.println(s2.orElse("default"));
        System.out.print("orElseGet = ");
        System.out.println(s1.orElseGet(() -> {
            // 只有當 null 時才會執行
            System.out.println("orElseGet 被執行了");
//            throw new RuntimeException("111"); 此異常會被傳播到 orElseGet 方法被呼叫的地方。
            return "default";
        }));

        printHr("exception test");
        try {
            // 當 null 時，拋出自定義異常
            System.out.println(s1.orElseThrow(() -> new RuntimeException("自定義錯誤")));
        } catch (RuntimeException e) {
            System.out.println("s1.orElseThrow：當 null 時，拋出自定義異常");
            e.printStackTrace();
        }

        // 當 null 時，拋出 NoSuchElementException 異常
        // Exception in thread "main" java.util.NoSuchElementException: No value present
        try {
            System.out.println(s1.get());
        } catch (NoSuchElementException e) {
            System.out.println("s1.get：當 null 時，拋出 NoSuchElementException 異常");
            e.printStackTrace();
        }

        try {
            System.out.print("當 s2 有值時獲取到值：");
            System.out.println(s2.orElseThrow(() -> new RuntimeException("自定義錯誤")));
        } catch (RuntimeException e) {
            System.out.println("s2.orElseThrow：當 null 時，拋出自定義異常");
            e.printStackTrace();
        }

        System.out.println("======ifPresentOrElse======");

        System.out.println("|||||||||| s3 創建Optional 值 = null ||||||||||");
        Optional<String> s3 = Optional.ofNullable(null);
        // 一個Consumer，當Optional對象有值時，這個消費者會被值做為參數調用
        // Runnable，當Optional對象為空時，這個運行會被調用
        s3.ifPresentOrElse((x) -> {
            System.out.println("Consumer 被調用，值：" + x);
        },() -> {
            System.out.println("值為空，Runnable 被調用");
        });

        System.out.println("===========");
        // 不管有沒有值都會執行此 getStr 函數
        System.out.println(s3.orElse(getStr()));
    }
}
