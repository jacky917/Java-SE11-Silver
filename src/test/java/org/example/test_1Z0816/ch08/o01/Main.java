package org.example.test_1Z0816.ch08.o01;

public class Main {

    @SuppressWarnings("deprecation")
    public static void test1() {
        // 當 @Deprecated(forRemoval = true) 時，使用deprecation也無效果
        //DeprecatedClass.deprecatedMethod1();
        // 當 @Deprecated 時，使用deprecation可以消除警告
        DeprecatedClass.deprecatedMethod2();
    }

    @SuppressWarnings("removal")
    public static void test2() {
        // 當 @Deprecated(forRemoval = true) 時，使用removal可以抑制編譯錯誤
        DeprecatedClass.deprecatedMethod1();
        // 當 @Deprecated 時，使用removal無效果
        DeprecatedClass.deprecatedMethod2();
    }



    public static void main(String[] args) {
        //https://www.notion.so/Java-SuppressWarnings-f683dc7e78b64df78846aaf0cb4e426f
        @SuppressWarnings("unused") // @Retention(RetentionPolicy.SOURCE)
        String s = "";

        // 當 @Deprecated(forRemoval = true) 時，不抑制警告將無法編譯
        // DeprecatedClass.deprecatedMethod1();
        // 當 @Deprecated 時，僅警告
        DeprecatedClass.deprecatedMethod2();
    }
}
