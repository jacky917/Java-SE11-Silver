package org.example.test_1Z0816.ch08.o01;

public class DeprecatedClass {
    // 假設有兩個即將被移除的方法
    @Deprecated(forRemoval = true)
    public static void deprecatedMethod1() {
        System.out.println("deprecatedMethod1");
    }

    @Deprecated
    public static void deprecatedMethod2() {
        System.out.println("deprecatedMethod2");
    }
}
