package org.example.test_1Z0815.ch12.q41;


/**
 * 在這個程式碼中，ID 介面嘗試實現兩個從 IA 介面繼承並覆寫 a 方法的介面，這兩個介面是 IB 和 IC。
 * 然而，IB 和 IC 的 a 方法返回類型並不一致，一個返回 Collection，另一個返回 Path。在 Java 中，
 * 當子介面或子類要重寫父類或父介面的方法時，其方法的簽名必須一致，包括方法名、參數列表以及返回類型。
 * 在這個情況下，ID介面無法確定應該繼承哪個 a 方法的版本，因為它們的返回類型並不相同。這種情況下，
 * Java 編譯器無法確定哪個方法應該被繼承，這就引發了編譯錯誤。若要解決這個問題，可以考慮讓所有繼承的介面有一致的方法簽名，
 * 包括返回類型。至於在ID介面中，雖然你嘗試通過覆寫 a 方法來解決問題，但實際上並不能解決問題。因為無論ID的 a 方法返回什麼類型，
 * 都無法同時滿足IB和IC的 a 方法返回類型的要求。所以，這個問題的根本原因還是在於IB和IC的 a 方法返回類型的不一致。
 */
//public interface ID extends IB,IC{
//    @Override
//    default Collection a() {
//        return null;
//    }
//}

public interface ID{
//    @Override
//    default Collection a() {
//        return null;
//    }
}