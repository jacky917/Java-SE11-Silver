package org.example.test_1Z0816.ch09.o01;

import lombok.Data;

@Data
public class Computer {
    private Ram ram;

    public void ComputerStartsUp() {
        System.out.println("電腦開機，記憶體容量：" + ram.getSize());
    }
}
