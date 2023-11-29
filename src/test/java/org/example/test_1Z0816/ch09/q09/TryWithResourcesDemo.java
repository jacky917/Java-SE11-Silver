package org.example.test_1Z0816.ch09.q09;

import java.io.IOException;

public class TryWithResourcesDemo {
    public static void main(String[] args) {
        try (Sample s = new Sample()){
            System.out.println("throw Exception");
            throw new Exception("try block throw Exception");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("catch IOException");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch Exception");
        }
    }
}
