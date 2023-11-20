package org.example.test_1Z0816.ch05.o02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 實現從鍵盤讀入，輸出大寫
 */
public class KeyBoardInputTest {


    public static void UseScanner() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        while (!"e".equals(s) && !"exit".equals(s)) {
            System.out.println(s.toUpperCase());
            s = scanner.next();
        }
    }

    public static void UseBuffer() {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ){
            String s = bufferedReader.readLine();
            while(s != null && !"e".equals(s) && ! "exit".equals(s)) {
                System.out.println(s.toUpperCase());
                s = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        UseScanner();
        UseBuffer();
    }
}
