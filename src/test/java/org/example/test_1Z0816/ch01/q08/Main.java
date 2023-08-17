package org.example.test_1Z0816.ch01.q08;

public class Main {
    public static void main(String[] args) {
        Sample sample = new Sample() {
            {
                System.out.println("Sample block");
            }
//            public Sample(int i) {
//                System.out.println("Sample Constructor " + i);
//            }
        };
    }
}
