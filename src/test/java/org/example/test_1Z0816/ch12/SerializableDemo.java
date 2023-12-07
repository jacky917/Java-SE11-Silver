package org.example.test_1Z0816.ch12;


import org.example.util.Utils;

import java.io.*;
import java.nio.file.Path;


/**
 * writeReplace 和 readResolve 專注於替換序列化或反序列化的物件。
 * writeObject 和 readObject 專注於控制物件的實際序列化和反序列化過程。
 * defaultWriteObject 和 defaultReadObject 用於輔助 writeObject 和 readObject 方法，提供預設的序列化和反序列化行為。
 */
public class SerializableDemo {

    /**
     * 序列化 SerializableClass 對象
     * @param obj 目標對象
     * @param filename 目標文件
     */
    public static void serialize(SerializableClass obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化 SerializableClass 對象
     * @param filename 目標文件
     * @return 對象
     */
    public static SerializableClass deserialize(String filename) {
        SerializableClass obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            obj = (SerializableClass) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static void main(String[] args) {

        Path path = Utils.getPath("test_1Z0816/ch12");

        SerializableClass serializableClass = new SerializableClass("s1", "s2");
        serialize(serializableClass, path + "/serializableclass.ser");

        System.out.println("====================");

        SerializableClass obj = deserialize(path + "/serializableclass.ser");
        if (obj != null) {
            System.out.println("Deserialized SerializableClass Object: ");
            System.out.println(obj);
        }
    }
}
