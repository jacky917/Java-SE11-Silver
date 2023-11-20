package org.example.test_1Z0816.ch05.o02;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyPrintStream extends PrintStream {

    // 用於寫入文件
    private final OutputStream secondOutputStream;


    // OutputStream 輸出的抽象基類
    // PrintStream 打印流
    public MyPrintStream(OutputStream out,PrintStream secondPrintStream) {
        super(out);
        this.secondOutputStream = secondPrintStream;
    }

    /**
     * 重寫write方法，使得每次通過System.out.print/println
     * 輸出時，都會將內容重定向到指定的文件和控制台
     */
    @Override
    public void write(byte[] buf, int off, int len) {
        try {
            synchronized (this) {
                super.write(buf, off, len);
                super.flush();
                secondOutputStream.write(buf, off, len);
                secondOutputStream.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException("寫入失敗", e);
        }
    }

    @Override
    public void close() {
        synchronized (this) {
            super.close();
            try {
                secondOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
