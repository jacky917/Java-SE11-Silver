package org.example.ch12.o2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src//test//java/org//example//ch12//o2/file.txt");
        System.out.println(file.getAbsolutePath());
        try (FileReader fileReader = new FileReader(file)){
            int data = fileReader.read();
            while(data != -1) {
                System.out.println(data);
                data = fileReader.read();
            }
        }
    }
}
