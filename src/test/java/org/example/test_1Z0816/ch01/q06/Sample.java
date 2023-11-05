package org.example.test_1Z0816.ch01.q06;

/**
 * 局部內部類 A 的 execute 方法中使用了兩個變數：message 和 value。message 是外部類的成員變量，而 value 是 test 方法的參數。
 * 1.局部內部類使用外部類的成員變量是沒有問題的。
 * 2.局部內部類可以存取包含它的方法的final局部變數。在Java 8及以後，即使不明確地將變數宣告為 final，
 *   只要在方法中不再修改該變數，它在實際上仍然是 "effectively final"，並且局部內部類可以使用它。
 *   -> 但題目 value 被改變了值，這會使 value 不再是 "effectively final"，所以編譯器會報錯。
 */
public class Sample {
    private String message;
    public Test test(String value) {
        class A implements Test {

            @Override
            public void execute() {
                System.out.println(message + value);
            }
        }
        // value = "LocalClass";
        message = "Hello, ";
        return new A();
    }
}


/**
 * 匿名內部類
 */
class SampleAnonymous {
    private String message;
    public Test test(String value) {
        return new Test() {
            @Override
            public void execute() {
                // value = "LocalClass";
                message = "Hello, ";
            }
        };
    }
}

/**
 * lambda
 */
class SampleLambda {
    private String message;
    public Test test(String value) {
        return () -> {
            // value = "LocalClass";
            message = "Hello, ";
        };
    }
}