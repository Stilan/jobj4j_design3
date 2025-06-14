package ru.job4j.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class ByteStream {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("input.bin");
            int read;
            while ((read = fileInputStream.read()) != -1) {
                System.out.println(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
