package org.example.test_1Z0816.ch10.o02;

import org.example.util.Utils;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * Java中的Properties類是一種用於處理配置文件的特殊類型的集合。它擴展自Hashtable，
 * 提供了一種從配置文件中讀取和寫入鍵值對（key-value pairs）的機制。以下是Properties的一些主要特點和用法：
 * 鍵值對存儲：Properties類主要用於處理鍵（key）和值（value）均為字符串（String）的情況。
 * 配置文件處理：通常用於讀取和寫入配置文件，如.properties文件。
 * 繼承自Hashtable：它是Hashtable的子類，因此它本身是同步的（thread-safe）。
 * Properties類是Java中處理配置數據的一個方便工具，特別適用於需要輕量級且簡單的配置管理的場景。
 * 注意事項
 * 1.文件格式：標準的.properties文件是簡單的文本文件，鍵值對以等號=或冒號:分隔。
 * 2.字符編碼：標準的.properties文件使用ISO 8859-1字符集。包含其他字符集的數據需要使用Unicode轉義序列。
 * 3.註釋：以#或!開頭的行被視為註釋。
 * 4.從 Java 9 開始，.properties可以使用UTF-8保存，在此之前只能使用 ISO 8859-1
 */
public class PropertiesDemo {

    public static void print(Properties properties) {
        print(properties,false);
    }

    /**
     * 打印的三種方式
     * @param properties 對象
     * @param flag 標示
     */
    public static void print(Properties properties, boolean flag) {

        // 方式一
        properties.list(System.out);

        // 方式二
        properties.forEach((k,v) -> System.out.println("key:" + k + "," + "value:" + v));
        System.out.println("==============");

        if (flag) {
            Set<String> strings = properties.stringPropertyNames();
            // 方式三
            for(String key : strings) {
                String value = properties.getProperty(key);
                System.out.println(key + ": " + value);
            }
        } else {
            Set<Object> strings = properties.keySet();
            for(Object key : strings) {
                Object value = properties.get(key);
                System.out.println(key + ": " + value);
            }
        }
    }

    /**
     * 創建Properties對象：首先，創建一個Properties對象的實例。
     * 從HashMap中讀取數據：然後遍歷HashMap，將其鍵值對添加到Properties對象中。
     * 將Properties對象寫入文件：最後，使用Properties類的store方法將屬性保存到文件中。
     */
    public static void create(Path path) {
        // 創建一個HashMap實例
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");

        // 創建Properties對象
        Properties properties = new Properties();

        // 將HashMap中的數據添加到Properties中
        for (String key : hashMap.keySet()) {
            properties.setProperty(key, hashMap.get(key));
        }

        // 將Properties對象保存到文件
        try {
            properties.store(new FileOutputStream(path + "/" + "config.properties"), "Properties File");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 創建Properties對象：首先，創建一個Properties對象的實例。
     * 從HashMap中讀取數據：然後遍歷HashMap，將其鍵值對添加到Properties對象中。
     * 將Properties對象寫入文件：最後，使用Properties類的store方法將屬性保存到文件中。
     */
    public static void stringPropertyNamesDemo(Path path) {
        // 創建一個HashMap實例
        HashMap<Object, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put(new Object(), "value4");

        // 創建Properties對象
        Properties properties = new Properties();

        // 將HashMap中的數據添加到Properties中
        for (Object key : hashMap.keySet()) {
            // 一般來說推薦使用 setProperty，因爲他能確保 key 是 String
            properties.put(key, hashMap.get(key));
            // properties.setProperty(key, hashMap.get(key));
        }
        System.out.println("==============");
        // 調用 stringPropertyNames
        print(properties,true);
        System.out.println("==============");
        // 調用 keySet
        print(properties,false);
    }


    /**
     * stringPropertyNames vs keySet
     * 返回類型:
     * stringPropertyNames() 返回一個 Set<String>，其中包含所有的鍵，這些鍵都被確保為 String 類型。
     * keySet() 返回一個 Set<Object>，表示 Properties 對象的鍵可以是任何類型的對象。雖然在 Properties 中通常鍵是 String，但由於 Properties 繼承自 Hashtable<Object, Object>，所以理論上鍵可以是任何對象。
     * 使用場景:
     * 當你確定所有的鍵都是 String 並且想要一個類型安全的集合時，使用 stringPropertyNames() 是更好的選擇。
     * 如果你需要處理的 Properties 對象可能包含非字符串類型的鍵，則應該使用 keySet()。但這在標準的 Properties 使用中很少見。
     * 兼容性和安全性:
     * stringPropertyNames() 是一個相對較新的方法（自 Java 6 起引入），它提供了更好的類型安全性，因為它保證集合中的所有元素都是 String 類型。
     * keySet() 是從 Hashtable 繼承來的，因此它的使用更為通用，但在處理 Properties 時，它不提供與鍵相關的類型安全性。
     * 在大多數標準使用 Properties 的情況下，建議使用 stringPropertyNames()，因為 Properties 文件通常只包含字符串鍵。
     * 注意點:
     * 如果鍵不是 String，那麼不會出現在 stringPropertyNames 的結果中
     * ----------------------------------------
     * 標準 .properties 檔案使用ISO 8859-1編碼。 如果你的屬性檔案遵循這個標準，那麼使用 FileInputStream 是更好的選擇，因為它將正確處理檔案。
     * 如果檔案使用不同的編碼（例如UTF-8），並且確信這個編碼與JVM的預設編碼相匹配，那麼可以使用 FileReader。 但是，這通常不是建議的做法，因為它依賴JVM的預設編碼，可能導致在不同環境中有不同的行為。
     * 總的來說，對於標準的 .properties 文件，建議使用 FileInputStream 以確保正確的編碼處理。 對於非標準編碼的文字文件，可能需要考慮使用 FileReader，但這種情況較少見。
     *
     * @param args args
     */
    public static void main(String[] args) {
        Path path = Utils.getPath("test_1Z0816/ch10/o02");
        stringPropertyNamesDemo(path);
//        create(path);
        try(InputStream input = new FileInputStream(path + "/" + "config.properties")){
//        try(FileReader input = new FileReader(path + "/" + "config.properties")){
            Properties prop = new Properties();
            // 載入配置文件
            prop.load(input);
            // 獲取屬性值
            Set<String> strings = prop.stringPropertyNames();
            for(String key : strings) {
                String value = prop.getProperty(key);
                System.out.println(key + ": " + value);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
