package org.example.ch10.q11;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int randomNum = (int)(Math.random() * 10) + 1;
            System.out.println(randomNum);
            try {
                if (randomNum > 5) {
                    System.out.println("SampleException");
                    throw new SampleException();
                } else {
                    System.out.println("TestException");
                    throw new TestException();
                }
            }
            catch (SampleException e) {
                System.out.println("----------------");
            }
            // 沒有 catch TestException 編譯器也不會報錯，但運行會報錯
        }
    }
}
