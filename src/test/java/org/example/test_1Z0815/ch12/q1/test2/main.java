package org.example.test_1Z0815.ch12.q1.test2;//package test2;

/**
 * 沒有package，默認使用無包的方式
 * 即命令行
 * javac A.java
 * javac B.java
 * javac main.java
 * 這個情況下Java運行環境會嘗試在無包內嘗試尋找A和B，
 * 但由於A和B內聲明了package，這將導致尋找不到A和B而報錯
 * －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
 * jacky917@kyous-MacBook-Pro test2 % javac main.java
 * main.java:8: error: cannot find symbol
 *         A.A_func();
 *         ^
 *   symbol:   variable A
 *   location: class main
 * main.java:9: error: cannot find symbol
 *         B.B_func();
 *         ^
 *   symbol:   variable B
 *   location: class main
 * 2 errors
 * －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
 * 解決方法：
 * 1.編譯和執行時帶上包名，即test1的方式
 * 2.去除掉package，即使用無包默認模式（不推薦）
 * 此測試使用第二種方式
 */
public class main {
    public static void main(String[] args) {
        A.A_func();
        B.B_func();
    }
}