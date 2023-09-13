package org.example.test_1Z0816.ch09.q07;

public class Main {
    public static void main(String[] args) {
        A a_out = new A();
        try (A a = new A(); B b = new B(); C c = new C(); a_out) {
            System.out.println("try");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
