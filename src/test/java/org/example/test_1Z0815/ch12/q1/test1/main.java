package org.example.test_1Z0815.ch12.q1.test1;

import org.example.test_1Z0815.ch12.q1.test1.A.A;
import org.example.test_1Z0815.ch12.q1.test1.B.B;

/**
 * 不使用默認的無包模式，聲明package並依照以下命令行編譯，運行
 * javac test1/A/A.java
 * javac test1/B/B.java
 * javac test1/main.java
 * －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
 * jacky917@kyous-MacBook-Pro q1 % java test1/main
 * A
 * B
 * －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
 */
public class main {
    public static void main(String[] args) {
        A.A_func();
        B.B_func();
    }
}