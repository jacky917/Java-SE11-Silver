package org.example.test_1Z0816.ch01.q16;

public enum Sample {
    A("helloA"),B("helloB"),C("helloC");

    private final String value;

    // 枚舉類的構造器必定為 private (可以不明寫)
    private Sample(String value) {
        System.out.println(value);
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }
}
