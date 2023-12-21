package org.example.test_1Z0816.ch12.o01;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

/**
    java.text.Normalizer 是用於解決 Unicode 字串中因字元多種可能表示方式而引起的問題的 Java 工具類別。
    其主要目的是確保文字字串在處理、儲存和比較時的一致性和標準化。

     1. 字元的多重表示
        在 Unicode 中，相同的視覺字元可能有多種不同的編碼表示方法。 例如，一個帶有重音的字符可能是一個預先組合字符，也可能是基礎字符加上組合標記。
        這種多重表示可能導致在字串比較、搜尋和排序時出現不一致的結果。
     2. 文本一致性與可比較性
        Normalizer 透過將文字轉換為其正規化形式（NFD、NFC、NFKD、NFKC），確保字元的一致表示，使得不同來源的文字資料可以一致地處理和比較。
     3. 相容性和國際化
        Unicode 需要相容於多種語言和舊字元編碼系統。Normalizer 支援這種相容性，同時也適應不同語言和文化的特定需求。
        在處理國際化應用程式時，特別是涉及多語言環境的應用，正規化確保了文字處理的準確性和一致性。
     4. 安全性
        在網路安全領域，Normalizer 可以幫助防止基於字元編碼的漏洞和攻擊，如同形攻擊，確保文字處理的安全性。
     5. 資料儲存和傳輸
        正規化後的文字在儲存和傳輸時更加高效，因為它可以減少不必要的字元表示多樣性，降低儲存空間和傳輸頻寬的需求。
     綜上所述，java.text.Normalizer 的引入是為了解決Unicode 字串多樣性所帶來的問題，提供一種標準和一致的方式來處理國際化文本，確保字元資料的一致性、可用性和安全性。
 */
public class NormalizerDemo {
    public static void main(String[] args) throws IOException {
        // 原始字符串，包含組合字元（例如：拉丁字母E與重音符號）
        String original = "É";

        // 將字符串轉換為NFD形式
        String nfd = Normalizer.normalize(original, Normalizer.Form.NFD);
        System.out.println("NFD: " + nfd);

        // 將字符串轉換為NFC形式
        String nfc = Normalizer.normalize(original, Normalizer.Form.NFC);
        System.out.println("NFC: " + nfc);

        // 將字符串轉換為NFKD形式
        String nfkd = Normalizer.normalize(original, Normalizer.Form.NFKD);
        System.out.println("NFKD: " + nfkd);

        // 將字符串轉換為NFKC形式
        String nfkc = Normalizer.normalize(original, Normalizer.Form.NFKC);
        System.out.println("NFKC: " + nfkc);


        // 確保在讀取資料時進行正確的Unicode正規化，涉及幾個關鍵步驟，特別是當處理來自外部來源（如檔案、資料庫或網路）的文字資料時。 以下是一些確保資料正確正規化的方法：
        //
        //  1. 正確地編碼和解碼文本
        //      在讀取文字資料時，請確保使用正確的字元編碼（如UTF-8）。 這通常在讀取檔案、資料庫資料或網路回應時指定。
        //      例如，在Java中讀取檔案時，可以使用 InputStreamReader 並指定編碼：
        BufferedReader reader = new BufferedReader(
             new InputStreamReader(new FileInputStream("data.txt"), StandardCharsets.UTF_8));
        //  2. 應用正規化
        //      在文字資料被讀入後，使用 java.text.Normalizer 對其進行正規化。
        //      選擇適當的正規化形式（NFD、NFC、NFKD、NFKC）取決於應用場景和特定需求。
        String line;
        while ((line = reader.readLine()) != null) {
            String normalized = Normalizer.normalize(line, Normalizer.Form.NFC);
            // 處理正規化後的文本
        }
        //   3. 一致性
        //      在整個應用程式中保持一致的正規化策略。 例如，如果在資料庫中儲存文字數據，應確保在儲存之前應用了相同的正規化形式。
        //   4. 處理外部數據
        //      當處理來自外部的資料（如使用者輸入、第三方API回應）時，特別注意應用正規化，因為這些資料可能以不同的形式表示相同的字元。
        //   5. 測試和驗證
        //      對於國際化應用程序，透過使用多種語言和字元集進行測試來驗證正規化是否按預期工作。
        //      包括特殊字元和邊緣情況在內的測試，可以幫助確保應用程式能夠正確處理各種文字資料。
        //   注意事項
        //      正規化可能會改變字串的長度和某些字元的外觀，這在處理某些文字（如密碼欄位）時需要特別注意。
        //      在某些情況下，正規化可能不是必須的，或者可能需要特定形式的正規化，這取決於特定的業務需求和文字處理場景。
        //      綜上所述，正確的編碼/解碼策略結合適當的Unicode正規化是確保讀入文字資料正確性的關鍵。 這在處理國際化和多語言文本時尤其重要。


        // Java 的 .policy 檔案用於定義安全性原則，它指定了Java應用程式的權限集。 這些檔案通常用於與 SecurityManager 結合使用，以控制應用程式的安全行為。
        // .policy 檔案是以文字格式編寫的，可以包含一系列授權條款（grant entries），每個條款定義了一組權限。
        // .policy 文件通常包含以下幾個部分：
        //   授權條款（Grant Entries）：每個授權條款定義了一組權限，並且可以指定適用於特定程式碼來源的條件。
        //   權限（Permissions）：每個授權條款中都列出了一系列權限，這些權限定義了允許執行的操作，例如檔案讀取和寫入、網路存取等。
        //   可選的屬性：可以指定程式碼簽署者或程式碼位置等屬性，以進一步細化授權規則的適用範圍。
        //   授權條款以 grant 關鍵字開始，後面跟著一對花括號 {}，花括號內包含一系列的權限宣告。 基本格式如下：
        //   grant {
        //       permission java.security.Permission "target_name", "action";
        //       // 更多權限...
        //   };
        //   grant {
        //       // 允許讀取所有文件
        //       permission java.io.FilePermission "<<ALL FILES>>", "read";
        //       // 允許連接到本機主機上的所有端口
        //       permission java.net.SocketPermission "localhost:1024-", "connect";
        //   };
        // 高級用法
        //   grant codeBase "file:/path/to/myapp/-" {
        //       permission java.io.FilePermission "/path/to/myapp/data/-", "read,write";
        //   };
        //   只有從/path/to/myapp/目錄載入的程式碼被授權讀寫/path/to/myapp/data/目錄下的檔案。
    }
}
