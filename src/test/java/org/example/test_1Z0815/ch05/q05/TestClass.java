package org.example.test_1Z0815.ch05.q05;

/**
 * boolean: 預設值為 false
 * byte: 預設值為 0
 * short: 預設值為 0
 * int: 預設值為 0
 * long: 預設值為 0L
 * float: 預設值為 0.0f
 * double: 預設值為 0.0d
 * char: 預設值為 \u0000（也就是Unicode的空字符）
 */
public class TestClass {
    public boolean myBoolean;
    public byte myByte;
    public short myShort;
    public int myInt;
    public long myLong;
    public float myFloat;
    public double myDouble;
    public char myChar;

    @Override
    public String toString() {
        return "TestClass{" +
                "myBoolean=" + myBoolean +
                ", myByte=" + myByte +
                ", myShort=" + myShort +
                ", myInt=" + myInt +
                ", myLong=" + myLong +
                ", myFloat=" + myFloat +
                ", myDouble=" + myDouble +
                ", myChar=" + myChar +
                '}';
    }
}
