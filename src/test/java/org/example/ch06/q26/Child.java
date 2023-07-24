package org.example.ch06.q26;

public class Child extends Parent{
    public static void main(String[] args) {
        // System.out.println(num); <- 無法直接調用非靜態參數
        Child child = new Child();
        System.out.println(child.num);
    }
}
