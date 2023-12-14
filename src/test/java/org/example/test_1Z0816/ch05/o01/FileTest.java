package org.example.test_1Z0816.ch05.o01;

import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Java中的File可以用來表示文件或是目錄
 * Java判斷是否為文件夾不是靠副檔名判斷的，而是實際上文件夾是否存在
 * File只是Java中用來表示路徑的，並非檔案或是文件夾本身
 */
public class FileTest {

    public  static void creatFile(File file) {
        // 創建新文件
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        System.out.println("當前工作目錄: " + userDir);


        String classPath = FileTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("當前類的目錄: " + classPath);

//        Path filePath = Paths.get(userDir, "src", "test", "java", "org", "example", "test_1Z0816", "ch05", "o01");
        Path filePath = Paths.get(userDir + "/src/test/java/org/example/test_1Z0816/ch05/o01");

        System.out.println("文件路徑: " + filePath);

        // 通過文件路徑創建File對象
        File file = new File(filePath + File.separator + "test1.txt");
        creatFile(file);

        // 通過父路徑和子路徑字符串創建File對象
        File fileWithParent = new File(filePath.toString(), "test2.txt");
        creatFile(fileWithParent);

        // 通過父File對象和子路徑字符串創建File對象
        File parentDir = new File(filePath.toString());
        File fileWithParentFile = new File(parentDir, "test3.txt");
        creatFile(fileWithParentFile);

        System.out.println(parentDir.isDirectory());
        System.out.println(parentDir.isFile());
        System.out.println(fileWithParentFile.isDirectory());
        System.out.println(fileWithParentFile.isFile());

        System.out.println("================================");

        String test = filePath + File.separator + "dir";

        System.out.println(test);

        File testFile = new File(test);
        System.out.println(testFile.isDirectory());

        if(testFile.mkdirs())
            System.out.println("成功創建");
        System.out.println(testFile.isDirectory());

        System.out.println("================================");

        File fileOrDir = new File("path/to/your/fileOrDirectory");

        if (fileOrDir.exists()) {
            if (fileOrDir.isDirectory()) {
                System.out.println("這是一個目錄");
            } else if (fileOrDir.isFile()) {
                System.out.println("這是一個文件");
            }
        } else {
            System.out.println("這個路徑不是一個文件也不是一個目錄，或者它根本就不存在");
        }
    }
}
