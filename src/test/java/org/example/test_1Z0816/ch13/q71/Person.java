package org.example.test_1Z0816.ch13.q71;

import java.io.ObjectStreamField;
import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String ssn; // Social Security Number

    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("name", String.class),
            new ObjectStreamField("age", int.class)
    };
}
