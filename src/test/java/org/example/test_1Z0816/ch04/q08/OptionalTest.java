package org.example.test_1Z0816.ch04.q08;

import java.util.Optional;

/**
 * 雖然兩個isPresent檢查都會傳回false，但calc方法的用法可能會導致混淆和錯誤，
 * 因為在map之後使用Optional.ofNullable可以處理null傳回值，但這不是Optional的預期用法。
 * 始終應該使用calc2那種方式，因為它遵守了Optional的設計準則，並且對於使用者來說，行為是清晰和一致的。
 */
public class OptionalTest {
    public static void main(String[] args) {

        // 不推薦的做法
        Optional<Integer> a = Optional.of(-1);
        Optional<Integer> b = a.map(price -> calc(price, 3));
        // false
        System.out.println(b.isPresent());

        // 正確的做法
        Optional<Integer> c = Optional.of(-1);
        Optional<Integer> d = c.flatMap(price -> calc2(price,3));
        // false
        System.out.println(d.isPresent());

        // 題目，不應該返回 Optional<Integer>，如果返回 Optional 應該使用 flatMap
//        Optional<Integer> a = Optional.of(100);
//        Optional<Integer> b = a.map(price -> calc2(price, 3));
//        System.out.println(b.get());

    }

//    題目的錯誤代碼
//    private static Optional<Integer> calc(int price, int qty) {
//        if(qty < 0) {
//            return Optional.empty();
//        }
//        return Optional.of(price * qty);
//    }

    private static Integer calc(int price, int qty) {
        if(price < 0) {
            // 返回 null 將會喪失 Optional 的檢查功能
            return null;
        }
        return price * qty;
    }

    private static Optional<Integer> calc2(int price, int qty) {
        if(price < 0) {
            return Optional.empty();
        }
        return Optional.of(price * qty);
    }
}
