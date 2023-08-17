package org.example.test_1Z0815.ch12.q49;

public class Sample {
    int a;
    int b;
    int c;
    int d;

    void setA(int a) {
        a = a;
    }

    void setB(int b) {
        this.b = b;
    }

    int setC() {
        return c;
    }
    int setD(int num) {
        d = num;
        return d;
    }

    public void setAll(int x) {
        a = b = this.c = setD(x);
    }

    @Override
    public String toString() {
        return "Sample{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
