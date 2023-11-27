package org.example.test_1Z0816.ch07.o01;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.泛型類的構造器不需要加上泛型
 * 2.泛型不同的引用不能互相賦值
 * 3.靜態方法不能用泛型
 * 4.異常類不能用泛型
 * 5.new數組不能使用泛型
 * 6.B是A的子類，但ArrayList<A>和ArrayList<B>並不具類繼承關係，兩者是並列關係，兩者共同的父類是ArrayList<?>
 * 7.通配符 <?> （非境界ワイルドカード）不能加數據，除了添加 null 之外，但可以自由讀取（Object）
 * 8.
 */
public class GenericsDemo<T,E> {

    public GenericsDemo() {

    }

    // 一般的方法
    public T[] test1(T t){
        return (T[]) new Object[10];
        // 5.編譯不通過
//        return new T[10];
    }

    // 泛型方法（方法又另外定義了一個泛型），方法的類或是接口是不是泛型沒有要求
    // 泛型參數和類的泛型參數沒有關係
    public <A> A test2(A a){
        return a;
    }

    // 因爲類的泛型是造對象的時候指定的，但靜態方法加載早於它
//    public static T test3(T t){
//        return t;
//    }


    public static void main(String[] args) {

        ArrayList<Number> numbers1 = new ArrayList<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        // Incompatible types. Found: 'java.util.ArrayList<java.lang.Integer>', required: 'java.util.ArrayList<java.lang.Number>'
        // numbers1 = integers1;

        // 泛型一樣的話可以
        ArrayList<Integer> integers2 = new ArrayList<>();
        List<Integer> integers3 = new ArrayList<>();
        integers3 = integers2;

        ArrayList<?> arr = new ArrayList<>();
        // 7.'add(capture<?>)' in 'java.util.ArrayList' cannot be applied to '(java.lang.String)'
        // arr.add("string");
        arr.add(null);
    }
}
