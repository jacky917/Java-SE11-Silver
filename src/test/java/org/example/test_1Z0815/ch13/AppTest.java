package org.example.test_1Z0815.ch13;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

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
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：異常
     * 需要補足知識：拋出異常
     * 複習：查看 q01
     * 總結：
     * 1.抓取異常只能比拋出的異常範圍要大
     * 2.非受檢異常不強制要求拋出異常（包含error）
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：immutable（不可變的）
     * 需要補足知識：immutableなオブジェクト
     * 複習：查看 q01
     * 總結：
     * immutableなオブジェクト：
     * 1.どのメソッドもオーバライドできない
     * 2.どのメソッドでもフィールドの値を変更しない
     * 3.すべてのフィールを final にする
     */
    public void test_q02() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：基本數據類型
     * 需要補足知識：隱式的 int 轉換為 double
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q03() {
        int a = 10;
        float b = 10.0f;
        float f = 10.0f;
        double c = 20; //隱式的 int 轉換為 double
        a = (int) b;
        b = a;
        c = b;
        c = a;
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：char 轉換
     * 需要補足知識：char 超出有效範圍
     * 複習：查看總結
     * 總結：
     * 1.在Java中，幾乎任何數值類型都可以被轉換為char，包括byte、short、int、long、float和double。
     *   當進行這樣的轉換時，數值的整數部分將被視為Unicode代碼點，並轉換為相應的字符。
     * 2.如果數值超出char的有效範圍（0到65535），則結果可能是未定義的。例如，如果你有一個大於65535的int值，並將其轉換為char，則結果可能是該值與65536的餘數對應的字符。
     */
    public void test_q07() {
        int intValue = 65;
        char charValue = (char) intValue; // charValue 的值是 'A'
        System.out.println(charValue);

        byte byteValue = 66;
        charValue = (char) byteValue; // charValue 的值是 'B'
        System.out.println(charValue);

        double doubleValue = 67.5;
        charValue = (char) doubleValue; // charValue 的值是 'C'，小數部分被截斷
        System.out.println(charValue);

        System.out.println((char) 65534);
        System.out.println((char) 65535);
        System.out.println((char) (65536 + 65)); // 超過 char 範圍，迴繞（65 = A）
    }

    /**
     * 🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：this
     * 需要補足知識：-
     * 複習：查看 q11
     * 總結：-
     */
    public void test_q11() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：權限修飾符
     * 需要補足知識：權限修飾符
     * 複習：查看總結
     * 總結：
     * 1.就算寫在同一個 .java 文件內，不同類也無法調用其他類 private 內容
     * 2.內部類可以使用外部類的 private 內容
     * －－－－－－－－－－－－－－－－
     * public：完全公開，任何地方都可以存取。
     * protected：限制在同一包內和所有子類別中的存取。
     * default（沒有修飾符）：限制在同一包內的存取。
     * private：完全私有，只有在類別內部才能存取。
     */
    public void test_q13() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：java.lang
     * 需要補足知識：java.lang
     * 複習：查看總結，q16
     * 總結：
     * 1.函數返回的類，沒有變量接收不需要導包（查看q16）
     * 2.只有java.lang下的包無需顯示導包
     * －－－－－－－－－－－－－－－－
     * java.lang 包含以下內容
     * 基本數據類型的包裝類：像Integer、Double、Float、Boolean、Character、Byte、Short和Long等，這些類封裝了基本數據類型，使其能夠以對象的方式進行操作。
     * String處理：String、StringBuffer和StringBuilder類。
     * 數學相關的類：如Math類。
     * 系統相關的類：例如System和Runtime類，用於訪問系統資源和執行環境。
     * 多线程相關的類：例如Thread、ThreadGroup和Runnable接口。
     * 異常處理的類：包括Throwable、Exception、Error等，以及一些特定的異常和錯誤類型，例如NullPointerException和IndexOutOfBoundsException。
     * 枚舉類：Enum類，用於定義枚舉。
     * 反射相關的類：例如Class、Method、Field等，用於在運行時分析和操作類和對象。
     * 包和類加載相關的類：如Package和ClassLoader類。
     * 虛擬機接口和管理：例如ManagementFactory。
     */
    public void test_q16() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：類
     * 需要補足知識：類的權限修飾符
     * 複習：查看 q25
     * 總結：
     * 1.類只能被 public 和 default 修飾
     *   public的類可以被任何其他類訪問，不論這些類是否在同一個包（package）中。
     *   如果類沒有使用修飾符，則它具有包級別的訪問權限（package-private）。這意味著只有在同一個包中的類才能訪問它。
     * 2.巢狀類或內部類則有更靈活的訪問控制，可以使用所有四個訪問修飾符：public、protected、private和包級別（無修飾符）。
     * 3.創建內部類實例的語法 OuterClass.InnerClass innerClass = outerClass.new InnerClass();
     * 4.如果外部類不可訪問（例如，被聲明為private或沒有訪問修飾符並且位於不同的包中），則即使其內部類被聲明為public，也不能在外部類的外部創建內部類的實例。
     *   這是因為要創建非靜態內部類的實例，你需要先有一個外部類的實例。但是在這個情況下，如果外部類不可訪問，則無法創建外部類的實例，也就無法創建內部類的實例。
     */
    public void test_q25() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：String API
     * 需要補足知識：String API
     * 複習：查看總結
     * 總結：String 類在 Java 中是不可變的，這意味着一旦創建了String對象，就不能修改它的內容。
     *      所有看似修改String內容的方法，其實都是創建了一個新的String對象並返回。
     */
    public void test_q27() {
        String s = new String("abcde");
        s.replace("a","x");
        s.substring(0,3);
        System.out.println(s);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：final
     * 需要補足知識：final 初始化
     * 複習：查看總結
     * 總結：
     * 1.如果一個成員變量被聲明為final，那麼必須保證在構造函數執行完畢之後，這個成員變量已經被初始化。一旦final變量被初始化，它的值就不能再被改變。
     * 2.final變量如果被初始化兩次以上，將會編譯錯誤 Variable 'num' might already have been assigned to
     * 3.非靜態代碼塊，執行順序先於構造器
     * －－－－－－－－－－－－－－－－
     * final變量可初始化的位置
     * 1.聲明時初始化
     * 2.構造函數中初始化
     * 3.初始化塊中初始化
     */
    public void test_q29() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：接口
     * 需要補足知識：接口的權限修飾符
     * 複習：查看 q30
     * 總結：
     * 1.接口的成員變量必須為常量 public、static、 final，且必須初始化
     * 2.接口的方法必須為 public
     * 3.實現接口的實現類，重寫接口的方法必須為 public
     * 4.抽象類實現了接口，如果有方法未實現完，他的子類（非抽象類）必須實現
     */
    public void test_q30() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：接口
     * 需要補足知識：接口觀念
     * 複習：查看 q32
     * 總結：
     * 1.靜態方法是跟著類的，故無法被重寫
     * 2.接口繼承接口時可以用默認方法去重寫父接口（靜態方法不行）
     * 3.重寫方法的返回類型必須相同或者是父類方法返回類型的子類（這是從Java 5開始支持的，被稱為協變返回類型）
     * 4.Number 是 Java 中所有包裝數字類型的抽象基類。所有包裝類，
     *   如 Integer、Float、Double、Long、Byte 和 Short 都是 Number 類的子類。這樣的設計使得它們可以共享一些通用的操作和特性。
     * 5.Number 是抽象類，無法實例化
     */
    public void test_q32() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：重載
     * 需要補足知識：數組重載
     * 複習：查看 q33
     * 總結：
     * 1.long[] 和 int[] 並沒有繼承關係，所以會選擇調用 Object。
     *   Double[] 和 Integer[] 也沒有繼承關係
     *   Number[] 是 Double[] 和 Integer[] 的父類（不止這兩個）
     * 2.當選擇重載方法時，Java會嘗試選擇最具體和最接近的匹配方法。
     *   在Java中，基本數據類型的寬化轉換（例如從 int 到 double）優先於將基本類型轉換為引用類型（例如將 int 轉換為 Object）。
     * 3.Object是所有數組類型的父類
     * 4.由於Java的數組是協變的，所以你可以將一個Long[]賦值給一個Object[]變量（因為Long是Object的子類）
     *   沒有繼承關係則不行
     * 5.所有數組類都是Object的子類
     */
    public void test_q33() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：數組
     * 需要補足知識：數組觀念
     * 複習：查看總結
     * 總結：
     * 1.數組是引用對象
     * 2.Java允許創建"不規則"或"鬆散"的多維數組
     * 3.創建的規則多維數組，重新賦值一樣可以變為鬆散數組
     */
    public void test_q34() {
        int[][] array = new int[2][4];
        System.out.println(Arrays.deepToString(array));
        array[0] = new int[]{1,2,3,4};
        array[1] = new int[]{1,2};
        System.out.println(array[1].length);
        System.out.println(Arrays.deepToString(array));
        for (int[] a : array) {
            for (int b : a) {
                System.out.println(b);
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("------------");
        int[][] array2 = new int[2][4];
        int[][] array3 = array2;
        array3[0][0] = 99;
        System.out.println(Arrays.deepToString(array2));
        System.out.println("------------");
        // java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 2
        System.out.println(array[1][3]);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：Java 語言特性
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：
     * 1.Javaの実行環境は、異なるプログラミング言語のコンパイラによってコンパイルされた実行可能ファイルも処理できる　❌
     *   Java的執行環境可以處理由不同編程語言的編譯器編譯的可執行文件。❌
     * 2.コンパイラはリソースによってサポートされているかどうかテストする　❌
     * 　編譯是為了測試代碼是否被支持。　❌
     * 　-> 編譯器的工作是將源代碼轉換為目標代碼，而不是進行測試。
     * 3.コンパイルは、特定のプラットフォームで実行するためにクラスを処理する　❌
     *   編譯是為了在特定平台上運行而做的處理。　❌
     *   -> 編譯完成的 .class 文件可以跨平台運行
     * 4.実行時に、クラスは必要に応じてロードされる　⭕　️
     *   在運行時，類會根據需要加載。
     * －－－－－－－－－－－－－－－－
     * Java的跨平台特性是通過編譯和運行兩個階段來實現的。以下是這兩個階段的詳細說明：
     * 1. 編譯階段：
     *   在編譯階段，Java源代碼被編譯成平台無關的字節碼。字節碼是一種中間代碼，它不是針對特定的硬件或操作系統平台的。
     *   編譯過程：使用Java編譯器（例如 javac 命令），將 .java 源文件編譯成 .class 文件，其中包含Java字節碼。
     *   平台無關性：生成的字節碼不依賴於特定的硬件架構或操作系統。相同的 .class 文件可以在任何支持Java的平台上運行。
     * 2. 運行階段：
     *   運行階段是Java虛擬機（JVM）的工作階段。JVM是一個虛擬化的計算機，它將字節碼解釋或編譯成本地機器代碼，並在主機硬件上執行它。
     *   解釋或即時編譯（JIT）：JVM可以通過解釋字節碼或使用即時編譯器（JIT）將字節碼轉換成本地機器代碼來運行Java程序。JIT編譯器在運行時將字節碼編譯成本地機器代碼，這有助於提高性能。
     *   平台依賴的JVM：每個操作系統和硬件架構都有針對其特定平台的JVM實現。這使得JVM可以理解和執行字節碼，並將其轉換為該特定平台的本地機器代碼。
     *   Java標準庫：Java的標準庫提供了一個共同的API，用於執行常見的操作，例如文件訪問、網絡通信等。由於這些庫是用Java寫的，它們也是平台無關的，並且通過JVM在各種平台上運行。
     */
    public void test_q35() {
    }


    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：try-with-resources
     * 需要補足知識：try-with-resources
     * 複習：查看 q42
     * 總結：
     * 1.只要實現了 AutoCloseable 接口，try() 內也可以用來創建對象
     * 2.執行順序是
     *   1.try（try裡面的內容）<- 在拋出異常之前的代碼
     *   2.AutoCloseable（關閉資源）
     *   3.caught Exception（抓取到異常）
     *   4.finally（最後執行）
     */
    public void test_q42() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：模塊
     * 需要補足知識：模塊，日文
     * 複習：查看總結
     * 總結：
     * 1.module-info.javaは、module-path内のどこにでも配置できる ❌　
     *   module-info.java可以放在module-path的任意位置 ❌　
     *   -> モジュールのルートディレクトリに配置します
     *   　　module-info.java必須放在根目錄
     * 2.java.baseをエクスポートすると、すべてのコアパッケージがエクスポートされる ❌　
     *   導出java.base，則所有核心包都會被導出。❌　
     *   -> java.baseは基本なクラス群がまとめられたモジュールであり、どのモジュールにも自動的に組み込まれます。
     *   　　そのため、exportsで宣言する必要はありません。
     *      java.base不需要宣告導出，就會被自動導入到所有模塊中。
     * 3.利用するモジュールは、module-info.java内で宣言されていなければならない ⭕　
     *   必須在module-info.java內宣告要使用的模塊。 ⭕　
     * 4.デフォルトで、モジュールは、モジュールが動作するディレクトリ内にはアクセスできる ⭕　
     *   默認情況下，模塊可以訪問模塊運行的目錄內的內容。 ⭕　
     *   モジュールを実行するときは、、モジュールに対してクラスパスが通ります。
     *   そのため、モジュールに含まれるプログラムは、モジュール内のディレクトリにはアクセス可能です
     *   當執行一個模塊時，該模塊的類路徑（classpath）是可以訪問的。因此，模塊內的程序可以訪問模塊內的目錄。
     *   因為模塊內的類和包可以相互訪問，並且可以訪問那些已經被模塊描述符明確指定的外部依賴。
     * 5.module-info.javaは空にはできない ❌　
     * 　module-info.java必須要有內容。❌　
     * 　-> 何も利用せず、何も公開しないモジュールであれば、module-info.java内を空にすることはできます
     *      如果什麼都不使用和公開，可以無任何內容。
     */
    public void test_q43() {
    }

    /**
     * 🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：Math API
     * 需要補足知識：Math API
     * 複習：查看總結
     * 總結：Math.pow 的入參是 double
     */
    public void test_q46() {
        int i = (int)Math.pow(2,5);
        System.out.println(i);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：java 指令
     * 需要補足知識：java 指令
     * 複習：查看總結
     * 總結：
     * 1.如果要不使用 javac 命令直接執行 java 文件，需要帶上 .java
     *   如果沒有帶上 .java 尋找的將會是 .class 文件（Java 11）
     */
    public void test_q48() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：var
     * 需要補足知識：var
     * 複習：
     * 總結：
     */
    public void test_q51() {
        var arr1 = new ArrayList<>(List.of(1,2,3));
        arr1.forEach(val -> {
            if(val != null) System.out.println(val.getClass());
        });
        System.out.println("--------------");
        var arr2 = new ArrayList<>();
        arr2.forEach(val -> {
            if(val != null) System.out.println(val.getClass());
        });
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：接口
     * 需要補足知識：具有繼承關係的接口，多實現
     * 複習：查看總結
     * 總結：
     * 1.Java 允許一個類實現多個具有相同方法聲明的接口，即使這些接口之間存在繼承關係。
     * 2.如果有繼承關係，實現類優先調用子接口的方法（默認方法）
     * 3.實現類必須實現所有的抽象方法
     */
    public void test_q55() {
    }

    /**
     * 🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：import package
     * 需要補足知識：import package
     * 複習：查看總結
     * 總結：兩者都是使用相對路徑，import package 根目錄是一樣的
     */
    public void test_q57() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/09/17
     * 題目考點：==
     * 需要補足知識：基本數據類型 引用數據類型 的比較
     * 複習：查看總結
     * 總結：
     * 1.Integer代表了整數，而Double代表了浮點數。即使底層的基本數據類型可以通過強轉進行轉換（例如，通過截斷小數部分將double轉換為int），
     *   這並不意味著對應的包裝類型也可以進行相同的轉換。在Java中，包裝類型是不同的類，並且沒有共同的繼承結構，所以你不能直接強制轉換它們。
     * 2. == 用於基本數據類型，用來比較兩者個值，用於引用數據類型用來比較兩者的地址（沒有重寫的情況下），
     *   引用數據類型和基本數據類型不能使用 == 做比較，如果可以那是因為包裝類的自動拆箱。
     * 3.當使用 == 比較兩個基本數據類型的時候，較小的數據類型會被提升到較大的數據類型然後做比較。
     */
    public void test_q59() {
        Integer i1 = Integer.valueOf(5);
        Double d1 = Double.valueOf(5.5);
        int i2 = 5;
        double d2 = 5.5;
        double d3 = 5.0;
        System.out.println(i2 == i1);
        System.out.println(i2 == d1);
        // System.out.println(i2 == (Integer) d1);
        System.out.println(i2 == (int) d2);

        System.out.println(i2 == d3);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：import
     * 需要補足知識：import
     * 複習：查看 q60
     * 總結：
     * 1.import 並不會真正的載入包，主要的功能在於減少代碼，不必每次使用類都提供完整的包名稱。
     * 2.import 關鍵字確實將特定的類或整個包導入到當前的源文件中。
     *   不過這並不意味着它會載入整個包中的所有內容，只有在實際使用到某個類的時候，該類才會被載入到JVM中。
     */
    public void test_q60() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：Java 性能
     * 需要補足知識：Java 性能，日文
     * 複習：查看總結
     * 總結：
     * Javaが高いパフォーマンスを実現していることと関連する説明として、適切なものを選びなさい。
     * 1.Javaの標準ライブラリは、パイプライン処理を行うための組み込み関数を持っている ❌
     *   Java的標準庫具有用於管道處理的內置函數 ❌
     *   ->Javaでは、パイプライン処理をサポートするような標準ライブラリを提供していません。
     *   這個選項與Java的高性能沒有直接關係。管道處理主要與流程控制和數據處理有關，但不是Java性能最佳化的關鍵特性。
     * 2.Javaは頻繁に実行されるコードを監視して、実行を最適化する　⭕
     *   Java會對頻繁執行的代碼進行監視並優化執行　⭕
     *   ->Java的即時編譯器（JIT編譯器）會監視頻繁執行的代碼區域，並將其轉換為本地機器代碼，從而提高執行效率。
     * 3.Javaはガベージコレクションをアプリケーションのコードよりも優先して処理する ❌
     *   Java將垃圾收集處理優先於應用程序代碼 ❌
     *   ->垃圾收集是Java的內存管理機制，但它並不是優先於應用程序代碼執行。
     *     垃圾收集的目的是釋放不再使用的內存，但它通常在背景中運行，不會覆蓋應用程序的正常執行。
     * 4.Javaは自動的にコードを並列処理する ❌
     *   Java自動將代碼並行處理 ❌
     *   ->Java支持多線程和並行處理，但這需要程序員明確編寫和控制。Java並不會自動將代碼轉換為並行執行，因此這個選項與高性能實現沒有直接關係。
     */
    public void test_q67() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：CharSequence
     * 需要補足知識：CharSequence
     * 複習：查看 q68
     * 總結：
     * 1.CharSequence是Java中的一個接口，它用於表示一個可讀的字符序列。許多Java中的字符相關的類都實現了這個接口，這允許這些類的對象以一種通用的方式被訪問。
     * 以下是CharSequence的一些主要實現類和子接口：
     *   String: Java中最常用的字符序列類型。它是不可變的。
     *   StringBuilder: 一個可變的字符序列，它允許對字符序列進行有效的修改。這主要用於字符的拼接和修改操作。
     *   StringBuffer: 跟StringBuilder功能相似，但是它的大部分方法都是同步的，所以它是線程安全的。
     *   CharBuffer: 一個實現了CharSequence和Readable接口的可讀寫的字符緩衝區。它提供了一個字符序列的視圖，可用於高效的字符讀取和存儲。
     * 2.不允許傳入參數有不同的泛型，因為Java使用了泛型擦除（type erasure），在執行時泛型資訊是不可用的。
     *   因此，在編譯時檢查重寫規則時，參數的泛型類型會被擦除，只會保留原始類型。
     *   在邏輯泛型上代表不同的類型，但由於泛型擦除，編譯器無法看到。因此，這不是有效的重寫，也不是有效的重載。
     * 3.重載不關注返回類型，只要方法名一致，參數列表不一致即可，參數列表不一致，不包含泛型不同的情況。
     * 4.僅有返回值不一樣的情況，編譯器視為同一個方法，不構成重載，如果返回值是父類返回值的子類，構成協變返回類型，同樣不包含泛型不同的情況。
     */
    public void test_q68() {
        CharSequence cs1 = "This is a String"; // String實現
        CharSequence cs2 = new StringBuilder("This is a StringBuilder"); // StringBuilder實現
        CharSequence cs3 = new StringBuffer("This is a StringBuffer"); // StringBuffer實現
        CharBuffer cs4 = CharBuffer.allocate(50); // CharBuffer實現
        cs4.put("This is a CharBuffer");

        System.out.println(cs1);
        System.out.println(cs2);
        System.out.println(cs3);
        System.out.println(cs4.flip().toString());
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：基本數據類型的包裝類
     * 需要補足知識：基本數據類型的包裝類 初始值
     * 複習：查看總結
     * 總結：
     * 1.基本數據類型的包裝類的初始值是 null
     * 2.基本數據類型的包裝類，無法修改值，只能修改引用，原因是 value 值被 final 修飾
     * 3.拆箱（unboxing）是將包裝類型（如 Integer、Double、Boolean 等）轉換為其對應的基本型別（如 int、double、boolean 等）的過程。
     *   當你有一個 Integer 物件並且嘗試將其轉換為 int 時，Java會自動調用Integer.intValue()方法來完成這個轉換。
     */
    public void test_q72() {
        int[] arr1 = new int[3];
        for(int i : arr1) System.out.println(i);

        Integer[] arr2 = new Integer[3];
        for(Integer i : arr2) System.out.println(i);

        Integer[] arr3 = new Integer[3];
        // java.lang.NullPointerException
        for(int i : arr3) System.out.println(i);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：lambda
     * 需要補足知識：lambda
     * 複習：查看以下代碼，Notion
     * 總結：-
     */
    public void test_q76() {
        Function<String, String> func1 = String::toUpperCase;
        Function<String, String> func2 = x -> x.toUpperCase();
        Function<String, String> func3 = (String x) -> {
            return x.toUpperCase();
        };
        System.out.println(func1.apply("hello"));
        System.out.println(func2.apply("hello"));
        System.out.println(func3.apply("hello"));
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：靜態方法
     * 需要補足知識：靜態方法
     * 複習：查看 q78
     * 總結：靜態方法是在被調用時才會被加載
     * 在Java中，當一個類被加載和初始化時，以下步驟會發生：
     * 靜態變量初始化：靜態變量被初始化為其對應類型的默認值。
     * 靜態初始化塊執行：如果類中有靜態初始化塊（由static關鍵字修飾的代碼塊），那麼這些塊將按照它們在代碼中的順序被執行。
     * 顯式靜態變量初始化：如果靜態變量在聲明時有顯式的初始化值，這些初始化將按照它們在代碼中的順序執行。
     *   1.靜態變量初始化：當Main類被加載時，靜態變量會被初始化為其對應類型的默認值（在這種情況下是int的默認值0）。
     *   2.靜態初始化塊執行：靜態初始化塊會按照它們在代碼中的順序被執行。在這個例子中，靜態初始化塊將num的值設置為30。
     *   3.顯式靜態變量初始化：靜態變量在聲明時的初始化會按照它們在代碼中的順序執行。所以num會被重新賦值為10。
     *   4.main方法執行：當main方法被調用時，它會調用sample方法，該方法會打印num的當前值，也就是10。
     *   5.但是取值操作無法在聲明之前 java: illegal forward reference
     */
    public void test_q78() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/02
     * 最後一次查看：2023/08/02
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






