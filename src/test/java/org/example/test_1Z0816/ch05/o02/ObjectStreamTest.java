package org.example.test_1Z0816.ch05.o02;

import org.example.test_1Z0816.ch05.util.Utils;

import java.io.*;
import java.nio.file.Path;

/**
 * 自定義一個類，並序列化（保存）和反序列化（讀出）
 * 並且演示如果沒有serialVersionUID會導致什麼問題
 */
public class ObjectStreamTest {
    public static void main(String[] args) {

        Path path = Utils.getPathWithDir("o02");

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path + File.separator + "object.dat"))) {
            objectOutputStream.writeObject(new MyObject(0,"name","transientTest"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path + File.separator + "object.dat"))){
            System.out.println(objectInputStream.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
