package org.example.test_1Z0816.ch10.o03;

/**
 * native2ascii 是 Java 開發工具包（JDK）中的實用程序，它用於在本地字元編碼的文字和 Unicode 編碼的文字之間進行轉換。
 * 這個工具尤其有用於處理屬性檔案（.properties 檔案），因為 Java Properties 類別預設以 ISO 8859-1 編碼來讀取這些檔案。
 * -encoding encoding_name：指定輸入檔案的字元編碼。
 * -reverse：反向操作，即從 Unicode 轉換為本機字元集。
 */
public class PropertiesTool {
    public static void main(String[] args) {
        // 將 UTF-8 編碼的檔案轉換為 Unicode：
        // native2ascii -encoding UTF-8 input_utf8.txt output_unicode.txt
        // 將包含 Unicode 的檔案轉換回 UTF-8：
        // native2ascii -reverse -encoding UTF-8 input_unicode.txt output_utf8.txt
    }
}
