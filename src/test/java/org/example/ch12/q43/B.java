package org.example.ch12.q43;

/**
 * 子類無法通過正常手動訪問父類 private 方法
 */
//public class B extends A{
//    public int test(int num) {
//        if (isValue(num)) {
//            return num;
//        }
//        return 0;
//    }
//}

import java.lang.reflect.Method;

/**
 * 使用反射改寫
 */
public class B extends A{
    public int test(int num) {
        try {
            // 使用 getDeclaredMethod 而不是 getMethod，因為 getDeclaredMethod 可以獲取所有的方法，無論其為 public 或 private
            Method method = A.class.getDeclaredMethod("isValue", int.class);
            // 允許存取 private 方法
            method.setAccessible(true);
            // 第一個參數是你希望調用該方法的對象（在這裡，this 指的就是當前的對象）。隨後的參數是你希望傳遞給該方法的參數（在這裡，只有一個參數 num）
            Boolean result = (Boolean) method.invoke(this, num);
            if (result) {
                return num;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
