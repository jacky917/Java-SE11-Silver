package org.example.test_1Z0816.ch01.q15;

public enum Animal {
    DOG("Dog", 4),      // 使用第一個構造器
    BIRD("Bird", 2, true);  // 使用第二個構造器

    private String name;
    private int legs;
    private boolean canFly;

    // 第一個構造器
    Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
        this.canFly = false;
    }

    // 第二個構造器
    Animal(String name, int legs, boolean canFly) {
        this.name = name;
        this.legs = legs;
        this.canFly = canFly;
    }
}