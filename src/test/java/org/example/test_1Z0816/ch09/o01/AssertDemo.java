package org.example.test_1Z0816.ch09.o01;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

public class AssertDemo {
    public static void main(String[] args) {
        try {
            Computer computer1 = new Computer();
            // Exception in thread "main" java.lang.NullPointerException
            computer1.ComputerStartsUp();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            Computer computer2 = new Computer();
            // junit 所提供的
            // Exception in thread "main" junit.framework.AssertionFailedError: 沒有記憶體電腦無法開機
            Assert.assertNotNull("沒有記憶體電腦無法開機",computer2.getRam());
            computer2.ComputerStartsUp();
        } catch (AssertionFailedError e) {
            e.printStackTrace();
        }

        try {
            Computer computer2 = new Computer();
            // java 所提供的，需要手動開啟才會生效（加上參數 -ea）
            // Exception in thread "main" java.lang.AssertionError: 沒有記憶體電腦無法開機
            assert computer2.getRam() != null : "沒有記憶體電腦無法開機";
            computer2.ComputerStartsUp();
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }
}
