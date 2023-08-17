package org.example.test_1Z0816.ch01.q15;

public class Main {
    public static void main(String[] args) {
        // 基本用法
        System.out.println("-----基本用法-----");
        Test test = Test.A;
        System.out.println(test);
        // 為枚舉值添加屬性和方法
        System.out.println("-----為枚舉值添加屬性和方法-----");
        System.out.println(Planet.MERCURY.surfaceGravity());
        // 使用switch語句與枚舉
        System.out.println("-----使用switch語句與枚舉-----");
        Test test2 = Test.A;
        switch (test2) {
            case A:
                System.out.println("A");
                break;
            case B:
                System.out.println("B");
                break;
            case C:
                System.out.println("C");
                break;
        }
        // 迭代所有枚舉值
        // Animal.values 獲取所有枚舉值
        System.out.println("-----迭代所有枚舉值-----");
        for (Test test3 : Test.values()) {
            System.out.println(test3);
        }
        System.out.println(Test.values()[0]);
        // 使用枚舉的ordinal()方法
        // 每個枚舉值都有一個整數索引，稱為其序數值，你可以通過ordinal()方法獲取。
        System.out.println("-----使用枚舉的ordinal()方法-----");
        int index = Test.A.ordinal();
        System.out.println("index " + index);
        // 在枚舉中覆蓋方法
        System.out.println("-----在枚舉中覆蓋方法-----");
        int result = Operation.ADD.apply(5, 3);  // 8
        System.out.println(result);
        // 多構造器的枚舉
        System.out.println("-----多構造器的枚舉-----");
        Animal animal1 = Animal.BIRD;
        Animal animal2 = Animal.DOG;
        System.out.println(animal1);
        System.out.println(animal2);
    }
}
