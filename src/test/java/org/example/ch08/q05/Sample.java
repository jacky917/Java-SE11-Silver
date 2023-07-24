package org.example.ch08.q05;

import java.util.Objects;

public class Sample {
    private int num;
    public Sample(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sample sample = (Sample) o;
        return num == sample.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
