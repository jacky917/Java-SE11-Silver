package org.example.ch10.q02;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(args.length);
        } catch (NullPointerException e) {
            System.out.println("error");
        } finally {
            System.out.println("finally");
        }
    }
}
