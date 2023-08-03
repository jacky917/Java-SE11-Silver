package org.example.ch13.q29;

public class Sample {
    private final int num;

    {
        System.out.println("非靜態代碼塊");
    }
    public Sample(String str) {
        this(Integer.parseInt(str));
        System.out.println("構造器");
    }
    public Sample(int num) {
        System.out.println("構造器");
        this.num = num;
    }

//    public Sample() {
//    }

    public int getNum() {
        return this.num;
    }
}