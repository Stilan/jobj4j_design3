package ru.job4j.files;

import java.io.*;

public class ReaderFiles {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\d", ""); // Удаляем цифры
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
