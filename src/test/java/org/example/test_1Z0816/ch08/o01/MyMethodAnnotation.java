package org.example.test_1Z0816.ch08.o01;

import java.lang.annotation.*;

/**
 * 元註解（Meta-annotations）是一種特殊類型的註解，它們被用來註解其他的註解。
 * 元註解提供了關於註解如何被處理和使用的資訊。 以下是 Java 中可用的元註解：
 */
//@Target https://www.notion.so/Java-Target-2eb03da312e949f5b84cd0a7b2828eb2
@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE}) // 指定了註解可以應用的 Java 元素類型（如類別、方法、欄位等）。
@Retention(RetentionPolicy.RUNTIME)
/* @Retention() 定義了註解的保留策略，即註解在什麼階段有效（原始碼、類別檔案、執行時期）。
 * SOURCE：註解只在原始碼中保留，編譯器編譯時會丟棄這些註解，因此它們不會出現在字節碼檔案中。
 * CLASS：註解在編譯後的字節碼檔案中保留，但在執行時不會被虛擬機器保留。 這是預設的保留策略。
 * RUNTIME：註解在編譯後的字節碼檔案中保留，並且可以透過反射在執行時被讀取。*/
@Documented   // 指示將註解資訊包含在 Javadoc 中。
@Inherited    // 表示註解可以從超類別繼承。子類將擁有父類的注解。
@MyRepeatableAnnotation
@MyRepeatableAnnotation
/* 可重用註解 @Repeatable() Java 8 引入的，它允許同一個註解在同一聲明上多次使用。使用要求：
 * 1.需要再定義一個接收注解數組的注解
 * 2.兩個注解的例如 @Target @Retention @Documented 等等需要一致
 * 3.在非數組的注解上聲明 @Repeatable(MyRepeatableAnnotations.class) 參數是數組注解 */
public @interface MyMethodAnnotation {

    // Annotation 的成員變量，是以無參數方法的形式聲明的，只能使用以下類型：
    // String Class enum Annotation 以及以上所有的數組類型
    String value() default "default";
}