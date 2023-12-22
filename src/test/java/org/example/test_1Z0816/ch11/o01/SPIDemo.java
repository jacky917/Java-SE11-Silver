package org.example.test_1Z0816.ch11.o01;

import java.util.ServiceLoader;

/**
 * SPI（Service Provider Interface）是一種Java平台提供的服務發現機制，用於允許服務提供者為介面或抽象類別提供實現，
 *     同時使服務使用者能夠找到並利用這些實作。 這種機制在Java中廣泛用於實現模組化、可插拔的架構，進而提高軟體的可擴充性和可維護性。
 * 工作原理
 *    服務接口定義：先定義一個服務接口，它是一個普通的Java接口，用來規定服務提供的功能。
 *    服務提供者實作：服務提供者實作了這個接口，並將其具體實作打包在JAR檔中。
 *    服務註冊：服務提供者透過在其JAR檔案的 META-INF/services 目錄下建立以服務介面全限定名命名的檔案來註冊服務。 該文件中包含了服務實作類別的全限定名。
 *    服務發現：服務使用者可以透過 ServiceLoader API來載入和使用這些服務。 ServiceLoader 會自動尋找並載入可用的服務實作。
 * 使用場景
 *    驅動載入：JDBC是SPI的典型應用範例。 資料庫驅動程式實作了JDBC接口，並透過SPI機制被Java應用程式發現和載入。
 *    插件系統：軟體可以透過SPI來支援插件，允許第三方開發者提供額外的功能實作。
 *    服務提供：許多Java框架和函式庫使用SPI來提供擴充點，讓其他開發者為框架提供額外服務或處理器。
 * 優點
 *    解耦：SPI提供了一種方式，使得服務介面的定義與其實作解耦，增加了系統的靈活性。
 *    動態服務發現：應用程式可以動態地發現和使用服務，而不需要在編譯時就確定具體的實作。
 *    可擴充性：SPI機制讓新增新的服務實作變得簡單，無需修改原系統程式碼。
 */
public class SPIDemo {
    public static void main(String[] args) {
        ServiceLoader<Test> loader = ServiceLoader.load(Test.class);
        for (Test test : loader) {
            System.out.println("!");
            System.out.println(test);
        }
    }
}
