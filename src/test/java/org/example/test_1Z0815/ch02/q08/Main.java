package org.example.test_1Z0815.ch02.q08;

public class Main {
    public static void main(String[] args) {
        var a1 = new B();
//         a1 = new C();
//         a1.test();
//
//        a1 = (B)new C();
//        a1.test();

        A a2 = new A();
        // 父類轉子類 ClassCastException
        B b = (B) a2;
        // 祖父類轉子類 ClassCastException
        D d = (D) a2;

        // 基本數據類型轉換失敗全都是編譯異常
//        String s = "Hello";
//        int i = (int) s;s
//        將一個int轉換成boolean：
//
//        int i = 1;
//        boolean b = (boolean) i;
//        將一個物件轉換成不相關的類型：

        // 沒有繼承關係
//        String s = "Hello";
//        File f = (File) s;

//        Object obj1 = new String("Hello");
//        Integer int1 = (Integer) obj1; // ClassCastException at runtime
//
//        Object obj2 = new Integer(1);
//        String str2 = (String) obj2; // ClassCastException at runtime
//
//        Object obj3 = new Double(1.0);
//        Float flt3 = (Float) obj3; // ClassCastException at runtime
//
//        Object obj4 = new ArrayList<Integer>();
//        LinkedList<Integer> list4 = (LinkedList<Integer>) obj4; // ClassCastException at runtime
//
//        Object obj5 = new HashMap<Integer, String>();
//        TreeMap<Integer, String> map5 = (TreeMap<Integer, String>) obj5; // ClassCastException at runtime
//
//
//        String str1 = "Hello";
//        File file1 = (File) str1; // Compilation error
//
//        Integer int2 = 1;
//        Double dbl2 = (Double) int2; // Compilation error
//
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        HashSet<Integer> set3 = (HashSet<Integer>) list3; // Compilation error
//
//        File file4 = new File("path");
//        BufferedReader br4 = (BufferedReader) file4; // Compilation error
//
//        StringBuffer sb5 = new StringBuffer("Hello");
//        StringBuilder sbuilder5 = (StringBuilder) sb5; // Compilation error

    }
}
