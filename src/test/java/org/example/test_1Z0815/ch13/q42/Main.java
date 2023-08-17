package org.example.test_1Z0815.ch13.q42;

public class Main {
    public static void main(String[] args) {
        try (Sample s = new Sample()){
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("caught Exception");
        } finally {
            System.out.println("finally");
        }
    }
}
