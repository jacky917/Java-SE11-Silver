package org.example.test_1Z0816.ch05.o03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

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

        // 實現 FileVisitor 接口，並將你的 FileVisitor 實例傳遞給 Files.walkFileTree 方法來遍歷檔案系統。
        // 例如，可以創建一個 FileVisitor 來搜索特定檔案或收集關於檔案的信息。


//        Files.walkFileTree(path1, new SimpleFileVisitor<Path>() {
//            @Override
//            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                // 在此處理檔案
//                return FileVisitResult.CONTINUE;
//            }
//        });

        // Files.walk 是 Java 8 引入的一個方法，它會傳回一個 Stream<Path>，
        // 代表從起始路徑開始遞歸遍歷的所有檔案和目錄。 這個方法使得使用流操作處理檔案系統變得簡單。
        Path start = Paths.get("start-directory");
        try (Stream<Path> stream = Files.walk(start)) {
            stream.forEach(System.out::println);
        }

        // Files.walkFileTree 是一個更早的方法，它提供了更高的控制和靈活性。
        // 需要提供一個 FileVisitor 實作來指定在存取每個檔案和目錄時要執行的操作。
        Path startPath = Paths.get("path/to/start/directory"); // 設置起始目錄路徑
        Files.walkFileTree(startPath, new PrintFiles());

        // 總的來說，Files.walk 更適合簡單的遍歷任務和流程操作，而 Files.walkFileTree 提供了更高的靈活性和控制力，適用於更複雜的檔案遍歷和處理任務。
    }

    /**
     * 以下是一個簡單的示例，顯示了如何實現 FileVisitor 來遍歷文件系統中的所有文件和目錄：
     */
    private static class PrintFiles implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            System.out.println("正在訪問目錄: " + dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            System.out.println("訪問文件: " + file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.err.println("訪問文件失敗: " + file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            System.out.println("完成訪問目錄: " + dir);
            return FileVisitResult.CONTINUE;
        }
    }

}
