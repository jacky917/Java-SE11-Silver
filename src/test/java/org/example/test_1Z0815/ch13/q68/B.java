package org.example.test_1Z0815.ch13.q68;

import java.util.*;

public class B extends A{
    // 僅有泛型不一樣，不是有效的重載或是重寫
//    public List<Number> test(Set<String> s) {
//        return null;
//    }
//    public ArrayList<Integer> test(Set<CharSequence> s) {
//        return null;
//    }
//    public List<Integer> test(Set<String> s) {
//        return null;
//    }
//    @Override
//    public List<Object> test(Set<CharSequence> s) {
//        return null;
//    }
//    public List<Integer> test(Set<CharSequence> s) {
//        return null;
//    }

    // 重寫的話，返回值允許和父類一樣或是父類的子類
//    @Override
//    public ArrayList<Number> test(Set<CharSequence> s) {
//        return null;
//    }

    // 重載不關注返回類型，只要方法名一致，參數列表不一致即可，參數列表不一致，不包含泛型不同的情況
//    public List<Integer> test(TreeSet<String> s) {
//        return null;
//    }

    // 僅有返回值不一樣的情況，編譯器視為同一個方法，不構成重載
    // 如果返回值是父類返回值的子類，構成協變返回類型
//    @Override
//    public ArrayList<Number> test(Set<CharSequence> s) {
//        return null;
//    }

    public List<Number> test(HashSet<CharSequence> s) {
        return null;
    }
}
