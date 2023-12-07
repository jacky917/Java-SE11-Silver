package org.example.test_1Z0816.ch12;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

@Data
public class SerializableClass implements Serializable {

    private static final long serialVersionUID = 2202956449081564588L;

    private String test1;

    private transient String test2;

    public SerializableClass(String test1,String test2) {
        this.test1 = test1;
        this.test2 = test2;
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("Function writeReplace was executed");
        this.test2 = "transient test2";
        return this;
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("Function readResolve was executed");
        this.test2 = "transient test2";
        return this;
    }

    // 自定義readObject方法
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        System.out.println("Function readObject was executed");
        ois.defaultReadObject(); // 默認反序列化過程，恢復非transient字段

        // 為transient字段設置默認值
        this.test2 = "100";
    }

    // 自定義序列化邏輯
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        System.out.println("Function writeObject was executed");
        out.defaultWriteObject();
    }

    @Override
    public String toString() {
        return "SerializableClass{" +
                "test1='" + test1 + '\'' +
                ", test2='" + test2 + '\'' +
                '}';
    }
}
