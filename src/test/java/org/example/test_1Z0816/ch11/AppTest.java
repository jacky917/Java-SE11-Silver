package org.example.test_1Z0816.ch11;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ServiceLoader;

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
     * 創建日期：2023/12/19
     * 最後一次查看：2023/12/19
     * 題目考點：模塊
     * 需要補足知識：使用模塊的好處
     * 複習：查看以下總結
     * 總結：
     * 1.公開されたクラスにしたアクセスできないためセキュリティーが高まる。
     *     除了公開的類別無法訪問，所以安全性提高。
     * 2.モジュール間の依存関係を明確化できる。
     *     可以明確模塊間的依賴關係。
     * 3.プラットフォーム間の整合性が向上する。
     *     模塊化設計可以促進不同平台間的一致性，使得軟體在不同環境下更加穩定和兼容。
     * 4.柔軟な実行環境を実現できる。
     *     模塊化可以實現靈活的執行環境，因為模塊可以獨立於彼此運作。
     * 5.最適化されたモジュール構成によってパフォーマンスが向上する。
     *     通過最佳化的模塊結構可以提升系統性能，因為它允許更有效率的代碼組織和資源管理。
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/19
     * 最後一次查看：2023/12/19
     * 題目考點：日文
     * 需要補足知識：ディレクティブ directive
     * 複習：-
     * 總結：希望透過反射訪問其他模塊中的類時，可以使用 opens 語句。
     */
    public void test_q02() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/12/19
     * 最後一次查看：2023/12/19
     * 題目考點：模塊
     * 需要補足知識：模塊的分類
     * 複習：查看總結
     * 總結：
     * 在 Java 的模塊系統中，模塊（module）被分為三種類型：
     * 無名モジュール　　　無名模塊（Unnamed Module）
     * 自動モジュール　　　自動模塊（Automatic Module）
     * 名前付きモジュール　有名模塊（Named Module）
     * 存取限制：
     * 無名模塊 --使用--> 自動模塊 需要使用 --add-modules
     * 無名模塊 --使用--> 有名模塊 需要使用 --add-modules
     * 自動模塊 --使用--> 無名模塊 可以直接使用　⭕
     * 自動模塊 --使用--> 有名模塊 需要使用 --add-modules
     * 有名模塊 --使用--> 無名模塊 無法使用　　　❌
     * 有名模塊 --使用--> 自動模塊 可以直接使用　⭕
     *
     */
    public void test_q03() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/19
     * 最後一次查看：2024/01/11
     * 題目考點：遷移策略
     * 需要補足知識：遷移策略
     * 複習：查看總結
     * 總結：
     ボトムアップ移行（Bottom-Up Migration）
         定義："ボトムアップ"（自下而上）指的是從基礎或最底層的元件、模組或系統開始遷移或變革的過程。 這種方法首先關注具體的細節，然後逐漸擴展到更高層次的結構和功能。
         特點：專注於單一組件或小部分的改進。逐步實現，每個步驟都具體且容易管理。允許更多實驗和迭代，適應性強。可以在不影響整體系統運作的情況下測試新的方法或技術。
         適用場景：當需要逐步解決具體問題或最佳化特定功能時。在資源有限或風險規避的情況下。當變革需要從基層員工或小團隊開始。
     トップダウン移行（Top-Down Migration）
         定義："トップダウン"（由上而下）指的是從頂層的結構和策略開始遷移或變革的過程。 這種方法首先著眼於整體目標和架構，然後逐步細化到具體的元件和操作。
         特點：從高層策略和規劃開始。對整體視野和方向有清晰的控制。可能需要大規模的調整和重組。依賴高階管理和領導的決策。
         適用場景：當需要實現大規模的組織變革或全面升級系統時。在有明確的長期目標和願景的情況下。當變革需要強而有力的領導和統一的指導。
     比較和選擇：
         ボトムアップ移行 更靈活和適應性強，但可能缺乏整體方向和統一性。
         トップダウン移行 提供了清晰的方向和控制，但可能在細節上不夠靈活，且變革的成本和風險較高。
         在實際應用中，這兩種方法並不是互斥的，而是可以根據具體情況和需求相互結合和平衡。
         在某些情況下，可能會先採用トップダウン的策略來製定總體規劃和方針，然後透過ボトムアップ的方法來具體實施和調整。
     */
    public void test_q04() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/19
     * 最後一次查看：2024/01/11
     * 題目考點：模塊
     * 需要補足知識：命令行
     * 複習：查看總結
     * 總結：
     * m 或 -module：用於指定要運行的模塊和模塊中的主類。Java 9 引入模塊系統（Jigsaw）後新增的參數。
     * p 或 -module-path：用於指定模塊路徑的參數，用於尋找模塊的位置。Java 9 引入模塊系統（Jigsaw）後新增的參數。
     */
    public void test_q06() {
//        java --module-path modules --module App/Main
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/19
     * 最後一次查看：2023/12/19
     * 題目考點：SPI
     * 需要補足知識：SPI
     * 複習：查看以下總結
     * 總結：
     * 1.SPIを実現するためのクラスである。⭕
     * 　　ServiceLoader 用於實作 Java 中的服務提供者介面（SPI）機制。
     * 2.META-INF/service内のファイルを検索する。⭕
     * 　　ServiceLoader 會搜尋 META-INF/services 目錄下的檔案來決定可用的服務提供者。
     * 3.loadメソッドにはclassリテラルを渡す。⭕
     * 　　使用 ServiceLoader 的 load 方法時，需要傳遞一個類別字面量（class literal），也就是服務提供者介面的 Class 物件。
     * 4.クラスファイルをロードするためのクラスである。❌
     * 　　ServiceLoader 不是用來直接載入類別文件的；它是用來載入服務提供者介面（SPI）的實作的。
     * 　　ServiceLoader 透過 尋找 META-INF/services 目錄下的設定檔來決定哪些實作類別需要被載入，然後使用 Java 的類別載入機制來載入這些實作類別。
     */
    public void test_q07() {
        ServiceLoader<String> loader = ServiceLoader.load(String.class);
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/19
     * 最後一次查看：2024/01/11
     * 題目考點：SPI
     * 需要補足知識：模塊配置文件關鍵字
     * 複習：-
     * 總結：
     * 1.模塊聲明中的 uses：當一個模塊希望利用由另一個模塊提供的服務時，可以在其 module-info.java 文件中使用 uses 關鍵字。這表明該模塊依賴於一個特定的服務接口。
     * 2.ディレクティブ directive
     */
    public void test_q08() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/19
     * 最後一次查看：2023/12/19
     * 題目考點：jdeps
     * 需要補足知識：internals（內部結構）
     * 複習：查看總結
     * 總結：當使用 jdeps 工具時，-jdkinternals 選項可以幫助開發者識別出程式碼中對 JDK 內部 API 的使用。
     */
    public void test_q09() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/19
     * 最後一次查看：2023/12/19
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






