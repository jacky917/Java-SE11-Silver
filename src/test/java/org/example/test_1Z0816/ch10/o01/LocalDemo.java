package org.example.test_1Z0816.ch10.o01;

import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

/**
 * 獲取或是創建Locale的各種方式，Locale並不是單例的，可以創建多個實例。
 * localDateTime 不包含時區，ZonedDateTime包含時區，Instant 包含時區，但它總是在 UTC 時區。 它用於表示一個特定的瞬間，且總是以 UTC（協調世界時）為基準。
 *
 */
public class LocalDemo {
    public static void main(String[] args) throws InterruptedException {

        // 新舊API的替代關係
        // 代替 Calendar
        // LocalDate,LocalTime,LocalDateTime,ZoneId,ZoneDateTime
        // 代替 Date -> Instant
        // 代替 SimpleDateFormat -> DateTimeFormatter
        // 其他補充 Period,Duration

        // 舊的Java時間處理
        // Calendar 非單例
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        System.out.println(instance1 == instance2);

        LocalDate localDate = LocalDate.of(2000, 1, 1);
        LocalTime localTime = LocalTime.of(10, 10, 10);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        ZoneId taipeiZoneId = ZoneId.of("Asia/Taipei");

        System.out.println("========DateTimeFormatter========");

        // DateTimeFormatter
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));   // 20231204
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));   // 2023-12-04
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_TIME));   // 19:54:21.159051
        System.out.println(date.format(DateTimeFormatter.ISO_ORDINAL_DATE)); // 2023-338

        // 自定義 DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String customFormattedDate = now.format(formatter);
        System.out.println(customFormattedDate);

        System.out.println("========NumberFormat========");

        // NumberFormat 用於格式化數字（包括貨幣、百分比）到字符串，或將字符串解析為數字。
        NumberFormat instance = NumberFormat.getInstance();
        NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        NumberFormat percentInstance = NumberFormat.getPercentInstance();

        System.out.println(instance.format(1000.1));         // 1,000.1
        System.out.println(integerInstance.format(1000.1));  // 1,000
        System.out.println(currencyInstance.format(1000.1)); // ¥1,000
        System.out.println(percentInstance.format(1000.1));  // 100,010%


        ZonedDateTime taipeZonedDateTime = localDateTime.atZone(taipeiZoneId);
        ZonedDateTime systemZonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

        // 轉換為 Instant
        Instant instant = systemZonedDateTime.toInstant();

        System.out.println(localDateTime);


        // 直接構造:可以使用 Locale 的構造函數直接創建實例。Locale 有幾個不同的構造函數，允許你指定語言、國家/地區，甚至是變種。
        Locale locale1 = new Locale("en");  // 只指定語言
        Locale locale2 = new Locale("en", "US");  // 指定語言和國家/地區
        Locale locale3 = new Locale("en", "US", "WIN");  // 指定語言、國家/地區和變種(指的是一個特定地區或國家內部的額外訊息)
        Locale locale4 = new Locale("ja");
        // 主な言語コード（ISO639-1）
        // 日本語　　　ja
        // 英語　　　　en
        // ドイツ語　　de
        // 中国語　　　zh
        // フランス語　fr
        // 主な言語コード（ISO3166-1）
        // 日本語　　　JP
        // 英語　　　　US
        // ドイツ語　　DE
        // 中国語　　　CN
        // フランス語　FR

        System.out.println(locale3.getLanguage());
        System.out.println(locale4.getLanguage());

        // 靜態工廠方法:Locale 類提供了一些靜態工廠方法，例如 forLanguageTag，用於根據語言標籤創建實例。
        Locale locale = Locale.forLanguageTag("en-US");  // 創建美國英語的 Locale

        // 常用預定義:Locale 類還預定義了一些常用的 Locale 實例作為靜態常量
        Locale usLocale = Locale.US;  // 獲取美國 Locale
        Locale chinaLocale = Locale.CHINA;  // 獲取中國 Locale

        // Locale.Builder:從 Java 7 開始，你可以使用 Locale.Builder 類來構建 Locale 對象。這提供了一種更靈活的方式來設置 Locale 的不同部分。
        Locale locale5 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("GB")
                .build();  // 創建英國英語的 Locale

        // 系統默認 Locale
        Locale defaultLocale = Locale.getDefault();  // 獲取 JVM 默認的 Locale

    }
}
