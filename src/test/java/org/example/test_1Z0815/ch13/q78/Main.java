package org.example.test_1Z0815.ch13.q78;


/**
 *   1.靜態變量初始化：當Main類被加載時，靜態變量會被初始化為其對應類型的默認值（在這種情況下是int的默認值0）。
 *   2.靜態初始化塊執行：靜態初始化塊會按照它們在代碼中的順序被執行。在這個例子中，靜態初始化塊將num的值設置為30。
 *   3.顯式靜態變量初始化：靜態變量在聲明時的初始化會按照它們在代碼中的順序執行。所以num會被重新賦值為10。
 *   4.main方法執行：當main方法被調用時，它會調用sample方法，該方法會打印num的當前值，也就是10。
 *   5.但是取值操作無法在聲明之前 java: illegal forward reference
 */
public class Main {
    public static void main(String[] args) {
        sample();
        Main main = new Main();
        System.out.println(main.num2);
//        int a = b;
//        int b = num;
    }

    private static void sample() {
        System.out.println(num);
    }

    private void sample2() {
        System.out.println(this.num2);
    }

    {
        this.num2 = 10;
    }

    static {
        num = 30;
        // java: illegal forward reference
        // System.out.println(num);
    }
    static int num = 10;
    int num2 = 5;

//    static {
//        System.out.println("static block " + num);
//    }
}