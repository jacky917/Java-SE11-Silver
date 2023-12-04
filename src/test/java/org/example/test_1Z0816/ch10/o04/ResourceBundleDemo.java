package org.example.test_1Z0816.ch10.o04;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

    /**
     *
     * @param args
     *
     * 1.ResourceBundle 是 Java 平台中用於國際化（Internationalization）和本地化（Localization）的一個重要類。
     *   這個類提供了一種靈活的方式來分離本地特定的數據（例如文本和標籤）從應用程序的邏輯代碼中。這使得應用程序可以輕鬆地適應不同語言和地區設置，而無需更改原始代碼。
     * 2.找不到資源時報錯
     *   Exception in thread "main" java.util.MissingResourceException: Can't find bundle for base name Messages, locale zh_TW
     *
     */
    public static void main(String[] args) {
        // 設定語言和地區
        Locale locale = new Locale("zh", "TW");
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);

        // 獲取並打印資源
        System.out.println(messages.getString("greeting"));
    }
}
