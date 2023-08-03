package org.example.ch13.q25;

public class Test {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass(); // 創建 OuterClass 的實例
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(); // 創建 InnerClass 的實例
        innerClass.printMessage(); // 調用 printMessage 方法
    }
}
