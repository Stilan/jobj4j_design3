package ru.job4j.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class FilesInput {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            String text = "";
            int read;
            while ((read = fileInputStream.read()) != -1) {
                text += (char) read;
            }
            System.out.println(text);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            text = text.toUpperCase(Locale.ROOT);
            fileOutputStream.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
