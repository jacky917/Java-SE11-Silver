package org.example.test_1Z0815.ch07.q19;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.name = "sample";
        System.out.println(child.getName());

        Parent parent = new Child();
        System.out.println(parent.getChildName());
    }
}
