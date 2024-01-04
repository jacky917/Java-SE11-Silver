package org.example.test_1Z0816.ch13.q52;

public class Sample {
    public static void main(String[] args) {
        //錯誤
        //Subject subject = new Subject("A");

        //修改方式1 改為 static 類
        Subject1 subject1 = new Subject1("A");

        //修改方式2 先創建外部類實例
        Subject2 subject2 = new Sample().new Subject2("A");
    }

    class Subject {
        String name;
        Subject(String name) {
            this.name = name;
        }
    }

    static class Subject1 {
        String name;
        Subject1(String name) {
            this.name = name;
        }
    }

    class Subject2 {
        String name;
        Subject2(String name) {
            this.name = name;
        }
    }
}
