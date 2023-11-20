package org.example.test_1Z0816.ch05.o02;

import lombok.Data;

import java.io.Serializable;

/**
 * 沒有實現Serializable會報java.io.NotSerializableException異常
 */
@Data
public class MyObject implements Serializable {
    private int id;
    private String name;

    private final static String staticTest = "staticTest";

    private transient String transientTest;

    public MyObject () {

    }

    public MyObject(int id, String name, String transientTest) {
        this.id = id;
        this.name = name;
        this.transientTest = transientTest;
    }
}
