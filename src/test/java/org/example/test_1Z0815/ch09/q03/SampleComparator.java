package org.example.test_1Z0815.ch09.q03;

import java.util.Comparator;

public class SampleComparator implements Comparator<Sample> {

    @Override
    public int compare(Sample s1, Sample s2) {
        // 第一個參數較小時，第一個參數排後面
        if (s1.getId() < s2.getId()) {
            return 1;
        }
        // 第二個參數較小時，第二個參數排後面
        if (s1.getId() > s2.getId()) {
            return -1;
        }
        return 0;
    }
}
