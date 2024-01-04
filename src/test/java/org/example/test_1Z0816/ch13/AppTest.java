package org.example.test_1Z0816.ch13;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.util.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
     * 🌟🌟
     * 創建日期：2023/12/22
     * 最後一次查看：2023/12/22
     * 題目考點：InputStreamReader(System.in)
     * 需要補足知識：查看
     * 複習：查看 #ch05 o02 KeyBoardInputTest
     * 總結：和 Scanner（next） 一樣，需要先讀取（readLine）
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/22
     * 最後一次查看：2023/12/22
     * 題目考點：Files
     * 需要補足知識：Files.lines
     * 複習：查看以下代碼
     * 總結：Files.lines 接收一個 Path，並返回一個流
     */
    public void test_q02() {
        try {
            Path path = Utils.getPath("test_1Z0816/ch13/data/test.txt");
            // public static Stream<String> lines(Path path) throws IOException
            try (Stream<String> lines = Files.lines(path)) {
                lines.forEach(x -> {
                    System.out.println("-----");
                    System.out.println(x);
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：SPI（Service Provider Interface）
     * 需要補足知識：SPI概念
     * 複習：查看複習
     * 總結：
     * SPI 定義：
     *     SPI（Service Provider Interface）是一種服務發現機制，允許發現和加載實現特定接口的服務提供者。
     * 接口和實現分離：
     *     SPI 使接口定義與實現分離。開發者定義一個接口，而具體的實現可以由第三方提供。
     * META-INF/services 目錄：
     *     服務提供者在其 JAR 文件的 META-INF/services 目錄下創建一個以接口全名命名的文件。
     *     該文件列出了實現該接口的具體類的全限定名。
     * ServiceLoader 類：
     *     Java 通過 ServiceLoader 類來加載服務提供者。
     *     ServiceLoader.load() 方法讀取相應的配置文件，並加載列出的實現類。
     * 動態服務加載：
     *     SPI 機制使得應用程序在運行時動態發現和加載服務，增加了應用程序的擴展性和靈活性。
     * 使用場景：
     *     SPI 廣泛用於許多 Java 標準庫和框架中，例如 JDBC 驅動加載、日誌框架、文件系統提供者等。
     * 題目：所以 load 取出來是一個數組（該接口的多種實現）
     */
    public void test_q03() {
        ServiceLoader<String> load = ServiceLoader.load(String.class);
        for(String s : load) {
            System.out.println(s);
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：Comparator
     * 需要補足知識：API
     * 複習：-
     * 總結：
     * 如果是比較器，重寫的函數名是 compare。
     * 如果是類實現 Comparable 重寫的函數名是 compareTo。
     */
    public void test_q06() {
        Comparator<Object> comparator = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：包裝類
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：基本數據類型的包裝類不適用自動類型提升
     */
    public void test_q07() {
        List<Integer> list = List.of(0, 1, 2, 3, 4);
        // Integer 無法賦值給 Double
//        Double a = list.get(0);
        double b = list.get(0);
        Integer c = Integer.valueOf(list.get(0));
        Double d = Double.valueOf(list.get(0));
        Integer e = list.get(0);
        int f = list.get(0);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：同時實現，繼承
     * 需要補足知識：此題是 ch01#q13 的進階
     * 複習：查看 ch01#q13 和 ch13#q08
     * 總結：
     * 1.如果類同時實現了接口又繼承了類，則優先調用繼承的方法（這是執行時的規則，不是編譯階段的規則）
     * -> 所以編譯階段編譯器可以正常調用接口的默認方法，但是執行時調用的是繼承的方法，導致報錯
     *    Exception in thread "main" java.lang.IllegalAccessError
     * 2.如果以上狀況將實現去除，則會編譯錯誤，因爲找不到調用的方法（繼承的方法不可見）
     */
    public void test_q08() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：機密情報の改ざんを防止する方法
     * 需要補足知識：日語
     * 複習：查看以下總結
     * 總結：
     * 1.機密情報は、変更不可能なオブジェクトまたは不変オブジェクトに格納する。⭕
     * 2.セキュリティマネージャーを使用する。⭕
     * 3.機密情報を扱うインスタンスから情報が漏洩する可能性を考え、信頼できるオブジェクトのみがアクセスできるようにする。❌
     *   →　因為代碼有可能被替換，所以錯誤。
     * 4.機密情報は、ユーザーが独立に作成したライブラリで処理する。❌
     * 5.機密情報が含まれているインスタンスは、不要になったらできるだけ速やかにメモリから削除する。❌
     */
    public void test_q11() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：DateTimeFormatter
     * 需要補足知識：API DateTimeFormatter的格式化輸出
     * 複習：查看 ch10#o01 和以下代碼
     * 總結：-
     */
    public void test_q13() {
        Locale locale = Locale.getDefault();
        LocalDate now = LocalDate.now();
        // Dec 26, 2023
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(locale)));
        // 12/26/23
        System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(locale)));
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：JDBC
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：
     * 1.enquoteIdentifier 是 Java 中 java.sql.DatabaseMetaData 介面的一個方法，用於將給定的字串轉換為一個資料庫識別碼的參考形式。
     *   這個方法主要用於在建構 SQL 查詢時處理資料庫識別碼（例如表名或列名），確保它們在特定的資料庫中被正確解釋和使用。
     *   主要用途
     *     轉換標識符：enquoteIdentifier 用於將一個普通字串轉換為資料庫能夠識別的標識符。 例如，如果資料庫要求表名和列名使用特定的引號包圍，則該方法能夠自動新增這些引號。
     *     防止 SQL 注入：透過正確地引用標識符，enquoteIdentifier 有助於防止 SQL 注入攻擊，這是一種常見的安全威脅，攻擊者透過在 SQL 查詢中插入惡意程式碼來攻擊資料庫。
     * 2.不使用 enquoteIdentifier 的話，傳遞字串需要加上引號。
     */
    public void test_q14() throws SQLException {
        Connection connect = Utils.getConnect();
        Statement statement = connect.createStatement();
        String sql1 = "select * from people where name = Alice"; // 錯誤
        String sql2 = "select * from people where name = 'Alice'";
        String sql3 = "select * from people where name = " + statement.enquoteIdentifier("Alice",true);
        boolean execute = statement.execute(sql2);
        System.out.println(execute);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：AutoCloseable
     * 需要補足知識：API
     * 複習：AutoCloseable 重寫的方法名是 close。
     * 總結：-
     */
    public void test_q15() {
    }

    /**
     * 🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：泛型
     * 需要補足知識：泛型
     * 複習：查看 q17
     * 總結：不使用泛型的話會當作是使用 Object，所以當需要調用類的專有方法時需要強轉。
     */
    public void test_q17() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：Console
     * 需要補足知識：API
     * 複習：查看 ch05#q08
     * 總結：獲取到的密碼可以正常打印出來。（readPassword）
     */
    public void test_q18() {
    }

    /**
     * 🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：集合
     * 需要補足知識：API
     * 複習：查看一下代碼
     * 總結：
     * 1.list 和 set 可以使用構造器相互轉換。
     * 2.list允許重複元素，set 不允許。
     */
    public void test_q19() {
        LinkedList<String> list1 = new LinkedList<>();
        HashSet<String> set1 = new HashSet<>();
        String[] array = {"a","b","c","d","a"};
        for(String s : array) {
            list1.add(s);
            set1.add(s);
        }
        System.out.print(set1.size() + "," + list1.size() + ",");
        HashSet<String> set2 = new HashSet<>(list1);
        LinkedList<String> list2 = new LinkedList<>(set1);
        System.out.print(set2.size() + "," + list2.size() + ",");
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/26
     * 最後一次查看：2023/12/26
     * 題目考點：Runnable
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：System.out::println 可以有入參也可以沒有。
     */
    public void test_q20() {
        // 兩個調用的重載不同
        // System.out.println();
        Runnable runnable = System.out::println;
        // System.out.println(params);
        Consumer consumer = System.out::println;
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：jdeps
     * 需要補足知識：-jdkinternals
     * 複習：查看總結
     * 總結：JDKの内部APIでクラスレベルの依存関係を検索するためのです。内部APIとは、Javaプログラマーが利用するためのライブラリではなく、
     * 標準クラスライブラリ内で利用されることが指定されていなければ、-classpathオプションおよび入力ファイルで指定されたクラスがすべて分析されます。
     * -jdkinternals：這個選項用於特別識別和報告應用程式對 JDK 內部 API 的依賴。 這些 API 包括那些在 sun.*、com.sun.* 等套件中的類別和介面。
     *     由於這些 API 不保證在不同版本的 JDK 中保持相容，因此識別這些依賴項對於遷移至新版本的 Java 特別重要。
     * -cp 或 -classpath <路徑>：指定應用程式和庫的類別路徑。
     * -recursive 或 -R：遞歸地分析依賴。
     * -summary：只顯示概要輸出而非詳細輸出。
     * -verbose:class：顯示每個類別的詳細依賴資訊。
     * -version：顯示 jdeps 的版本資訊。
     * -help：顯示 jdeps 的幫助資訊。
     */
    public void test_q22() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：
     * 需要補足知識：
     * 複習：查看以下代碼 & ch04#o01
     * 總結：
     * 1.Stream.of 返回的是對象流
     * 2.要使二維數組流扁平化，使用 flatMap
     */
    public void test_q23() {
        // 跟題目相比鏈式調用拆分了，更方便看返回類型
        int array[][] = {{1,2},{3,4},{5,6}};
        Stream<int[]> stream = Stream.of(array);
        IntStream intStream = stream.flatMapToInt(IntStream::of);
        long count = intStream.map(n -> n * 2).peek(System.out::print).filter(n -> (n % 3 == 0)).count();
        System.out.println("\ncount = " + count);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：機密情報を保護する
     * 需要補足知識：日語
     * 複習：查看以下總結
     * 總結：
     * 1.機密情報を明確に識別する。⭕
     *   -> 保護機密情報前需要先明確哪些是機密情報。
     * 2.機密情報を格納する前に入力を検証する。⭕
     * 3.機密情報を保持するオブジェクトへのアクセスを制限する。⭕
     * 4.機密情報をカプセル化。❌
     * 5.障害時の解析を効率化するため、情報を透過的に処理する。❌
     * 6.ユーザーからの入力を通常の情報として扱う。❌
     * 7.機密情報をほかの情報と同じように管理する。❌
     */
    public void test_q24() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：枚舉
     * 需要補足知識：
     * 複習：查看 q25，ch01#q16
     * 總結：
     * 1.枚舉類的構造器必定為 private (可以不明寫)。
     * 2.枚舉可以實現 Serializable 接口。
     * 3.成員變量可以用 final 和 static 修飾。
     * 4.枚舉類不能是 protected 和 private，這是因為枚舉類型的主要目的是用來定義一組固定的常數，其存取等級應該是公開的（public）或包級私有的。
     */
    public void test_q25() {
    }

    /**
     * 🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：接口
     * 需要補足知識：-
     * 複習：查看以下總結和 q26
     * 總結：
     * 1.接口無法定義 "實例" 成員變量
     * 2.接口只能有 public 和 private 方法
     *   Java 8 之前：
     *      在 Java 8 之前，接口中只能定義 public 抽象方法。 這些方法預設是 public 的，且不能有具體實作。
     *   Java 8 之後：
     *      從 Java 8 開始，接口不僅可以包含 public 抽象方法，還可以包含具有實作的 default 方法和 static 方法。
     *      這些 default 和 static 方法必須提供具體的實作。
     *      default 方法允許在不影響實作接口的現有類別的情況下，為接口新增功能。
     *      static 方法則屬於接口本身，而非接口的實例。
     *   Java 9 之後：
     *      從 Java 9 開始，接口還可以包含私有方法和私有靜態方法。 這些方法僅在接口內部使用，用於支援 default 方法和 static 方法的程式碼重複使用。
     * 3.接口不能有 final 方法，接口的目的是定義一個可以被其他類別實現的契約，其中的方法旨在被實現或重寫。
     *    由於 final 方法不可以被重寫，因此在接口中宣告 final 方法與接口的設計初衷相悖。
     */
    public void test_q26() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     * 1.path.normalize 是 Java NIO（New I/O）中 Path 介面的一個方法，用於規範化路徑表示。
     *   這個方法的主要目的是清理路徑字串，去除其中的冗餘元素，例如 "."（目前目錄）和 ".."（上一級目錄）等，以及處理路徑中的多餘的檔案分隔符號。
     * 2.Paths ../ 是上一層的意思。
     */
    public void test_q28() {
        Path path = Paths.get("a/b/v/d/../../..d");
        // a/b/..d
        System.out.println(path.normalize());
    }

    /**
     * 🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：異常處理
     * 需要補足知識：-
     * 複習：查看 q29
     * 總結：Exception 的子類和 RuntimeException 不存在父子關係。
     */
    public void test_q29() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：NIO
     * 需要補足知識：API Files.deleteIfExists
     * 複習：查看以下代碼
     * 總結：
     * 文件存取權限問題：
     *    如果程式沒有足夠的權限刪除文件，例如文件被標記為唯讀或程式運行在一個受限的安全性上下文中。
     * 文件鎖定或正在使用：
     *    如果檔案正在被作業系統或另一個行程使用，嘗試刪除可能導致異常。
     * 檔案系統問題：
     *    檔案系統的問題，如磁碟錯誤、檔案損壞或其他 I/O 錯誤，可能導致刪除操作失敗。
     * 符號連結問題：
     *    如果嘗試刪除的路徑是一個符號鏈接，而且這個符號鏈接指向的實際資源有問題，可能會拋出異常。
     * 網路檔案系統的問題：
     *    如果檔案位於網路檔案系統（如 NFS）上，則網路問題或檔案系統的特殊行為也可能導致 I/O 異常。
     * 儘管 deleteIfExists 透過傳回 false 來優雅地處理檔案不存在的情況，但上述提到的其他問題仍然需要透過擷取 IOException 來處理。
     * 這就是為什麼在使用 Files.deleteIfExists(Path) 時需要包含 try-catch 區塊的原因，以確保程式能夠處理所有潛在的 I/O 相關錯誤。
     */
    public void test_q30() {
        try {
            Path path = Paths.get("sample.txt");

            // 如果檔案不存在直接拋出錯誤
            Files.delete(path);
            // 如果檔案存在，則刪除該檔案並傳回 true；如果檔案不存在，則傳回 false。
            boolean result = Files.deleteIfExists(path);
            if(result) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        } catch (IOException e) {
            System.out.println("C");
        }
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：模塊
     * 需要補足知識：SPI
     * 複習：查看總結
     * 總結：
     * 1.模塊配置文件中 uses 關鍵字的作用：
     *    在模塊的配置文件（module-info.java）中，uses 關鍵字用於聲明模塊使用了某個服務接口。
     *    這主要是為了讀取 SPI 的實現類使用，表示該模塊依賴於這個接口的實現。
     * 2.當缺少實現類時的行為：
     *    如果 ServiceLoader 在執行時找不到相應的服務實現，它不會拋出異常；而是不會返回任何服務實現的實例。
     *    這意味著，如果沒有相應的實現類，ServiceLoader 只是讀取不到實現類，而不會因此報錯。
     * 3.添加實現類的靈活性：
     *    SPI 的一大優點是可以在運行時動態地添加新的實現類。你可以在不重新編譯依賴該服務的模塊的情況下，直接向模塊路徑中添加包含服務實現的新模塊。
     * 4.實現類模塊的依賴聲明：
     *    提供服務實現的模塊（即實現特定服務接口的模塊）需要在其 module-info.java 文件中使用 requires 語句來聲明對服務接口模塊的依賴。
     *    這樣做是為了確保服務提供者模塊可以正確引用並實現那些接口。
     */
    public void test_q31() {
    }

    /**
     * 🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：ArrayList
     * 需要補足知識：API
     * 複習：查看總結
     * 總結：set 和 remove 給的都是 index（從 0 數起）
     */
    public void test_q34() {
        var list = new ArrayList<>();
        list.add("A");
        list.add(100);
        list.add("B");
        list.set(1,200);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }

    /**
     * 🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：防止內存溢出
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：BufferedReader 等I/O對象不應該大量同時開啟。
     */
    public void test_q35() {
        ArrayList<Reader> list = new ArrayList<>();
        File file = new File("sample.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            for(String fileName = br.readLine(); fileName != null; br.readLine()) {
                // 應該在這邊使用 try-with-resources
                BufferedReader br2 = new BufferedReader(new FileReader(fileName));
                list.add(br2);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            for (Reader r : list) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：List.copyOf
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：List.copyOf 創建的是一個不可修改的副本，添加元素將會拋出 java.lang.UnsupportedOperationException 異常。
     */
    public void test_q36() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = List.copyOf(list1);
        list2.add(3);
        List<List<Integer>> list3 = List.of(list1, list2);
        System.out.println(list3);
    }

    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：可重錄鎖
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：
     * 1.ReentrantLock不一定要是static（只要能確保是同一個鎖即可）
     * 2.new ReentrantLock(true) 啟用公平鎖（不推薦，因爲會嚴重影響效能）
     */
    public void test_q39() {
        // 以下代碼沒有問題
        try {
            lock.lock();
            // do something
        } finally {
            lock.unlock();
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：JDBC
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：prepareStatement 設置參數可以沿用上一個提交的內容。
     */
    public void test_q40() {
        String sql = "INSERT INTO people (name, age) VALUES (?, ?)";
        Connection connect = Utils.getConnect();
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            //	Jane Doe	27
            // 	Jacky Wu	27
            // 插入了兩條
            pstmt.setString(1, "Jane Doe");
            pstmt.setString(2, "27");
            pstmt.executeUpdate();
            // 沿用 27 歲
            pstmt.setString(1, "Jacky Wu");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：IntStream.generate
     * 需要補足知識：API
     * 複習：查看 ch04#o01
     * 總結：generate 接收一個 IntSupplier 參數
     */
    public void test_q45() {
        Random random = new Random();
//        IntStream intStream = IntStream.generate(random::nextInt).limit(5); // lambda
        IntStream intStream = IntStream.generate(() -> random.nextInt()).limit(5);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     * 1.Collectors.averagingDouble 可以用來統計平均數。
     * 2.average API 只有基本數據類型流才有。
     */
    public void test_q46() {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(integers.stream().collect(Collectors.averagingDouble(n -> n)));
        integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        OptionalDouble average = integers.stream().mapToInt(n -> n).average();
//        System.out.println(average.getAsDouble());
        System.out.println(average.orElse(-1));
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     * forEach
     *   無序處理：
     *     forEach 對流中的元素執行提供的操作，但不保證元素的處理順序。 特別是在並行流的情況下，元素可能會以任意順序進行處理。
     *   性能優勢：
     *     在平行流上使用 forEach 可能會提高效能，因為它允許更靈活的元素處理順序，從而實現更有效的平行處理。
     *   用途：
     *     當元素處理的順序不重要時，可以使用 forEach。 它適用於那些元素之間相互獨立且無順序要求的場景。
     * forEachOrdered
     *   保持順序處理：
     *     forEachOrdered 保證按照流的遇到順序（encounter order）處理元素，即使在平行流中也是如此。
     *   適用於平行流：
     *     當使用並行流並且需要保持元素的初始順序時，forEachOrdered 是合適的選擇。
     *   性能考量：
     *     由於 forEachOrdered 保持元素的處理順序，因此在並行流上可能會降低效能，特別是當保持元素順序需要額外的協調時。
     * findAny & findFirst 返回的是一個 Optional
     */
    public void test_q47() {
        List<String> list = List.of("ABCG", "DEF", "GHI", "JKL");

        list.stream().filter(a -> a.contains("G")).forEachOrdered(System.out::println);

        // 獲取一個
        Optional<String> stringOptional1 = list.stream().filter(a -> a.contains("G")).findAny();
        Optional<String> stringOptional2 = list.stream().filter(a -> a.contains("G")).findFirst();

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：Comparator.comparing
     * 需要補足知識：API
     * 複習：
     * 總結：
     * Comparator.comparing 是 Java 中 Comparator 介面的靜態方法，用於建立比較器，該比較器根據提供的函數對物件的鍵進行比較。
     * 這個方法非常有用，因為它允許您快速建立比較器，特別是在使用 lambda 表達式和方法參考時。
     * thenComparing：
     *   如果兩個物件根據第一個比較器相等，則使用第二個比較器進行比較。
     *   可用於多層排序，例如先按年齡排序，然後按名字排序。
     * reversed：
     *   傳回與原比較器相反的比較器。
     * nullsFirst 和 nullsLast：
     *   分別傳回一個比較器，比較器會將 null 視為小於或大於非 null 值。
     *
     */
    public void test_q48() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：線程池
     * 需要補足知識：executorService.execute executorService.submit 差別
     * 複習：查看 ch03#04
     * 總結：-
     */
    public void test_q49() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 返回 Future（參數可接收 Runnable 和 Callable）
        Future<?> submit = executorService.submit(() -> System.out.println());
        // 無返回值
        executorService.execute(System.out::println);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/28
     * 最後一次查看：2023/12/28
     * 題目考點：無限流
     * 需要補足知識：iterate
     * 複習：查看以下代碼
     * 總結：使用 iterate 產生無限流，第一個元素是提供的種子（第一個參數）
     */
    public void test_q50() {
        // 產生一個無限序列，並通過limit()設置大小 [0, 1, 2, 3, 4]
        IntStream.iterate(0, n -> n + 1).limit(5).forEach(System.out::println);
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：內部類
     * 需要補足知識：內部類創建實例
     * 複習：查看 q52
     * 總結：如果在當前外部類中實例化，不需要寫外部類的名字，僅限於 static 類（ch01#q03）
     */
    public void test_q52() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：reduce
     * 需要補足知識：API
     * 複習：查看 q53
     * 總結：
     * 1.基本數據流和對象流 reduce 方法的傳入參數不一樣。
     * 2.使用 mapToInt 轉換為 int 基本數據流。
     * 3.使用 map 一樣是對象流，用於轉換對象類型。
     */
    public void test_q53() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：方法引用
     * 需要補足知識：語法
     * 複習：查看以下代碼
     * 總結：方法引用在 Java 中總是函數式接口的實作。
     */
    public void test_q54() {
        // void is not a functional interface
        // Consumer a = msg -> System.out::println;
        // 修正 System.out::println 是方法引用，它本身就是函數式接口的實現，而不是應該在 lambda 表達式內部被呼叫的方法。
        Consumer a = msg -> System.out.println();

        // Incompatible parameter types in lambda expression: expected Object but found String
        // Consumer b = (String msg) -> System.out.println(msg);
        // 修正
        Consumer<String> b1 = (String msg) -> System.out.println(msg);
        // 等價
        Consumer<String> b2 = System.out::println;

        Consumer c = System.out::println;

        // Cannot resolve symbol 'var'. ';' expected.
        // Consumer d = var msg -> {System.out.println(msg);};
        // 修正
        Consumer d = (var msg) -> {System.out.println(msg);};

    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：DateTimeFormatter
     * 需要補足知識：構造函數
     * 複習：查看以下代碼
     * 總結：DateTimeFormatter 構造器傳入的是一個字符串，' 用於轉譯文本
     * y：年份
     * M：月份
     * d：一個月中的天數
     * H：小時（24小時制）
     * h：小時（12小時制）
     * m：分鐘
     * s：秒
     * S：毫秒
     * E：星期幾的縮寫
     * '：用於轉義文本
     */
    public void test_q55() {
        LocalDate date = LocalDate.of(2021, 4, 1);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MMMM月dd日");
        System.out.println(formatter1.format(date));
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy'年' MMMM d'日' ee");
        System.out.println(formatter2.format(date));
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：Locale
     * 需要補足知識：setDefault 的重載
     * 複習：查看 ch10#q01
     * 總結：setDefault 有兩種重載方法。
     */
    public void test_q57() {
        // 第一種重載方法
        // public static synchronized void setDefault(Locale newLocale)
        Locale.setDefault(Locale.JAPANESE);
        // 第二種重載方法
        // public static synchronized void setDefault(Locale.Category category, Locale newLocale)
        Locale.setDefault(Locale.Category.DISPLAY, Locale.FRENCH);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：NIO
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：move 傳入的兩個 Path 對象，都要是 路徑 + 檔案名，不能是文件夾路徑。
     *      否則拋出 java.nio.file.FileAlreadyExistsException 異常。
     */
    public void test_q61() {
        Path src = Utils.getPath("test_1Z0816/ch13/q61/d1/test.txt");
        Path dest = Utils.getPath("test_1Z0816/ch13/q61/d2");
        try {
            Files.move(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：模塊
     * 需要補足知識：配置文件
     * 複習：查看總結
     * 總結：
     * module api {
     *     // 接口
     *     export com.sample.api;
     * }
     * module provider {
     *     requires api;
     *     // 提供具體實現（可以有多個模塊提供）
     *     provides com.sample.api with com.test.impl;
     * }
     * module api {
     *     // 當模組需要使用在另一個模組中定義的介面或類別時，需要使用 requires。
     *     export com.sample.api;
     *     // 當想要使用 ServiceLoader 動態載入某個服務的實作時需要使用 uses。
     *     uses com.sample.api;
     * }
     * 組合使用
     *    在許多情況下，當使用 SPI 時，您可能需要同時使用 requires 和 uses：
     *    使用 requires 來確保您的模組可以存取服務介面（通常定義在另一個模組中）。
     *    使用 uses 來聲明您的模組將動態查找並使用該服務介面的實作。
     * 1.requires 和 uses 通常會組合使用。
     * 2.provides + with 可以在多個模塊中使用（提供實現類）
     * 3.opens 主要用於開放反射存取權限，適用於某些框架和程式庫。provides 用於聲明服務提供者，允許模組化和解耦的服務載入。
     *   儘管 opens 可以使得反射可以存取實作類，但它並不符合服務載入的模組化和解耦原則，這是 provides 所專門用來處理的。
     */
    public void test_q62() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：泛型
     * 需要補足知識：泛型
     * 複習：查看以下代碼
     * 總結：
     * 1.沒有指定泛型的話，視為 Object。
     * 2.字符串和基本數據類型的包裝類，equals 都有重寫過（不會單純比較內存地址）。
     */
    public void test_q67() {
        Object o1 = "A";
        Object o2 = "A";
        Object o3 = new String("A");
        // true
        System.out.println(o1.equals(o2));
        // true
        System.out.println(o1 == o2);
        // true
        System.out.println(o1.equals(o3));
        // false
        System.out.println(o1 == o3);

        System.out.println("-------------");

        Object o4 = 1;
        Object o5 = 1;
        Object o6 = new Integer(1);

        // true
        System.out.println(o4.equals(o5));
        // true
        System.out.println(o4 == o5);
        // true
        System.out.println(o4.equals(o6));
        // false
        System.out.println(o4 == o6);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：序列化
     * 需要補足知識：serialPersistentFields
     * 複習：查看 q71
     * 總結：
     * transient 關鍵字和 serialPersistentFields 陣列都用於 Java 序列化過程中控制類別的哪些欄位被序列化，但它們各自有不同的用途和應用場景。
     * transient 關鍵字
     *    用途：transient 關鍵字用於聲明類別中的某個欄位不應該被序列化。 它是字段級別的聲明。
     *    簡單性：在欄位宣告中使用 transient 是一種簡單直接的方法來排除不需要序列化的欄位。
     *    靈活性：透過將 transient 新增至欄位定義中，可以輕鬆控制不同欄位的序列化行為。
     * serialPersistentFields 數組
     *    用途：serialPersistentFields 用於精確控制一個類別的序列化行為。 它定義了一個明確的字段列表，指明哪些字段應該被序列化。
     *    精確控制：serialPersistentFields 提供了一種方式來定義一個類別的可序列化的 "視圖"，這在複雜類別或需要細微控制的情況下非常有用。
     *    相容性：在某些情況下，使用 serialPersistentFields 可以協助維護向後相容性。 例如，當類別的欄位在不同版本之間有所變化，但需要保持序列化形式不變時。
     * 為什麼需要兩者
     *    雖然 transient 在大多數情況下足夠用於控製字段的序列化行為，但 serialPersistentFields 提供了更高級的控制。
     *    特別是在需要精確定義一個序列化形式，或是當類別的結構較為複雜且隨時間變化時，serialPersistentFields 就顯得非常重要。
     *    它允許開發者定義一個不變的、精確的序列化規範，即使類別的其他部分隨時間變化。
     * 總結
     *    使用 transient 關鍵字是一種快速簡單的方法來排除類別中的某些欄位不被序列化。
     *    使用 serialPersistentFields 提供了一種更精確的方式來控制整個類別的序列化行為，適用於更複雜或需要維護特定序列化相容性的情況。
     *    在決定使用哪種方式時，應考慮到類別的複雜性、序列化的需求以及維護的便利性。
     *    在大多數簡單應用中，transient 通常足夠使用。 對於更複雜的場景，可能需要考慮使用 serialPersistentFields。
     */
    public void test_q71() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：collect
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：collect 不接收 List 作為參數。
     */
    public void test_q72() {
        List<String> data = List.of("apple", "banana", "orange");
        List<String> backup1 = new ArrayList<>();
        List<String> backup2 = new ArrayList<>();
        // str -> str.indexOf('n') != -1 要求存在 n
        Predicate<String> predicate = str -> str.indexOf('n') != -1;


        data.parallelStream().filter(predicate).forEach(str -> backup1.add(str));
        System.out.println(backup1);

        backup1.clear();

        // collect 的兩種入參
        // <R> R collect(Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner)
        // <R, A> R collect(Collector<? super T, A, R> collector);
        // data.stream().filter(predicate).parallel().collect(backup); //錯誤

        data.stream().filter(predicate).parallel().forEach(str -> backup1.add(str));
        System.out.println(backup1);

        backup2 = data.stream().filter(predicate).parallel().collect(Collectors.toList());

        System.out.println(backup2);
    }

    /**
     * 🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：流
     * 需要補足知識：final
     * 複習：查看 q75
     * 總結：局部變量可以使用 final 修飾
     */
    public void test_q75() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/04
     * 最後一次查看：2024/01/04
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}