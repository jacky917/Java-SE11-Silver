package org.example.test_1Z0816.ch10;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.util.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import static org.example.test_1Z0816.ch10.o02.PropertiesDemo.stringPropertyNamesDemo;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/18
     * 最後一次查看：2023/12/18
     * 題目考點：Locale
     * 需要補足知識：創建實例的方法
     * 複習：查看以下 總結 和 o01
     * 總結：
     * 1.使用構造函數。
     * 2.使用靜態工廠方法。
     * 3.使用常量。
     * 4.獲取默認 Locale。
     * 5.使用 Locale.Category 獲取特定的 Locale。
     * 6.使用 Locale.Builder()
     * -------------------------------------
     * 在大多數情況下，如果沒有特別的設置，這兩個方法傳回的可能是相同的 Locale 實例。
     * Locale 類別允許應用程式在不同的上下文中使用不同的 Locale 設定。 例如，一個應用程式可能會在使用者介面中使用一種語言（DISPLAY），
     * 而在格式化資料時使用另一種語言和地區設定（FORMAT）。因此，雖然在預設情況下這兩個方法可能會傳回相同的 Locale，但它們的用途和可能的設定是不同的。
     * 總結來說，如果沒有為 DISPLAY 類別單獨設定預設 Locale，Locale.getDefault() 和 Locale.getDefault(Locale.Category.DISPLAY)
     * 通常會傳回相同的值。 然而，了解和使用這些類別仍然是國際化應用程式中的一個重要方面，因為它們提供了更細粒度的控制。
     */
    public void test_q01() {
        // #01 使用構造函數
        Locale locale1 = new Locale("en");
        Locale locale2 = new Locale("en", "US");
        Locale locale3 = new Locale("en", "US", "WIN");

        // #02 使用靜態工廠方法
        Locale localeFromTag = Locale.forLanguageTag("en-US");

        // #03 使用常量
        Locale englishLocale = Locale.ENGLISH;
        Locale usLocale = Locale.US;

        // #04 獲取默認Locale
        Locale defaultLocale = Locale.getDefault();

        // #05 使用Locale.Category獲取特定的Locale

        // 設置用戶界面的默認語言為法語
        Locale.setDefault(Locale.Category.DISPLAY, Locale.FRENCH);
        // 設置格式化日期和數字的默認地區為德國
        Locale.setDefault(Locale.Category.FORMAT, Locale.GERMANY);

        Locale displayLocale = Locale.getDefault(Locale.Category.DISPLAY);
        Locale formatLocale = Locale.getDefault(Locale.Category.FORMAT);

        // #06 使用 Locale.Builder()
        Locale locale = new Locale.Builder().setLanguage("jp").setRegion("JP").setScript("Jpan").build();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/18
     * 最後一次查看：2023/12/18
     * 題目考點：Locale 實例的創建
     * 需要補足知識：Locale.Builder()
     * 複習：查看總結和 #q01
     * 總結：
     * setLanguage(String language): 設定語言代碼。 語言代碼是小寫的兩到三個字母的 ISO 639 代碼。
     * setScript(String script): 設定腳本程式碼。 腳本代碼是 ISO 15924 中定義的四個字母的代碼。
     * setRegion(String region): 設定國家/地區代碼。 國家代碼是大寫的兩個字母的 ISO 3166 代碼或三個數字的 UN M.49 代碼。
     * setVariant(String variant): 設定變體代碼。 變體代碼可以用來指示特定的變體，如正式或非正式的使用。
     * setExtension(char key, String value): 設定擴充。 每個擴充都是一個單字母鍵和對應的值。
     * addUnicodeLocaleAttribute(String attribute): 新增 Unicode 語言環境屬性。
     * removeUnicodeLocaleAttribute(String attribute): 移除指定的 Unicode 語言環境屬性。
     * setUnicodeLocaleKeyword(String key, String type): 設定 Unicode 語言環境關鍵字。
     * clear(): 清除所有設置，重置 Locale.Builder。
     * clearExtensions(): 清除所有擴展，但保留語言、腳本、國家和變體設定。
     */
    public void test_q04() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/18
     * 最後一次查看：2024/01/11
     * 題目考點：Properties
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：
     * prop.getProperty(String key)
     * 用途：getProperty(String key) 方法專門用於讀取屬性檔。 它會傳回與指定鍵關聯的字串值。
     *     傳回類型：傳回的是 String 類型。 如果屬性不存在，則傳回 null。
     *     特點：這是 Properties 類別特有的方法，不是從 Hashtable 繼承的。 它只用於處理字串類型的鍵值對。
     *     prop.get(Object key)
     * 用途：get(Object key) 方法是 Hashtable 類別的一部分，Properties 類別從 Hashtable 繼承了這個方法。 它可以用於取得與鍵關聯的值。
     *     傳回類型：傳回的是 Object 類型。 這意味著你可能需要將結果轉換為適當的類型。
     * 特點：由於 Properties 繼承自 Hashtable，這個方法可以用來取得任何類型的對象，而不僅僅是字串。 然而，在標準的屬性檔案使用場景中，鍵和值通常都是字串。
     */
    public void test_q07() {
        Path path = Utils.getPath("test_1Z0816/ch10/o02");
        try(InputStream input = new FileInputStream(path + "/" + "config.properties")){
            Properties prop = new Properties();
            // 載入配置文件
            prop.load(input);
            // 獲取屬性值
            Set<String> strings = prop.stringPropertyNames();
//            Set<Object> objects = prop.keySet();
            for(String key : strings) {
                String value = prop.getProperty(key);
                Object obj = prop.get(key);
                System.out.println("getProperty ：" + key + ": " + value);
                System.out.println("        get ：" + key + ": " + obj);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/18
     * 最後一次查看：2023/12/18
     * 題目考點：Properties
     * 需要補足知識：打印
     * 複習：查看以下代碼
     * 總結：如果只要打印的話最簡單的方式是使用 prop.list(System.out)
     */
    public void test_q08() {
        Path path = Utils.getPath("test_1Z0816/ch10/o02");
        try(InputStream input = new FileInputStream(path + "/" + "config.properties")){
            Properties prop = new Properties();
            // 載入配置文件
            prop.load(input);
            prop.list(System.out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/18
     * 最後一次查看：2023/12/18
     * 題目考點：Properties
     * 需要補足知識：API
     * 複習：查看 q07
     * 總結：-
     */
    public void test_q09() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/18
     * 最後一次查看：2023/12/18
     * 題目考點：properties
     * 需要補足知識：編碼
     * 複習：-
     * 總結：從 Java 9 開始，.properties 可以使用UTF-8保存，在此之前只能使用 ISO 8859-1
     */
    public void test_q11() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2024/01/11
     * 最後一次查看：2024/01/11
     * 題目考點：ResourceBundle
     * 需要補足知識：讀取順序
     * 複習：查看總結
     * 總結：
     * ResourceBundle 在 Java 中用於載入特定於區域設定的資源，如本地化字串。 當請求一個資源包時，ResourceBundle 會根據一定的優先順序來尋找資源。
     * 這個查找過程依賴資源包的基本名稱、目標區域設定（Locale），以及可用的資源包檔案。
     * --------------------------
     * 資源包的查找順序
     * -------------
     * 假設請求的基本名稱為 BaseName，目標區域設定為 Locale(language, country, variant)，資源包的尋找順序如下：
     * 完全指定的區域設定：
     *   BaseName_language_country_variant
     *   如果 Locale 是完全指定的（包含語言、國家和變體），首先會尋找完全匹配的資源包。
     * 省略變體：
     *   BaseName_language_country
     *   如果沒有找到完全符合的資源包，會嘗試尋找省略變體的資源包。
     * 僅包含語言：
     *   BaseName_language
     *   接下來會嘗試尋找只包含語言的資源包。
     * 只有基本名稱：
     *   BaseName
     *   如果以上都沒有找到，會嘗試尋找只有基本名稱的資源包。
     * 預設區域設定：
     *   如果指定的 Locale 和預設區域設定不同，則上述步驟會針對預設 Locale 重複一次。
     * 只有基本名稱的預設資源包：
     *   最後，如果其他所有嘗試都失敗了，ResourceBundle 會嘗試載入僅基於基本名稱的預設資源包（不包含任何區域設定資訊的資源包）。
     * 注意事項
     *   如果在任何階段找到了匹配的資源包，查找過程將停止。
     *   資源包可以是屬性檔或 Java 類別。
     *   對於屬性文件，文件名稱應該與上述模式相匹配，如 BaseName_en_US.properties。
     *   對於 Java 類，類別名稱應該與模式匹配，並且類別應該擴展 ResourceBundle 或其子類別。
     * 範例
     *   假設有一個基本名稱為 Messages，區域設定為 Locale("en", "US", "WIN")，查找順序將是：
     *   Messages_en_US_WIN
     *   Messages_en_US
     *   Messages_en
     *   Messages
     *   如果預設區域設定不是 en_US，則重複上述步驟，但以預設區域設定為目標。
     *   最後，嘗試 Messages 作為預設資源包。
     * 透過這種方式，ResourceBundle 為不同區域設定提供了靈活的資源尋找機制，使得應用程式可以根據使用者的區域設定顯示不同的資源（如文字資訊）。
     */
    public void test_q13() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/11
     * 最後一次查看：2024/01/11
     * 題目考點：ResourceBundle
     * 需要補足知識：getBundle
     * 複習：查看以下代碼
     * 總結：getBundle 有多種構造器，其中常用的兩個是單獨 baseName 和 baseName + locale
     */
    public void test_q15() {
        Locale locale = new Locale("zh", "TW");
        ResourceBundle messages1 = ResourceBundle.getBundle("Messages", locale);
        ResourceBundle messages2 = ResourceBundle.getBundle("Messages");
    }


    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/11
     * 最後一次查看：2024/01/11
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






