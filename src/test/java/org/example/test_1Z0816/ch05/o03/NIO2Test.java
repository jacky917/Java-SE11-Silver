package org.example.test_1Z0816.ch05.o03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * NIO2提供的高級API的基本使用
 */
public class NIO2Test {
    public static void main(String[] args) throws IOException {

        // java.nio.file.Path
        // Path 接口代表檔案系統中的路徑。無論是檔案還是目錄，都可以用 Path 來表示。它提供了多種方法來處理檔案路徑，例如：
        // 解析路徑 (resolve)。
        // 路徑比較 (startsWith, endsWith)。
        // 獲取路徑的各個部分（如文件名 getFileName，父路徑 getParent）。
        // 轉換為絕對路徑 (toAbsolutePath) 或標準路徑 (normalize)。
        // 轉換為 File 對象 (toFile) 或 URI (toUri)。

        // 使用 Paths 類中的靜態方法 get 來獲取 Path 的實例
        Path path1 = Paths.get("/home/user/docs");

        // java.nio.file.Files
        // Files 類提供了靜態方法來執行檔案操作，比如檔案的讀寫、複製、移動、刪除等，以及檔案屬性的讀取和設置。例如：
        // 讀取檔案到字節數組 (readAllBytes) 或行列表 (readAllLines)。
        // 寫入字節數組或行列表到檔案 (write)。
        // 複製、移動或刪除檔案 (copy, move, delete)。
        // 檢查檔案是否存在 (exists) 或是否可讀 (isReadable)。
        Path path2 = Paths.get("/home/user/docs/myfile.txt");
        List<String> lines = Files.readAllLines(path2, StandardCharsets.UTF_8);

        // java.nio.file.FileVisitor
        // FileVisitor 是一個接口，用於遍歷檔案樹（file tree）。這是訪問者模式（Visitor Pattern）的應用，
        // 允許定義在遍歷過程中對每個檔案和目錄執行的動作。這個接口定義了四個方法：
        // preVisitDirectory：訪問目錄之前呼叫。
        // visitFile：訪問檔案時呼叫。
        // visitFileFailed：訪問檔案失敗時呼叫，比如檔案無法訪問。
        // postVisitDirectory：訪問目錄之後呼叫。

        // 實現FileVisitor接口，並將你的 FileVisitor 實例傳遞給 Files.walkFileTree 方法來遍歷檔案系統。
        // 例如，你可以創建一個 FileVisitor 來搜索特定檔案或收集關於檔案的信息。
        Files.walkFileTree(path1, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                // 在此處理檔案
                return FileVisitResult.CONTINUE;
            }
        });

    }

}
