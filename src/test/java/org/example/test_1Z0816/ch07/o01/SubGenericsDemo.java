package org.example.test_1Z0816.ch07.o01;


// 全部保留
//public class SubGenericsDemo<T,E> extends GenericsDemo<T,E>{
//}

// 部分保留
//public class SubGenericsDemo<T> extends GenericsDemo<T,String>{
//}


// 等價於 public class SubGenericsDemo<T,E> extends GenericsDemo<Object,Object>
//public class SubGenericsDemo<T,E> extends GenericsDemo{
//}

public class SubGenericsDemo<T,E,A,B> extends GenericsDemo<T,E>{
}
