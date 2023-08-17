package org.example.test_1Z0815.ch13.q01;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            test(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void test(int num) throws IOException,IndexOutOfBoundsException {
        if (num < 10) {
            throw new FileNotFoundException();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
