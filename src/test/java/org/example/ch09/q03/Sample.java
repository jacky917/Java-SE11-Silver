package org.example.ch09.q03;

public class Sample implements Comparable<Sample>{
    private int id;
    private String name;
    public Sample(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Sample s) {
        // 第一個參數較小，排前面
        if (this.id < s.getId()) {
            return 1;
        }
        // 第二個參數較小，排前面
        if (this.id > s.getId()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
