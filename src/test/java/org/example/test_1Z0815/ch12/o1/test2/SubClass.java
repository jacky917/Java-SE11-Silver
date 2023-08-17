package org.example.test_1Z0815.ch12.o1.test2;


class Parent {

    /* 静态变量 */
    public static String p_StaticField = "父类--静态变量";
    /* 变量 */
    public String p_Field = "父类--变量";
    protected int i = 9;
    protected int j = 0;

    /* 静态初始化块 */
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
        // 報錯，同樣是靜態的情況下，執行順序按照代碼順序
        // System.out.println( p_StaticField2 );
        // System.out.println( "父类--静态初始化块2" );
    }

    /* 初始化块 */ {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
        // 報錯，原因同靜態的情況
        // System.out.println( p_Field2 );
        // System.out.println( "父类--初始化块2" );
    }

    /* 静态变量 */
    public static String p_StaticField2 = "父类--静态变量2";
    /* 变量 */
    public String p_Field2 = "父类--变量2";

    /* 构造器 */
    public Parent() {
        System.out.println("父类--构造器");
        System.out.println("i=" + i + ", j=" + j);
        j = 20;
    }
}

public class SubClass extends Parent {
    /* 静态变量 */
    public static String s_StaticField = "子类--静态变量";
    /* 变量 */
    public String s_Field = "子类--变量";

    /* 静态初始化块 */
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
//        System.out.println(s_StaticField2);
//        System.out.println("子类--静态变量2");
    }

    /* 初始化块 */ {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }

    public static String s_StaticField2 = "子类--静态变量2";

    /* 构造器 */
    public SubClass() {
        System.out.println("子类--构造器");
        System.out.println("i=" + i + ",j=" + j);
    }


    /* 程序入口 */
    public static void main(String[] args) {
        System.out.println("子类main方法");
        new SubClass();
    }
}
